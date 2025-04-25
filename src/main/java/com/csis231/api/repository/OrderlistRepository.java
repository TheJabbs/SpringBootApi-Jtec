package com.csis231.api.repository;

import com.csis231.api.model.Orderlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderlistRepository extends JpaRepository<Orderlist, Long> {
}