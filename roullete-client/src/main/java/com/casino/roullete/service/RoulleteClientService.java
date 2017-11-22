package com.casino.roullete.service;

import org.springframework.web.client.RestTemplate;

import com.casino.roullete.model.Bet;

public class RoulleteClientService {

	private String admin_url = "http://localhost:8080/";

	RoulleteService gameService = new RoulleteService();

	public String checkUserId(String uuid) {
		final String uri = admin_url + "user/" + uuid;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		// System.out.println(result);
		return result;
	}

	public String blockAmount(String id, int blockedAmount) {
		final String uri = admin_url + "play/" + id + "/" + blockedAmount;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	public String settleAmount(String id, int blockedAmount, int prizeAmount) {
		final String uri = admin_url + "settle/" + id + "/" + blockedAmount + "/" + prizeAmount;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	public String readyToPlay(String id, Bet bet) {
		int blockAmt = gameService.getBlockedAmount(bet);
	//	System.out.println("blockamt : " + blockAmt);
		String res = this.blockAmount(id, blockAmt);
	//	System.out.println("blocked" + res);
		int key = gameService.getRandom();
	//	System.out.println("key" + key);
		int gameResult = gameService.playBet(bet, key);
	//	System.out.println("game res" + gameResult);
		String finalRes = this.settleAmount(id, blockAmt, gameResult);

		finalRes = finalRes.substring(0, finalRes.length() - 1);
		finalRes += ",\"randomNumberGenerated\"" + ":" + key + "}";

	//	System.out.println("final res" + finalRes);
		return finalRes;
	}
}
