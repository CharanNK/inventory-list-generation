package com.example.inventorylists.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="items")
public class Items {
    @Id
    @GeneratedValue
    private int index;
    private String category;
    private String subCategory;
    private String itemName;
    private String kannadaName;
    private int weight;
    private String unit;
    private double price;
    private int floor;
    private int shelf_no;
}
