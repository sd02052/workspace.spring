package com.sist.di08;

import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MapTest {
	private Map<Integer, String> map;

	// �����Ͻ� ����
	public void output() {
		// keySet() : Map�� �ִ� Ű�� ���� �� ������.
		Set<Integer> set = map.keySet();
		for (Integer k : set) {
			System.out.println(map.get(k));
		}
	}
}
