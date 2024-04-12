package org.example.it355dz06.controller;

import org.example.it355dz06.entity.Cart;
import org.example.it355dz06.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/cart")
    public String showCart(Model model){
        model.addAttribute("cart", cartRepository.findAll());
        return "cart";
    }
    @PostMapping("/checkout")
    public String checkout(@RequestParam("name") String name, @RequestParam("address") String address, Model model) {

        List<Cart> cartItems = cartRepository.findAll();


        double totalPrice = 0.0;


        for (Cart cartItem : cartItems) {
            totalPrice += cartItem.getPrice();
        }
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("totalPrice", totalPrice);

        return "checkout";
    }
}
