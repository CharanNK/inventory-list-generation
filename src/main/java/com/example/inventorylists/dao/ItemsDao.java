package com.example.inventorylists.dao;

import com.example.inventorylists.model.Items;
import org.springframework.data.repository.CrudRepository;

public interface ItemsDao extends CrudRepository<Items,Integer> {
}
