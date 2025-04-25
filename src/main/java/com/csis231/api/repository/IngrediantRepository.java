package com.csis231.api.repository;

import com.csis231.api.model.Ingrediant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngrediantRepository extends JpaRepository<Ingrediant, Long> {
}