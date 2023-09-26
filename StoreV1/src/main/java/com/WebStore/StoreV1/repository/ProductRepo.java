package com.WebStore.StoreV1.repository;

import com.WebStore.StoreV1.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>
{


}
