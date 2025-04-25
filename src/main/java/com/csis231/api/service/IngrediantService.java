package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Ingrediant;
import com.csis231.api.repository.IngrediantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class IngrediantService {

    private final IngrediantRepository ingrediantRepository;

    @Autowired
    public IngrediantService(IngrediantRepository ingrediantRepository) {
        this.ingrediantRepository = ingrediantRepository;
    }

    public List<Ingrediant> getAllIngrediants() {
        return ingrediantRepository.findAll();
    }

    public Ingrediant getIngrediantById(Long id) {
        return ingrediantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingrediant not found"));
    }

    public Ingrediant createIngrediant(Ingrediant ingrediant) {
        return ingrediantRepository.save(ingrediant);
    }

    public Ingrediant updateIngrediant(Long id, Ingrediant ingrediantDetails) {
        Ingrediant ingrediant = ingrediantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ingrediant not found with id : " + id));


        ingrediant = ingrediantDetails.clone();


        return ingrediantRepository.save(ingrediant);
    }


    public Map<String, Boolean> deleteIngrediant(Long id) {
        Optional<Ingrediant> optionalIngrediant = ingrediantRepository.findById(id);
        if (optionalIngrediant.isEmpty()) {
            throw new ResourceNotFoundException("Ingrediant not found with id : " + id);
        }

        ingrediantRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}