package com.shopmanager.shopper_franchise_api.service;


import com.shopmanager.shopper_franchise_api.model.Franquicia;
import com.shopmanager.shopper_franchise_api.model.Sucursal;
import com.shopmanager.shopper_franchise_api.repository.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Franquicia agregarFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Franquicia agregarSucursal(Long franquiciaId, Sucursal sucursal) {
        // Buscar la franquicia existente por su ID
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        // Asignar la franquicia a la sucursal
        sucursal.setFranquicia(franquicia);

        // Agregar la sucursal a la lista de sucursales de la franquicia
        franquicia.getSucursales().add(sucursal);

        // Guardar la franquicia con la nueva sucursal
        return franquiciaRepository.save(franquicia);
    }
}