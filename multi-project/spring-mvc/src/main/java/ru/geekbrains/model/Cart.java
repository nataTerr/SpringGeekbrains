package ru.geekbrains.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {
    private final Map<Product, Integer> cartMap = new HashMap<>();

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void addProduct(Product product, Integer quantity) {
        if (product != null)
            cartMap.merge(product, quantity, Integer::sum);
    }

    public void delProduct(Product product, Integer quantity) {
        if (cartMap.containsKey(product)) {
            if (quantity != null && cartMap.get(product).compareTo(quantity) > 0) {
                cartMap.put(product, cartMap.get(product) - quantity);
            } else {
                cartMap.remove(product);
            }
        }
    }

    public Integer getSum() {
        Integer sum = Integer.valueOf(0);
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            Integer sumEl = entry.getKey().getCost()*(Integer.valueOf(entry.getValue()));
            sum += sumEl;
        }
        return sum;
    }
}