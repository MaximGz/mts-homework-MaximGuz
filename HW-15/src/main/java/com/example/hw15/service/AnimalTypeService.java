package com.example.hw15.service;

import com.example.hw15.entity.AnimalType;
import com.example.hw15.repository.AnimalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalTypeService {
    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    public AnimalType findAnimalType(String animalType) {
        return animalTypeRepository.findByType(animalType);
    }

    public AnimalType save(AnimalType animalType) {
        return animalTypeRepository.save(animalType);
    }
}
