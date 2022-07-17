package ru.geekbrains.repositories;

import ru.geekbrains.model.Product;

import java.util.List;

public interface ProductRepository {

    Product findById(Long id);

    List<Product> findAll();

    void save(Product product);
}
