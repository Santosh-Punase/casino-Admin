package com.casino.roullete.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casino.roullete.model.Bet;
import com.casino.roullete.service.RoulleteClientService;

@CrossOrigin("*")
@RestController
public class MainController {

	RoulleteClientService clientService = new RoulleteClientService();

	@GetMapping(value = "/user/{uuid}")
	public String checkUserId(@PathVariable("uuid") String uuid) {
		String result = clientService.checkUserId(uuid);
		// System.out.println(result);
		return result;
	}

	@GetMapping(value = "/play/{id}/{blockedAmount}")
	public String blockAmount(@PathVariable("id") String id, @PathVariable("blockedAmount") int blockedAmount) {

		String result = clientService.blockAmount(id, blockedAmount);
		return result;
	}

	@PostMapping(value = "/playGame/{id}")
	public String readyToPlay(@PathVariable("id") String id, @RequestBody Bet bet) {
		// System.out.println("id : " + id);
		// System.out.println("bet : " + bet);
		String result = clientService.readyToPlay(id, bet);
		// System.out.println(result);
		return result;
	}
}
