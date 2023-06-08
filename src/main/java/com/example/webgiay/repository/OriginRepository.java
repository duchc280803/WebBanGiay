package com.example.webgiay.repository;

import com.example.webgiay.entity.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepository extends JpaRepository<Origin,Integer> {

    Origin findByName(String name);
}