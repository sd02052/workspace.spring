package com.sist.di08;

import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MapTest {
	private Map<Integer, String> map;

	// 비지니스 로직
	public void output() {
		// keySet() : Map에 있는 키를 전부 다 가져옴.
		Set<Integer> set = map.keySet();
		for (Integer k : set) {
			System.out.println(map.get(k));
		}
	}
}
