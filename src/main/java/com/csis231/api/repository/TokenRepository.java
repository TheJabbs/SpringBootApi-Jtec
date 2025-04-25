package com.csis231.api.repository;

import com.csis231.api.model.Restaurant;
import com.csis231.api.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long>{
}