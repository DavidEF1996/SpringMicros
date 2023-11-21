package com.msvc.inventory.inventoryservice.controller;

import com.msvc.inventory.inventoryservice.repository.InventoryRepository;
import com.msvc.inventory.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {


    @Autowired
    private InventoryService inventoryService;


    @GetMapping("/{skuCode}")
    public boolean isInStock(@PathVariable("skuCode") String skuCode){
        return inventoryService.isInStock(skuCode);

    }
}
