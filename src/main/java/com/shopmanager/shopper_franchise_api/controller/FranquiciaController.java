package com.shopmanager.shopper_franchise_api.controller;

import com.shopmanager.shopper_franchise_api.model.Franquicia;
import com.shopmanager.shopper_franchise_api.service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    /**
     * Endpoint para agregar una nueva franquicia
     *
     * @param franquicia objeto de la franquicia a agregar
     * @return la franquicia agregada
     */
    @Operation(summary = "Agregar una nueva franquicia")
    @PostMapping
    public Franquicia agregarFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.agregarFranquicia(franquicia);
    }
}