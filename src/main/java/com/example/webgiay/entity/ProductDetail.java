package com.example.webgiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_detail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_product",referencedColumnName = "ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Id_color",referencedColumnName = "ID")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "Id_size",referencedColumnName = "ID")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "Id_category",referencedColumnName = "ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "Id_origin",referencedColumnName = "ID")
    private Origin origin;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "import_price")
    private BigDecimal importPrice;

    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "productDetail",fetch = FetchType.LAZY)
    private List<OderDetail> listOderDetail;

    @OneToMany(mappedBy = "productDetail",fetch = FetchType.LAZY)
    private List<CartDetail> listCartDetail;
}