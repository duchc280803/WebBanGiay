package com.example.webgiay.service.impl;

import com.example.webgiay.dto.*;
import com.example.webgiay.entity.*;
import com.example.webgiay.repository.CartDetailRepository;
import com.example.webgiay.repository.OderDetailRepository;
import com.example.webgiay.repository.OderRepository;
import com.example.webgiay.repository.ProductDetailRepository;
import com.example.webgiay.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class OderServiceImpl implements OderService {

    @Autowired
    private OderRepository oderRepository;

    @Autowired
    private OderDetailRepository oderDetailRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Override
    public OderDTO create(User user, Oder oder, List<CartDetailDTO> cartDetailDTOS, OderDTO oderDTO) {
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        oder.setRecipientName(oderDTO.getRecipientName());
        oder.setAddress(oderDTO.getAddress());
        oder.setPhone(oderDTO.getPhone());
        oder.setUser(user);
        oder.setNgayDatHang(timestamp);
        oder.setStatus(1);
        oder.setThanhTien(oderDTO.getThanhTien());
        oderRepository.save(oder);
        for (CartDetailDTO c : cartDetailDTOS) {
            OderDetail oderDetail = new OderDetail();
            ProductDetail productDetail = productDetailRepository.findById(c.getIdProductDetail())
                    .orElse(null);
            oderDetail.setOder(oder);
            oderDetail.setProductDetail(productDetail);
            oderDetail.setQuantity(oderDTO.getQuantity());
            oderDetail.setTotalMoney(oderDTO.getTotalMoney());
            oderDetailRepository.save(oderDetail);

            CartDetail cartDetail = cartDetailRepository.findById(c.getIdCart()).orElse(null);
            cartDetail.setStatus(2);
            cartDetailRepository.save(cartDetail);
        }
        return oderDTO;
    }

    @Override
    public List<DonHangDTO> choThanhToan(User user) {
        List<Object[]> objectList = oderRepository.choThanhToan(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String image = (String) list[0];
            String name = (String) list[1];
            Integer status = (Integer) list[2];
            DonHangDTO donHangDTO = new DonHangDTO(image, name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<DonHangDTO> vanChuyen(User user) {
        List<Object[]> objectList = oderRepository.vanChuyen(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String image = (String) list[0];
            String name = (String) list[1];
            Integer status = (Integer) list[2];
            DonHangDTO donHangDTO = new DonHangDTO(image, name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<DonHangDTO> dangGiao(User user) {
        List<Object[]> objectList = oderRepository.dangGiao(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String image = (String) list[0];
            String name = (String) list[1];
            Integer status = (Integer) list[2];
            DonHangDTO donHangDTO = new DonHangDTO(image, name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<DonHangDTO> hoanThanh(User user) {
        List<Object[]> objectList = oderRepository.hoanThanh(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String image = (String) list[0];
            String name = (String) list[1];
            Integer status = (Integer) list[2];
            DonHangDTO donHangDTO = new DonHangDTO(image, name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<DonHangDTO> daHuy(User user) {
        List<Object[]> objectList = oderRepository.daHuy(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String image = (String) list[0];
            String name = (String) list[1];
            Integer status = (Integer) list[2];
            DonHangDTO donHangDTO = new DonHangDTO(image, name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<QLDonHangDTO> quanLyDonHang() {
        List<Object[]> objectList = oderRepository.quanLyDonHang();
        List<QLDonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList) {
            Integer id = (Integer) list[0];
            String hoVaTen = (String) list[1];
            Integer phone = (Integer) list[2];
            BigDecimal totalMoney = (BigDecimal) list[3];
            Integer status = (Integer) list[4];
            QLDonHangDTO donHangDTO = new QLDonHangDTO(id, hoVaTen, phone, totalMoney, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public CustomerOderDTO customerOder(Integer id) {
        List<Object[]> objectList = oderRepository.customerOder(id);
        Object[] objects = objectList.get(0);
        Integer idOder = (Integer) objects[0];
        String name = (String) objects[1];
        Integer phone = (Integer) objects[2];
        String address = (String) objects[3];
        Integer status = (Integer) objects[4];
        CustomerOderDTO customerOderDTO = new CustomerOderDTO(idOder, name, phone, address, status);
        return customerOderDTO;
    }

    @Override
    public List<CustomerProductDTO> productOfCustomer(Integer id) {
        List<Object[]> objectList = oderRepository.productOfCustomer(id);
        List<CustomerProductDTO> customerProductDTOS = new ArrayList<>();
        for (Object[] list : objectList) {
            String image = (String) list[0];
            String name = (String) list[1];
            Integer size = (Integer) list[2];
            Integer quantity = (Integer) list[3];
            BigDecimal totalMoney = (BigDecimal) list[4];
            CustomerProductDTO customerProductDTO = new CustomerProductDTO(image, name, size, quantity, totalMoney);
            customerProductDTOS.add(customerProductDTO);
        }
        return customerProductDTOS;
    }

    @Override
    public Oder updateStatus(Oder oder, Integer id) {
        Oder findById = oderRepository.findById(id).orElse(null);
        findById.setStatus(oder.getStatus());
        return oderRepository.save(findById);
    }

    @Override
    public Integer countOderMonth() {
        LocalDate localDate = LocalDate.now();
        int month = localDate.getMonthValue();
        return oderRepository.countOderMonth(month);
    }

    @Override
    public BigDecimal totalMoney() {
        LocalDate localDate = LocalDate.now();
        int month = localDate.getMonthValue();
        return oderRepository.totalMoney(month);
    }

    @Override
    public Integer countOderDay() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return oderRepository.countOderDay(day);
    }

    @Override
    public BigDecimal totalMoneyDay() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return oderRepository.totalMoneyDay(day);
    }

    @Override
    public Integer countProductMonth() {
        LocalDate localDate = LocalDate.now();
        int month = localDate.getMonthValue();
        return oderRepository.countProducMonth(month);
    }

    @Override
    public BigDecimal selectMonthJanuary() {
        return oderRepository.selectMonthJanuary();
    }

    @Override
    public BigDecimal selectMonthFebruary() {
        return oderRepository.selectMonthFebruary();
    }

    @Override
    public BigDecimal selectMonthMarch() {
        return oderRepository.selectMonthMarch();
    }

    @Override
    public BigDecimal selectMonthApril() {
        return oderRepository.selectMonthApril();
    }

    @Override
    public BigDecimal selectMonthMay() {
        return oderRepository.selectMonthMay();
    }

    @Override
    public BigDecimal selectMonthJune() {
        return oderRepository.selectMonthJune();
    }

    @Override
    public BigDecimal selectMonthJuly() {
        return oderRepository.selectMonthJuly();
    }

    @Override
    public BigDecimal selectMonthAugust() {
        return oderRepository.selectMonthAugust();
    }

    @Override
    public BigDecimal selectMonthSeptember() {
        return oderRepository.selectMonthSeptember();
    }

    @Override
    public BigDecimal selectMonthOctober() {
        return oderRepository.selectMonthOctober();
    }

    @Override
    public BigDecimal selectMonthNovember() {
        return oderRepository.selectMonthNovember();
    }

    @Override
    public BigDecimal selectMonthDecember() {
        return oderRepository.selectMonthDecember();
    }

    @Override
    public QLDonHangDTO findByPhone(Integer phone) {
        List<Object[]> objectList = oderRepository.findByPhone(phone);
        Object[] list = objectList.get(0);
        Integer id = (Integer) list[0];
        String hoVaTen = (String) list[1];
        Integer sdt = (Integer) list[2];
        BigDecimal totalMoney = (BigDecimal) list[3];
        Integer status = (Integer) list[4];
        QLDonHangDTO donHangDTO = new QLDonHangDTO(id, hoVaTen, sdt, totalMoney, status);
        return donHangDTO;
    }

    @Override
    public Integer countByStatus() {
        return oderRepository.countByStatus();
    }
}
