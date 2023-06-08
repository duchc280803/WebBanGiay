package com.example.webgiay.service.impl;

import com.example.webgiay.dto.CartDTO;
import com.example.webgiay.dto.CartDetailDTO;
import com.example.webgiay.entity.Cart;
import com.example.webgiay.entity.CartDetail;
import com.example.webgiay.entity.ProductDetail;
import com.example.webgiay.entity.User;
import com.example.webgiay.repository.CartDetailRepository;
import com.example.webgiay.repository.CartRepository;
import com.example.webgiay.repository.ProductDetailRepository;
import com.example.webgiay.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public CartDTO create(CartDTO cartDTO, User user) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        ProductDetail existingProduct = productDetailRepository.findById(cartDTO.getIdProduct()).orElse(null);

        Cart cart = new Cart();
        cart.setUnitPrice(cartDTO.getUnitPrice());
        cart.setUser(user);
        cartRepository.save(cart);

        CartDetail cartDetail = new CartDetail();
        cartDetail.setCart(cart);
        cartDetail.setProductDetail(existingProduct);
        cartDetail.setDateCreate(timestamp);
        cartDetail.setQuantity(1);
        cartDetail.setStatus(1);
        cartDetailRepository.save(cartDetail);
        return cartDTO;
    }

    @Override
    public List<CartDetailDTO> cartDetailDTO(User user) {
        List<Object[]> listObjects = cartDetailRepository.getCartDetail(user);
        List<CartDetailDTO> cartDetailDTO = new ArrayList<>();
        for (Object[] x : listObjects) {
            Integer idProductDetail = (Integer) x[0];
            Integer IdCart = (Integer) x[1];
            String image = (String) x[2];
            String productName = (String) x[3];
            BigDecimal price = (BigDecimal) x[4];
            Integer quantity = (Integer) x[5];
            Integer size = (Integer) x[6];
            Integer status = (Integer) x[7];
            CartDetailDTO detailDTO = new CartDetailDTO(idProductDetail,IdCart, image, productName, price, quantity,size,status);
            cartDetailDTO.add(detailDTO);
        }
        return cartDetailDTO;
    }

    @Override
    public CartDetail update(Integer id, User user,Integer quantity) {
        CartDetail cartDetail = cartDetailRepository.findById(id).orElse(null);
        if (cartDetail != null){
            cartDetail.setQuantity(quantity);
            cartDetailRepository.save(cartDetail);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id, User user) {
        Optional<CartDetail> cartDetail = cartDetailRepository.findById(id);
        if (cartDetail.isPresent()) {
            cartDetailRepository.deleteById(cartDetail.get().getId());
            return true;
        }
        return false;
    }

}
