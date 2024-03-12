package com.example.cartservice.services;


import com.example.cartservice.dtos.FakeStoreAddCart;
import com.example.cartservice.dtos.FakeStoreCart;
import com.example.cartservice.models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCartServices implements CartService {

    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public Cart getSingleCart(Long id) {
        FakeStoreCart fakeStoreCart = restTemplate.getForObject("https://fakestoreapi.com/carts/"+id, FakeStoreCart.class);
        return copy(fakeStoreCart);
    }

    @Override
    public List<Cart> getAllCarts() {
        FakeStoreCart[] fakeStoreCarts = restTemplate.getForObject("https://fakestoreapi.com/carts", FakeStoreCart[].class);
        ArrayList<Cart> carts = new ArrayList<>();
        for (FakeStoreCart fakeStoreCart : fakeStoreCarts) {
            carts.add(copy(fakeStoreCart));
        }
        return carts;
    }

    @Override
    public List<Cart> getInDateRange(LocalDate startDate, LocalDate endDate) {
        FakeStoreCart[] fakeStoreCarts = restTemplate.getForObject("https://fakestoreapi.com/carts?startdate="+startDate+"&enddate="+endDate, FakeStoreCart[].class);
        ArrayList<Cart> carts = new ArrayList<>();
        for (FakeStoreCart fakeStoreCart : fakeStoreCarts) {
            carts.add(copy(fakeStoreCart));
        }
        return carts;
    }

    @Override
    public List<Cart> getUserCart(Long id) {
        FakeStoreCart[] fakeStoreCarts = restTemplate.getForObject("https://fakestoreapi.com/carts/user/"+id, FakeStoreCart[].class);
        ArrayList<Cart> carts = new ArrayList<>();
        for (FakeStoreCart fakeStoreCart : fakeStoreCarts) {
            carts.add(copy(fakeStoreCart));
        }
        return carts;
    }



    @Override
    public Cart createCart(FakeStoreAddCart cart) {
        FakeStoreCart gotCart = restTemplate.postForObject("https://fakestoreapi.com/carts", cart , FakeStoreCart.class);
        return copy(gotCart);
    }

    @Override
    public Cart updateCart(Long id, FakeStoreAddCart cart) {
        FakeStoreCart fakeStoreCart = new FakeStoreCart();
        fakeStoreCart.setId(id);
        fakeStoreCart.setUserId(cart.getUserId());
        fakeStoreCart.setDate(cart.getDate());
        fakeStoreCart.setProducts(cart.getProducts());
        restTemplate.put("https://fakestoreapi.com/carts/"+id, cart);
        return copy(fakeStoreCart);
    }

    @Override
    public Cart deleteCart(Long id) {
        restTemplate.delete("https://fakestoreapi.com/carts/"+id);
        return getSingleCart(id);
    }

    public Cart copy(FakeStoreCart fakeStoreCart) {
        Cart cart = new Cart();
        cart.setId(fakeStoreCart.getId());
        cart.setUserId(fakeStoreCart.getUserId());
        cart.setDate(fakeStoreCart.getDate());
        cart.setProducts(fakeStoreCart.getProducts());
        return cart;
    }

}
