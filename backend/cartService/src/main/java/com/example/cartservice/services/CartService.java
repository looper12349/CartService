package com.example.cartservice.services;


import com.example.cartservice.dtos.FakeStoreAddCart;
import com.example.cartservice.models.Cart;

import java.time.LocalDate;
import java.util.List;

public interface CartService {
    Cart getSingleCart(Long id);
    List<Cart> getAllCarts();

    List<Cart> getInDateRange(LocalDate startDate, LocalDate endDate);

    List<Cart> getUserCart(Long id);

    Cart createCart(FakeStoreAddCart cart);

    Cart updateCart(Long id, FakeStoreAddCart cart);

    Cart deleteCart(Long id);
}
