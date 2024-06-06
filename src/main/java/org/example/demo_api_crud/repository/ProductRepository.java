package org.example.demo_api_crud.repository;

import org.example.demo_api_crud.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product  p where p.proName like concat('%',:proName,'%')")
    public List<Product> findProductsByProName(String proName);
}
// JPQL : Java Persistence Query Language
// JPA  : Java Persistence API
//      truy van:  select p from Product p where p...

//Hibernate : HQL
//      truy van: from Product where ...

// sql:  '%'+proName+'%'            '_'+proName+'_'