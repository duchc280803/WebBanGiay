package com.example.webgiay.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "ho_va_ten")
    private String name;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_fix")
    private Date dateFix;

    @Column(name = "image")
    private String image;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Oder> listOder;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Cart> cartList;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Role role;
}
