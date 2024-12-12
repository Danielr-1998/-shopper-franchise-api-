package com.shopmanager.shopper_franchise_api.controller;


import com.shopmanager.shopper_franchise_api.model.Franquicia;
import com.shopmanager.shopper_franchise_api.model.Sucursal;
import com.shopmanager.shopper_franchise_api.service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;


    @Operation(summary = "Agregar una nueva franquicia")
    @PostMapping
    public Franquicia agregarFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.agregarFranquicia(franquicia);
    }


    @Operation(summary = "Agregar una nueva sucursal a una franquicia")
    @PostMapping("/{franquiciaId}/sucursales")
    public Franquicia agregarSucursal(@PathVariable Long franquiciaId, @RequestBody Sucursal sucursal) {
        return franquiciaService.agregarSucursal(franquiciaId, sucursal);
    }


    @Operation(summary = "Obtener todas las franquicias")
    @GetMapping
    public List<Franquicia> obtenerTodasLasFranquicias() {
        return franquiciaService.obtenerTodasLasFranquicias();
    }
}