package com.bae.javaAssessment;

import java.util.concurrent.TimeUnit;

public class test {

	public void printOut(String s) throws InterruptedException {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '\"') {
				System.out.print('\"');
				TimeUnit.MILLISECONDS.sleep(5);
			} else {
				System.out.print(s.charAt(i));
			}
		}
	}

}
