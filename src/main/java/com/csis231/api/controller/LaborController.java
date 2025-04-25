package com.csis231.api.controller;

import com.csis231.api.DTO.EmployeeDTO;
import com.csis231.api.model.Labor;
import com.csis231.api.service.LaborService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/labors")
public class LaborController {

    private final LaborService laborService;

    public LaborController(LaborService laborService) {
        this.laborService = laborService;
    }

    @PostMapping("/start")
    public ResponseEntity<Labor> startLabor(@Valid @RequestBody EmployeeDTO e) {
        Labor savedLabor = laborService.startLabor(e);
        return new ResponseEntity<Labor>(savedLabor, HttpStatus.CREATED);
    }


    @PutMapping("/end")
    public ResponseEntity<Labor> endLabor(@Valid @RequestBody EmployeeDTO e) {
        Labor savedLabor = laborService.endLabor(e);
        return new ResponseEntity<Labor>(savedLabor, HttpStatus.CREATED);
    }

    @PutMapping("/end/all")
    public ResponseEntity<List<Labor>> endAllLabors(@Valid @RequestBody List<EmployeeDTO> e) {
        e.forEach(laborService::endLabor);
        List<Labor> savedLabors = laborService.getAllLabors();
        return new ResponseEntity<List<Labor>>(savedLabors, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Labor> getAllLabors() {
        return laborService.getAllLabors();
    }

    @PostMapping
    public ResponseEntity<Labor> createLabor(@Valid @RequestBody Labor labor) {
        Labor savedLabor = laborService.createLabor(labor);
        return new ResponseEntity<Labor>(savedLabor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Labor> getLaborById(@PathVariable Long id) {
        return ResponseEntity.ok(laborService.getLaborById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLabor(@PathVariable Long id, @Valid @RequestBody Labor laborDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid labor data");
        }
        Labor updatedLabor = laborService.updateLabor(id, laborDetails);
        return ResponseEntity.ok(updatedLabor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabor(@PathVariable Long id) {
        laborService.deleteLabor(id);
        return ResponseEntity.noContent().build();
    }
}