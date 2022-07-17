package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.services.ProductService;
import ru.geekbrains.model.Product;


@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/show/{id}")
    public String showProductsPage(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.findById(id));
        return "product_info";
    }

    @GetMapping("/show_all")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create_product";
    }

    @PostMapping("/create")
    public String saveProduct(@RequestParam(required = false) Long id, @RequestParam String title, @RequestParam Long cost) {
        Product product = new Product(id, title, cost);
        productService.save(product);
        return "redirect:/show_all";
    }
}
