package com.mmontsheng.library.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmontsheng.library.entities.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, String>{

}
