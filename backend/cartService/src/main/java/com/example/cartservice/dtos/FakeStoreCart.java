package com.example.cartservice.dtos;

import com.example.cartservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FakeStoreCart {
    private Long id;
    private Long userId;
    private LocalDate date;
    private Product[] products;
}
