package com.example.webgiay.repository;

import com.example.webgiay.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {

    @Query("SELECT p.id, p.name, cl.name, s.size, c.name, o.name, pd.quantity, pd.price, p.description, MIN(i.image) FROM Product p " +
            " JOIN p.listImage i " +
            " JOIN p.listProduct pd " +
            " JOIN pd.category c " +
            " JOIN pd.size s " +
            " JOIN pd.origin o " +
            " JOIN pd.color cl " +
            "GROUP BY p.id, p.name, cl.name, s.size, c.name, o.name, pd.quantity, pd.price, p.description")
    Page<Object[]> selectAllProduct(Pageable pageable); //Hiển thị tất cả sản phẩm ở manager product

    @Query("SELECT p.id,p.name,cl.name,s.size,c.name,o.name,pd.quantity,pd.price,p.description,MIN(i.image) From Product p " +
            " JOIN p.listImage i " +
            " JOIN p.listProduct pd " +
            " JOIN pd.category c " +
            " JOIN pd.size s " +
            " JOIN pd.origin o " +
            " JOIN pd.color cl " +
            "GROUP BY p.id,p.name,cl.name,s.size,c.name,o.name,pd.quantity,pd.price,p.description")
    List<Object[]> selectAllProduct();

    @Query("SELECT p.id,p.name,cl.name,s.size,c.name,o.name,pd.quantity,pd.price,p.description,MIN(i.image) From Product p " +
            " JOIN p.listImage i " +
            " JOIN p.listProduct pd " +
            " JOIN pd.category c " +
            " JOIN pd.size s " +
            " JOIN pd.origin o " +
            " JOIN pd.color cl " +
            "where p.id = :id GROUP BY p.id,p.name,cl.name,s.size,c.name,o.name,pd.quantity,pd.price,p.description")
    List<Object[]> detailProductById(@Param("id") Integer id); // nhấn update để hiển thị thông tin vào các form input

    @Query("SELECT p.id,p.name,cl.name,s.size,c.name,o.name,pd.quantity,pd.price,p.description,MIN(i.image) From Product p " +
            " JOIN p.listImage i " +
            " JOIN p.listProduct pd " +
            " JOIN pd.category c " +
            " JOIN pd.size s " +
            " JOIN pd.origin o " +
            " JOIN pd.color cl " +
            "WHERE p.name like %:name% GROUP BY p.id,p.name,cl.name,s.size,c.name,o.name,pd.quantity,pd.price,p.description")
    List<Object[]> findByProduct(@Param("name") String name);

    @Query("SELECT p.id, p.name, cl.name, s.size, c.name, o.name, pd.quantity, pd.price, p.description, MIN(i.image) FROM Product p " +
            " JOIN p.listImage i " +
            " JOIN p.listProduct pd " +
            " JOIN pd.category c " +
            " JOIN pd.size s " +
            " JOIN pd.origin o " +
            " JOIN pd.color cl " +
            " WHERE c.id = :id " +
            " GROUP BY p.id, p.name, cl.name, s.size, c.name, o.name, pd.quantity, pd.price, p.description")
    Page<Object[]> selectAllProductCategory(@Param("id") Integer id,Pageable pageable);

}