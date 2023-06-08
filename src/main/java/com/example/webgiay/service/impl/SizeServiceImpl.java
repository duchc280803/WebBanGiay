package com.example.webgiay.service.impl;

import com.example.webgiay.entity.Size;
import com.example.webgiay.repository.SizeRepository;
import com.example.webgiay.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getAll() {
        List<Size> getAll = sizeRepository.findAll();
        return getAll;
    }
}
