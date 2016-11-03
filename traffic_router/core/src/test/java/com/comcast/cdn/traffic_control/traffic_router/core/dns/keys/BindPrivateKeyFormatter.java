package com.comcast.cdn.traffic_control.traffic_router.core.dns.keys;

import sun.security.rsa.RSAPrivateCrtKeyImpl;

import java.math.BigInteger;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.security.spec.RSAMultiPrimePrivateCrtKeySpec;

import static java.util.Base64.getEncoder;

public class BindPrivateKeyFormatter {
	String encode(BigInteger bigInteger) {
		return new String(getEncoder().encode(bigInteger.toByteArray()));
	}

	public String format(RSAMultiPrimePrivateCrtKeySpec spec) {
		return "Private-key-format: v1.2\n" +
			"Algorithm: 5 (RSASHA1)\n" +
			"Modulus: " + encode(spec.getModulus()) + "\n" +
			"PublicExponent: " + encode(spec.getPublicExponent()) + "\n" +
			"PrivateExponent: " + encode(spec.getPrivateExponent()) + "\n" +
			"Prime1: " + encode(spec.getPrimeP()) + "\n" +
			"Prime2: " + encode(spec.getPrimeQ()) + "\n" +
			"Exponent1: " + encode(spec.getPrimeExponentP()) + "\n" +
			"Exponent2: " + encode(spec.getPrimeExponentQ())+ "\n" +
			"Coefficient: " + encode(spec.getCrtCoefficient())+ "\n";
	}

	public String format(RSAPrivateCrtKeyImpl key) {
		return "Private-key-format: v1.2\n" +
			"Algorithm: 5 (RSASHA1)\n" +
			"Modulus: " + encode(key.getModulus()) + "\n" +
			"PublicExponent: " + encode(key.getPublicExponent()) + "\n" +
			"PrivateExponent: " + encode(key.getPrivateExponent()) + "\n" +
			"Prime1: " + encode(key.getPrimeP()) + "\n" +
			"Prime2: " + encode(key.getPrimeQ()) + "\n" +
			"Exponent1: " + encode(key.getPrimeExponentP()) + "\n" +
			"Exponent2: " + encode(key.getPrimeExponentQ())+ "\n" +
			"Coefficient: " + encode(key.getCrtCoefficient())+ "\n";
	}
}
