package com.example;

import com.example.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    @Query("SELECT x FROM Pizza x ORDER BY x.id ASC")
    List<Pizza> findOrderByIdAsc();
}
