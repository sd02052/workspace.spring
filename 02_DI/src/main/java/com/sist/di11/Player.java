package com.sist.di11;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Player {
	private String name;
	private int age;
	private ArrayList<String> position;
	private double weight;
	private double height;

	public Player(String name, int age, ArrayList<String> position) {
		this.name = name;
		this.age = age;
		this.position = position;
	}
}
