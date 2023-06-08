package com.example.webgiay.service.impl;

import com.example.webgiay.entity.Origin;
import com.example.webgiay.repository.OriginRepository;
import com.example.webgiay.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginServiceImpl implements OriginService {

    @Autowired
    private OriginRepository originRepository;

    @Override
    public List<Origin> getAll() {
        List<Origin> getAll = originRepository.findAll();
        return getAll;
    }
}
