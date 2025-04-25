package com.csis231.api.service;

import com.csis231.api.DTO.EmployeeDTO;
import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Employee;
import com.csis231.api.model.Labor;
import com.csis231.api.repository.LaborRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LaborService {

    private final LaborRepository laborRepository;
    private final EmployeeService employeeService;

    @Autowired
    public LaborService(LaborRepository laborRepository, EmployeeService employeeService) {

        this.laborRepository = laborRepository;
        this.employeeService = employeeService;
    }

    public Labor startLabor(EmployeeDTO e){
        Employee ee = employeeService.authenticate(e);
        System.err.println("startLabor");

        if(ee == null){
            System.err.println("Employee not found");
            throw new ResourceNotFoundException("Employee not found");
        }

        Labor l = new Labor();
        l.setEmployeeId(ee.getEmployeeId());
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        l.setLaborStart(ts);
        l.setRestaurantId(ee.getRestaurantId());

        System.err.println("Labor: " + l);

        return laborRepository.save(l);
    }

    public Labor endLabor(EmployeeDTO e){
        Employee ee = employeeService.authenticate(e);

        if(ee == null){
            throw new ResourceNotFoundException("Employee not found");
        }

        List<Labor> l = laborRepository.findLaborByEmployeeByEmployeeIdAndLaborEndIsNull(ee);

        if(l == null){
            throw new ResourceNotFoundException("Labor not found");
        }

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        l.stream().findFirst().get().setLaborEnd(ts);

        return laborRepository.save(l.stream().findFirst().get());
    }

    public List<Labor> getAllLabors() {
        return laborRepository.findAll();
    }

    public Labor getLaborById(Long id) {
        return laborRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Labor not found"));
    }

    public Labor createLabor(Labor labor) {
        return laborRepository.save(labor);
    }

    public Labor updateLabor(Long id, Labor laborDetails) {
        Labor labor = laborRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Labor not found with id : " + id));

        labor = laborDetails.clone();

        return laborRepository.save(labor);
    }

    public Map<String, Boolean> deleteLabor(Long id) {
        Optional<Labor> optionalLabor = laborRepository.findById(id);
        if (optionalLabor.isEmpty()) {
            throw new ResourceNotFoundException("Labor not found with id : " + id);
        }

        laborRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}