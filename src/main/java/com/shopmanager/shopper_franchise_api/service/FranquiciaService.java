package com.shopmanager.shopper_franchise_api.service;


import com.shopmanager.shopper_franchise_api.model.Franquicia;
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
}