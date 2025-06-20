package com.example.spring_final.model;

import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long furnitureId;
    private Integer quantity;

    public CartItem() {}

    public CartItem(Long furnitureId, Integer quantity) {
        this.furnitureId = furnitureId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFurnitureId() {
        return furnitureId;
    }

    public void setFurnitureId(Long furnitureId) {
        this.furnitureId = furnitureId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
