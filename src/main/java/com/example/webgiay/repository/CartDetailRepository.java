package com.example.webgiay.repository;


import com.example.webgiay.entity.CartDetail;
import com.example.webgiay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {

    @Query("Select pd.id,cd.id, MIN(i.image),p.name,pd.price,cd.quantity,s.size,cd.status FROM CartDetail cd " +
            "JOIN cd.productDetail pd " +
            "JOIN  pd.product p " +
            "JOIN  pd.size s " +
            "JOIN p.listImage i " +
            "where cd.cart.user = :user AND cd.status = 1 GROUP BY pd.id,cd.id,p.name,pd.price,cd.quantity,s.size,cd.status")
    List<Object[]> getCartDetail(@Param("user") User user);

}