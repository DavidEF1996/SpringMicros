package com.msvc.inventory.inventoryservice;

import com.msvc.inventory.inventoryservice.model.InventoryModel;
import com.msvc.inventory.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			InventoryModel inventoryModel = new InventoryModel();
			InventoryModel inventoryModel2 = new InventoryModel();

			inventoryModel.setSkuCode("iphone123");
			inventoryModel.setAmount(100);

			inventoryModel2.setSkuCode("asus123");
			inventoryModel2.setAmount(33);

			inventoryRepository.save(inventoryModel);
			inventoryRepository.save(inventoryModel2);
			//forma de agregar datos a la base sin necesidad de un rest



		};
	}

}
