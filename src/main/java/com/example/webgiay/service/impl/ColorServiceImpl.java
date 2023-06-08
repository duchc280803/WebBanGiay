package com.example.webgiay.service.impl;

import com.example.webgiay.entity.Color;
import com.example.webgiay.repository.ColorRepository;
import com.example.webgiay.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        List<Color> getAll = colorRepository.findAll();
        return getAll;
    }
}
