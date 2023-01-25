package com.company.automation.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordUtils {

	public static String getDecodedPassword(String encryptedPassword) {
		byte[] decoded = Base64.getDecoder().decode(encryptedPassword);
		return new String(decoded, StandardCharsets.UTF_8);
	}

	public static String getEncodedPassword(String plainPassword) {
		return Base64.getEncoder().encodeToString(plainPassword.getBytes(StandardCharsets.UTF_8));
	}
	
	public static void main(String[] args) {
		System.out.println(getEncodedPassword("ramu12!@"));
		System.out.println(getDecodedPassword("cmFtdTEyIUA="));
	}
}
