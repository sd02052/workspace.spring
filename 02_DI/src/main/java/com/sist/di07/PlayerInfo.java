package com.sist.di07;

import lombok.Data;

@Data
public class PlayerInfo {
	private Player player;

	public void getPlayerInfo() {
		System.out.println("이름: " + player.getName());
		System.out.println("나이: " + player.getAge());
		System.out.println("포지션: " + player.getPosition());
		System.out.println("체중: " + player.getWeight());
		System.out.println("키: " + player.getHeight());
	}
}
