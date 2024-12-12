package com.shopmanager.shopper_franchise_api.controller;

import com.shopmanager.shopper_franchise_api.model.Producto;
import com.shopmanager.shopper_franchise_api.model.Sucursal;
import com.shopmanager.shopper_franchise_api.service.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    /**
     * Endpoint para agregar un producto a una sucursal
     */
    @Operation(summary = "Agregar un nuevo producto a una sucursal")
    @PostMapping("/{sucursalId}/productos")
    public Sucursal agregarProducto(@PathVariable Long sucursalId, @RequestBody Producto producto) {
        return sucursalService.agregarProducto(sucursalId, producto);
    }

    /**
     * Endpoint para eliminar un producto de una sucursal
     */
    @Operation(summary = "Eliminar un producto de una sucursal")
    @DeleteMapping("/{sucursalId}/productos/{productoId}")
    public Sucursal eliminarProducto(@PathVariable Long sucursalId, @PathVariable Long productoId) {
        return sucursalService.eliminarProducto(sucursalId, productoId);
    }
}
