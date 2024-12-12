package com.shopmanager.shopper_franchise_api.repository;

import com.shopmanager.shopper_franchise_api.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}