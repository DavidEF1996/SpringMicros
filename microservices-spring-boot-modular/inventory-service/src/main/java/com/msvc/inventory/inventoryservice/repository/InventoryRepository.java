package com.msvc.inventory.inventoryservice.repository;

import com.msvc.inventory.inventoryservice.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryModel, Long> {


    Optional<InventoryModel> findBySkuCode(String skuCode);


}
