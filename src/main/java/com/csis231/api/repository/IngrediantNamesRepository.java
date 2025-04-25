package com.csis231.api.repository;

import com.csis231.api.model.IngrediantNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngrediantNamesRepository extends JpaRepository<IngrediantNames, Long> {
    @Query("SELECT ingrediantName FROM IngrediantNames")
    List<String> findAllIngrediantNames();
}