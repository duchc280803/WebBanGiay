package com.example.webgiay.service;

import com.example.webgiay.dto.CartDTO;
import com.example.webgiay.dto.CartDetailDTO;
import com.example.webgiay.entity.CartDetail;
import com.example.webgiay.entity.User;

import java.util.List;

public interface CartService {

    CartDTO create(CartDTO cartDTO, User user);

    List<CartDetailDTO> cartDetailDTO(User user);

    CartDetail update(Integer id, User user, Integer quantity);

    boolean delete(Integer id, User user);

}