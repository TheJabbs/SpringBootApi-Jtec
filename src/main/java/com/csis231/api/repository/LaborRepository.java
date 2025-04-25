package com.csis231.api.repository;

import com.csis231.api.model.Employee;
import com.csis231.api.model.Labor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaborRepository extends JpaRepository<Labor, Long> {
    List<Labor> findLaborByEmployeeByEmployeeIdAndLaborEndIsNull(Employee ee);
}