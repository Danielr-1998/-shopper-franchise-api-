package com.shopmanager.shopper_franchise_api.controller;


import com.shopmanager.shopper_franchise_api.model.Franquicia;
import com.shopmanager.shopper_franchise_api.model.Sucursal;  // Importar la clase Sucursal
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

    /**
     * Endpoint para agregar una nueva franquicia
     */
    @Operation(summary = "Agregar una nueva franquicia")
    @PostMapping
    public Franquicia agregarFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.agregarFranquicia(franquicia);
    }

    /**
     * Endpoint para agregar una nueva sucursal a una franquicia existente
     *
     * @param franquiciaId ID de la franquicia a la que se le agregará la sucursal
     * @param sucursal    La sucursal que se desea agregar
     * @return La franquicia actualizada con la nueva sucursal
     */
    @Operation(summary = "Agregar una nueva sucursal a una franquicia")
    @PostMapping("/{franquiciaId}/sucursales")
    public Franquicia agregarSucursal(@PathVariable Long franquiciaId, @RequestBody Sucursal sucursal) {
        return franquiciaService.agregarSucursal(franquiciaId, sucursal);
    }

    /**
     * Endpoint para obtener todas las franquicias
     */
    @Operation(summary = "Obtener todas las franquicias")
    @GetMapping
    public List<Franquicia> obtenerTodasLasFranquicias() {
        return franquiciaService.obtenerTodasLasFranquicias();
    }
}