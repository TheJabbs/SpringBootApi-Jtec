package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.IngrediantNames;
import com.csis231.api.repository.IngrediantNamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class IngrediantNamesService {

    private final IngrediantNamesRepository ingrediantnamesRepository;

    @Autowired
    public IngrediantNamesService(IngrediantNamesRepository ingrediantnamesRepository) {
        this.ingrediantnamesRepository = ingrediantnamesRepository;
    }

    public List<IngrediantNames> getAllIngrediantNamess() {
        return ingrediantnamesRepository.findAll();
    }

    public List<String> getAllIngrediantNames() {
        return ingrediantnamesRepository.findAllIngrediantNames();
    }

    public IngrediantNames getIngrediantNamesById(Long id) {
        return ingrediantnamesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("IngrediantNames not found"));
    }

    public IngrediantNames createIngrediantNames(IngrediantNames ingrediantnames) {
        return ingrediantnamesRepository.save(ingrediantnames);
    }

    public IngrediantNames updateIngrediantNames(Long id, IngrediantNames ingrediantNamesDetails) {
        IngrediantNames ingrediantNames = ingrediantnamesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ingrediant names not found with id : " + id));

        ingrediantNames = ingrediantNamesDetails.clone();

        return ingrediantnamesRepository.save(ingrediantNames);
    }

    public Map<String, Boolean> deleteIngrediantNames(Long id) {
        Optional<IngrediantNames> optionalIngrediantNames = ingrediantnamesRepository.findById(id);
        if (optionalIngrediantNames.isEmpty()) {
            throw new ResourceNotFoundException("Ingrediant names not found with id : " + id);
        }

        ingrediantnamesRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}