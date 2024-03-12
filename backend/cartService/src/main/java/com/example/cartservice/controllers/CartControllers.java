package com.example.cartservice.controllers;

import com.example.cartservice.dtos.FakeStoreAddCart;
import com.example.cartservice.models.Cart;
import com.example.cartservice.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
public class CartControllers {

    private CartService cartService;

    public CartControllers(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable("id") Long id) {
        return cartService.getSingleCart(id);
    }

    @GetMapping(path = "/carts", params = {"startdate", "enddate"})
    public List<Cart> getInDateRange(@RequestParam("startdate") LocalDate startDate, @RequestParam("enddate") LocalDate endDate){
        return cartService.getInDateRange(startDate, endDate);
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/carts/user/{id}")
    public List<Cart> getUserCart(@PathVariable("id") Long id) {
        return cartService.getUserCart(id);
    }

    @PostMapping("/carts")
    public Cart createCart(@RequestBody FakeStoreAddCart cart) {
        return cartService.createCart(cart);
    }

    @PutMapping("/carts/{id}")
    public Cart updateCart(@PathVariable("id") Long id, @RequestBody FakeStoreAddCart cart) {
        return cartService.updateCart(id, cart);
    }

    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable("id") Long id) {
        return cartService.deleteCart(id);
    }

}


