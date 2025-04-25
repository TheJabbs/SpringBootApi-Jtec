package com.csis231.api.controller;

import com.csis231.api.model.IngrediantNames;
import com.csis231.api.service.IngrediantNamesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/ingrediantnamess")
public class IngrediantNamesController {

    private final IngrediantNamesService ingrediantnamesService;

    public IngrediantNamesController(IngrediantNamesService ingrediantnamesService) {
        this.ingrediantnamesService = ingrediantnamesService;
    }

    @GetMapping("/all")
    public List<String> getAllIngrediantNames() {
        return ingrediantnamesService.getAllIngrediantNames();
    }

    @GetMapping
    public List<IngrediantNames> getAllIngrediantNamess() {
        return ingrediantnamesService.getAllIngrediantNamess();
    }

    @PostMapping
    public ResponseEntity<IngrediantNames> createIngrediantNames(@Valid @RequestBody IngrediantNames ingrediantnames) {
        IngrediantNames savedIngrediantNames = ingrediantnamesService.createIngrediantNames(ingrediantnames);
        return new ResponseEntity<IngrediantNames>(savedIngrediantNames, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngrediantNames> getIngrediantNamesById(@PathVariable Long id) {
        return ResponseEntity.ok(ingrediantnamesService.getIngrediantNamesById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateIngrediantNames(@PathVariable Long id, @Valid @RequestBody IngrediantNames ingrediantnamesDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid ingrediantnames data");
        }
        IngrediantNames updatedIngrediantNames = ingrediantnamesService.updateIngrediantNames(id, ingrediantnamesDetails);
        return ResponseEntity.ok(updatedIngrediantNames);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrediantNames(@PathVariable Long id) {
        ingrediantnamesService.deleteIngrediantNames(id);
        return ResponseEntity.noContent().build();
    }
}