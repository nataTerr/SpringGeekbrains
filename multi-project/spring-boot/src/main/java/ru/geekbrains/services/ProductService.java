package ru.geekbrains.services;

import ru.geekbrains.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(Long id);
}
