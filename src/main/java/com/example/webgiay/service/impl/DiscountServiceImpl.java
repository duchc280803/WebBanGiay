package com.example.webgiay.service.impl;

import com.example.webgiay.dto.DiscountDTO;
import com.example.webgiay.dto.DiscountDetailDTO;
import com.example.webgiay.dto.ProductDTO;
import com.example.webgiay.entity.Discount;
import com.example.webgiay.entity.DiscountProduct;
import com.example.webgiay.entity.Product;
import com.example.webgiay.repository.DiscountProductRepository;
import com.example.webgiay.repository.DiscountRepository;
import com.example.webgiay.repository.ProductRepository;
import com.example.webgiay.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private DiscountProductRepository discountProductRepository;

    @Override
    public List<Product> getAll() {
        List<Product> getAll = productRepository.findAll();
        return getAll;
    }

    @Override
    public DiscountDTO create(DiscountDTO discountDTO) {
        // Add discount
        Discount discount = new Discount();
        discount.setMa(discountDTO.getMaDiscount());
        discount.setName(discountDTO.getName());
        discount.setDiscountType(discountDTO.getHinhThucKhuyenMai());
        if (discountDTO.getHinhThucKhuyenMai() == 1) {
            discount.setPercentageDiscount(discountDTO.getMucGiamGia());
            discount.setCashDiscount(0);
        } else {
            discount.setPercentageDiscount(0);
            discount.setCashDiscount(discountDTO.getMucGiamGia());
        }
        discount.setStartDate(discountDTO.getNgayBatDau());
        discount.setEndDate(discountDTO.getNgayKetThuc());
        discount.setStatus(1);
        discount = discountRepository.save(discount);

        //Add discount Product
        DiscountProduct discountProduct = new DiscountProduct();
        ProductDTO findByGia = productRepository.findByPrice(discountDTO.getIdSanPham());
        Product product = productRepository.getById(discountDTO.getIdSanPham());
        Discount byName = discountRepository.findFirstByName(discountDTO.getName());
        discountProduct.setProduct(product);
        discountProduct.setDiscount(byName);
        BigDecimal price = findByGia.getPrice();
        Integer mucGiamGia = discountDTO.getMucGiamGia();
        if (discountDTO.getHinhThucKhuyenMai() == 1) {
            BigDecimal phanTramTien = price.multiply(new BigDecimal(mucGiamGia)).divide(new BigDecimal(100));
            discountProduct.setUnitPrice(phanTramTien);
            discountProduct.setSoTienConLai(phanTramTien);
        } else {
            BigDecimal phanTramTien = price.subtract(new BigDecimal(mucGiamGia));
            discountProduct.setUnitPrice(phanTramTien);
            discountProduct.setSoTienConLai(phanTramTien);
        }
        discountProduct = discountProductRepository.save(discountProduct);
        return discountDTO;
    }

    @Override
    public Page<DiscountDetailDTO> getAllDtos(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo < 0) {
            pageNo = 0;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 9;
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Object[]> page = discountRepository.getAll(pageable);
        List<Object[]> listObject = page.getContent();
        List<DiscountDetailDTO> getAllDtos = listObject.stream().map(objects -> new DiscountDetailDTO(
                (String) objects[0],
                (String) objects[1],
                (Integer) objects[2],
                (Integer) objects[3],
                (String) objects[4],
                (Date) objects[5],
                (Date) objects[6],
                (Integer) objects[7])).collect(Collectors.toList());
        return new PageImpl<>(getAllDtos, pageable, page.getTotalElements());
    }

    @Override
    public DiscountDetailDTO getOneDetailDiscount(String ma) {
        List<Object[]> detailDiscountList = discountRepository.getOneDetailDiscount(ma);
        if (detailDiscountList.isEmpty()) {
            // Xử lý trường hợp không tìm thấy chi tiết khuyến mãi
            return null; // hoặc bạn có thể trả về một giá trị mặc định hoặc ném một ngoại lệ phù hợp
        }
        Object[] objects = detailDiscountList.get(0);
        String maKM = (String) objects[0];
        String tenChuongTrinh = (String) objects[1];
        Integer hinhThucKhuyenMai = (Integer) objects[2];
        Integer giamGia = (Integer) objects[3];
        String tenSanPham = (String) objects[4];
        Date ngayBatDau = (Date) objects[5];
        Date ngayKetThuc = (Date) objects[6];
        Integer trangThai = (Integer) objects[7];
        DiscountDetailDTO discountDetailDTO = new DiscountDetailDTO(maKM, tenChuongTrinh, hinhThucKhuyenMai, giamGia, tenSanPham, ngayBatDau, ngayKetThuc, trangThai);
        return discountDetailDTO;
    }

}
