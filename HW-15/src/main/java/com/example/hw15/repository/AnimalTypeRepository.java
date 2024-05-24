package com.example.hw15.repository;

import com.example.hw15.entity.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {

    AnimalType findByType(String type);
}
