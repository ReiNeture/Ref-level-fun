package fubuki.ref.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Randoms {
	
	public static BigDecimal nextFloatBetween(float min, float max) {
	    return BigDecimal.valueOf((new Random().nextFloat() * (max - min)) + min);
	}
	
	public static BigDecimal defaultFloatDamage(BigDecimal baseDamage) {
		return baseDamage.add(
					baseDamage.multiply(
							nextFloatBetween(0.0f, 0.3f)
					)).setScale(0, RoundingMode.HALF_UP);
	}
	
	public static boolean Chance(int chance) {
		int n = new Random().nextInt(99); // Obtain a number between [0 - 99].
		return chance > n ? true : false; 
	}
}
