package com.nagarro.casino.helper;

import java.util.UUID;

public class Helper {
	

	public static String getUid(){
		String uuid ="";
		uuid= UUID.randomUUID().toString();
		return uuid;
	}
}
