package com.example.webgiay.repository;

import com.example.webgiay.entity.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Integer> {

    Discount findFirstByName(@Param("name") String name);

    @Query("SELECT d.ma, d.name, d.discountType, " +
            "CASE WHEN d.discountType = 1 THEN d.percentageDiscount ELSE d.cashDiscount END, " +
            "p.name, d.startDate, d.endDate, d.status " +
            "FROM Discount d " +
            "JOIN d.listDiscountProduct dp " +
            "JOIN dp.product p")
    Page<Object[]> getAll(Pageable pageable);


    @Query("SELECT d.ma, d.name, d.discountType, " +
            "CASE WHEN d.discountType = 1 THEN d.percentageDiscount ELSE d.cashDiscount END, " +
            "p.name, d.startDate, d.endDate, d.status " +
            "FROM Discount d " +
            "JOIN d.listDiscountProduct dp " +
            "JOIN dp.product p WHERE d.ma = :ma")
    List<Object[]> getOneDetailDiscount(@Param("ma") String ma);
}