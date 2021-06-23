package com.sist.di05;

public class PersonInfo {
	private Person person;

	public PersonInfo() {
	}

	public PersonInfo(Person person) {
		this.person = person;
	}

	public void getPersonInfo() {
		if (person != null) {
			System.out.println("�̸�: " + person.getName());
			System.out.println("����: " + person.getGender());
			System.out.println("����: " + person.getAge());
			System.out.println("�ֹι�ȣ: " + person.getJuminNo());
		}
	}
}
