package com.example.spring_final.controller;

import com.example.spring_final.model.Furniture;
import com.example.spring_final.service.FurnitureService;
import com.example.spring_final.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FurnitureController {

    private final FurnitureService furnitureService;
    private final CartService cartService;

    public FurnitureController(FurnitureService furnitureService, CartService cartService) {
        this.furnitureService = furnitureService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/furniture")
    public String listFurniture(Model model) {
        model.addAttribute("furnitures", furnitureService.getAllFurniture());
        return "furnitureList";
    }

    @GetMapping("/furniture/new")
    public String newFurnitureForm(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "furnitureForm";
    }

    @PostMapping("/furniture/save")
    public String saveFurniture(@ModelAttribute Furniture furniture) {
        furnitureService.saveFurniture(furniture);
        return "redirect:/furniture";
    }

    @GetMapping("/furniture/edit/{id}")
    public String editFurniture(@PathVariable Long id, Model model) {
        Furniture furniture = furnitureService.getFurnitureById(id);
        if (furniture == null) {
            return "redirect:/furniture";
        }
        model.addAttribute("furniture", furniture);
        return "furnitureForm";
    }

    @GetMapping("/furniture/delete/{id}")
    public String deleteFurniture(@PathVariable Long id) {
        furnitureService.deleteFurniture(id);
        return "redirect:/furniture";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getAllCartItems());
        return "cart";
    }

    @GetMapping("/cart/add/{furnitureId}")
    public String addToCart(@PathVariable Long furnitureId) {
        cartService.addToCart(furnitureId, 1);
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }
}
