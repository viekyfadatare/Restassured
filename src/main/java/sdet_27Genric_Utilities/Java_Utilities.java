package sdet_27Genric_Utilities;

import java.util.Random;

/**
 * 
 * @author admin
 *
 */

public class Java_Utilities {

	/**
	 * This method will gerate the random value for every run
	 * 
	 * @return
	 */
	public int getRandomNumber() {

		Random ran = new Random();

		int value = ran.nextInt(5000);

		return value;
	}

}
