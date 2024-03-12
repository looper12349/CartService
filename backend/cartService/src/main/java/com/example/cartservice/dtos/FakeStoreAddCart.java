package com.example.cartservice.dtos;


import com.example.cartservice.models.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Service
public class FakeStoreAddCart {
    private Long userId;
    private LocalDate date;
    private Product[] products;


}
