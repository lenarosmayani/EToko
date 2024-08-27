package com.example.EToko.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EToko.Model.Item;
import com.example.EToko.Service.ShoppingService;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/optimize")
    public String optimizeShopping(@RequestParam int budget) {
        return shoppingService.getMaxSpent(budget);
    }

    @GetMapping("/keyboards")
    public List<Item> getAllKeyboards() {
        return shoppingService.getAllKeyboards();
    }

    @GetMapping("/mice")
    public List<Item> getAllMice() {
        return shoppingService.getAllMice();
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return shoppingService.getAllItems();
    }

    
}
