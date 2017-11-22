package com.casino.roullete.service;

import java.util.Random;

import com.casino.roullete.model.Bet;

public class RoulleteService {

	public int getRandom() {
		Random key = new Random();
		return key.nextInt(37);
	}

	public int getBlockedAmount(Bet bet) {
		int sum = 0;
		sum += bet.getFirst12();
		sum += bet.getSecond12();
		sum += bet.getThird12();
		sum += bet.getOneTo18();
		sum += bet.getNineteenTo36();
		sum += bet.getEven();
		sum += bet.getOdd();
		sum += bet.getZeroth();
		return sum;
	}

	public int playBet(Bet bet, int key) {
		int result = 0;
		if (1 <= key && key <= 12)
			result += bet.getFirst12() * 1.5;
		if (13 <= key && key <= 24)
			result += bet.getSecond12() * 1.5;
		if (25 <= key && key <= 36)
			result += bet.getThird12() * 1.5;
		if (key == 0)
			result += bet.getZeroth() * 10;
		if (1 <= key && key <= 18)
			result += bet.getOneTo18() * 1.25;
		if (19 <= key && key <= 36)
			result += bet.getNineteenTo36() * 1.25;
		if (key % 2 == 0)
			result += bet.getEven() * 1.25;
		if (key % 2 == 1)
			result += bet.getOdd() * 1.25;
		return result;
	}
}
