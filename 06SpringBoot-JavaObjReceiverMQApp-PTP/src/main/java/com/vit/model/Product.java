package com.vit.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements Serializable{

	private int id;
	private String name;
	private double price;

}
