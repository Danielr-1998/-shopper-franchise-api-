package com.shopmanager.shopper_franchise_api.repository;

import com.shopmanager.shopper_franchise_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}