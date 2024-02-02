package com.msvc.inventory.inventoryservice.controller;

import com.msvc.inventory.inventoryservice.dto.InventoryResponse;
import com.msvc.inventory.inventoryservice.repository.InventoryRepository;
import com.msvc.inventory.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {


    @Autowired
    private InventoryService inventoryService;


    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);

    }
}
