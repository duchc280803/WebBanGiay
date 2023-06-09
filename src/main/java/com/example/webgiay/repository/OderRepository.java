package com.example.webgiay.repository;

import com.example.webgiay.entity.Oder;
import com.example.webgiay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OderRepository extends JpaRepository<Oder,Integer> {

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 1")
    List<Object[]> choThanhToan(User user);

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 2")
    List<Object[]> vanChuyen(User user);

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 3")
    List<Object[]> dangGiao(User user);

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 4")
    List<Object[]> hoanThanh(User user);

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 5")
    List<Object[]> daHuy(User user);

    @Query("SELECT o.id,o.recipientName,o.phone,o.thanhTien,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p")
    List<Object[]> quanLyDonHang();

    @Query("SELECT o.id,o.recipientName,o.phone,o.address,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p " +
            "WHERE o.id = :id")
    List<Object[]> customerOder(@Param("id") Integer id);

    @Query("SELECT MIN(i.image),p.name,s.size,od.quantity,od.totalMoney FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p JOIN pd.size s " +
            "JOIN p.listImage i " +
            "where o.id = :id " +
            "GROUP BY p.name,s.size,od.totalMoney,od.quantity ")
    List<Object[]> productOfCustomer(@Param("id") Integer id);

    @Query("SELECT count(o.id) FROM Oder o WHERE o.status = 4 AND MONTH(o.ngayDatHang) = :month")
    Integer countOderMonth(@Param("month") Integer month);

    @Query("SELECT (od.totalMoney * od.quantity) FROM Oder o " +
            "JOIN o.listOderDetail od" +
            " WHERE o.status = 4 AND MONTH(o.ngayDatHang) = :month")
    BigDecimal totalMoney(@Param("month") Integer month);

    @Query("SELECT count(o.id) FROM Oder o WHERE o.status = 4 AND DAY(o.ngayDatHang) = :day")
    Integer countOderDay(@Param("day") Integer day);

    @Query("SELECT (od.totalMoney * od.quantity) FROM Oder o " +
            "JOIN o.listOderDetail od" +
            " WHERE o.status = 4 AND DAY(o.ngayDatHang) = :day")
    BigDecimal totalMoneyDay(@Param("day") Integer day);

    @Query("SELECT COUNT(od.quantity) FROM Oder o " +
            "JOIN o.listOderDetail od" +
            " WHERE o.status = 4 AND MONTH(o.ngayDatHang) = :month")
    Integer countProducMonth(@Param("month") Integer month);
}