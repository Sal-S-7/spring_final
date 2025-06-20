package com.example.spring_final.service;

import com.example.spring_final.model.Furniture;
import com.example.spring_final.repository.FurnitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    public void saveFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    public Furniture getFurnitureById(Long id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    public void deleteFurniture(Long id) {
        furnitureRepository.deleteById(id);
    }
}
