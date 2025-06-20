package com.example.spring_final.service;

import com.example.spring_final.model.CartItem;
import com.example.spring_final.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;

    public CartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void addToCart(Long furnitureId, Integer quantity) {
        CartItem item = new CartItem(furnitureId, quantity);
        cartItemRepository.save(item);
    }

    public void removeFromCart(Long id) {
        cartItemRepository.deleteById(id);
    }

    public void clearCart() {
        cartItemRepository.deleteAll();
    }
}
