package com.example.webgiay.service;

import com.example.webgiay.dto.RegisterDTO;
import com.example.webgiay.entity.User;

public interface UserService {

    User findByName(String name, String password);

    RegisterDTO create(RegisterDTO registerDTO);

    User findByUser(User user);
}
