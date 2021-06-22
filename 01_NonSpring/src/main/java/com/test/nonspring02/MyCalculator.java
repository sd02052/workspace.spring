package com.test.nonspring02;

public class MyCalculator {

	private int firstNum;
	private int secondNum;
	private Calculator calculator;

	// �⺻ ������
	public MyCalculator() {

	}

	// ���� ������
	public MyCalculator(int firstNum, int secondNum, Calculator calculator) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.calculator = calculator;
	}

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	// �����Ͻ� ����
	public void result() {
		int value = calculator.sum(firstNum, secondNum);
		System.out.println("result >>> " + value);
	}
}
