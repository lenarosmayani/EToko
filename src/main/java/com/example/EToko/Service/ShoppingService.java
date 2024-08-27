package com.example.EToko.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.EToko.Model.Item;

@Service
public class ShoppingService {

    private final List<Item> keyboardPrices = Arrays.asList(
            new Item("Keyboard1", 30000),
            new Item("Keyboard2", 45000),
            new Item("Keyboard3", 15000)
    );

    private final List<Item> mousePrices = Arrays.asList(
            new Item("Mouse1", 12000),
            new Item("Mouse2", 20000),
            new Item("Mouse3", 35000)
    );

    public String getMaxSpent(int budget) {
        int maxSpent = -1;
        String bestCombo = "No valid combination found";

        for (Item keyboard : keyboardPrices) {
            for (Item mouse : mousePrices) {
                int total = keyboard.getPrice() + mouse.getPrice();
                if (total <= budget && total > maxSpent) {
                    maxSpent = total;
                    bestCombo = "Best Combo: " + keyboard.getName() + " and " + mouse.getName() + " with total spent: " + maxSpent;
                }
            }
        }
        return bestCombo;
    }

    public List<Item> getAllKeyboards() {
        return keyboardPrices;
    }

    public List<Item> getAllMice() {
        return mousePrices;
    }

    public List<Item> getAllItems() {
        List<Item> allItems = keyboardPrices.stream()
                .collect(Collectors.toList());
        allItems.addAll(mousePrices);
        return allItems;
    }
}
