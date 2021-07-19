package com.example.inventorylists.controller;

import com.example.inventorylists.dao.ItemsDao;
import com.example.inventorylists.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AdminController {
    @Autowired ItemsDao itemsDao;

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hello World!";
    }

    @RequestMapping(value = "/items",method= RequestMethod.GET)
    public List<Items> getAllItems(){
        return (List<Items>) itemsDao.findAll();
    }
}
