package com.csis231.api.controller;

import com.csis231.api.model.Ingrediant;
import com.csis231.api.service.IngrediantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/ingrediants")
public class IngrediantController {

    private final IngrediantService ingrediantService;

    public IngrediantController(IngrediantService ingrediantService) {
        this.ingrediantService = ingrediantService;
    }

    @GetMapping
    public List<Ingrediant> getAllIngrediants() {
        return ingrediantService.getAllIngrediants();
    }

    @PostMapping
    public ResponseEntity<Ingrediant> createIngrediant(@Valid @RequestBody Ingrediant ingrediant) {
        Ingrediant savedIngrediant = ingrediantService.createIngrediant(ingrediant);
        return new ResponseEntity<Ingrediant>(savedIngrediant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediant> getIngrediantById(@PathVariable Long id) {
        return ResponseEntity.ok(ingrediantService.getIngrediantById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateIngrediant(@PathVariable Long id, @Valid @RequestBody Ingrediant ingrediantDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid ingrediant data");
        }
        Ingrediant updatedIngrediant = ingrediantService.updateIngrediant(id, ingrediantDetails);
        return ResponseEntity.ok(updatedIngrediant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrediant(@PathVariable Long id) {
        ingrediantService.deleteIngrediant(id);
        return ResponseEntity.noContent().build();
    }
}