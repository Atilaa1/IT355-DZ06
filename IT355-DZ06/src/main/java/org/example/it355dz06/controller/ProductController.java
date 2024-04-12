package org.example.it355dz06.controller;

import org.example.it355dz06.entity.Cart;
import org.example.it355dz06.entity.Product;
import org.example.it355dz06.repository.CartRepository;
import org.example.it355dz06.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/")
    public String showProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam(name = "productId") Long productId) {

            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                Cart cartItem = new Cart();
                cartItem.setId(product.getId());
                cartItem.setName(product.getName());
                cartItem.setPrice(product.getPrice());
                cartRepository.save(cartItem);
            }


        return "redirect:/";
    }
}
