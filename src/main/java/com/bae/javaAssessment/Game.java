package com.bae.javaAssessment;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

	Random rand = new Random();
	DecimalFormat df = new DecimalFormat("#.##");
	Scanner scan;

	public Object setGoal(Object goal) {
		switch (rand.nextInt(4)) {
		case 0:
			goal.setXCoord(rand.nextInt(5) + 5);
			goal.setYCoord(rand.nextInt(5) + 5);
			return goal;
		case 1:
			goal.setXCoord(rand.nextInt(5) + 5);
			goal.setYCoord(-(rand.nextInt(5) + 5));
			return goal;
		case 2:
			goal.setXCoord(-(rand.nextInt(5) + 5));
			goal.setYCoord(rand.nextInt(5) + 5);
			return goal;
		case 3:
			goal.setXCoord(-(rand.nextInt(5) + 5));
			goal.setYCoord(-(rand.nextInt(5) + 5));
			return goal;
		}
		return goal;
	}

	public Object setDemogorgon(Object demogorgon) {
		switch (rand.nextInt(4)) {
		case 0:
			demogorgon.setXCoord(rand.nextInt(10) + 15);
			demogorgon.setYCoord(rand.nextInt(10) + 15);
			return demogorgon;
		case 1:
			demogorgon.setXCoord(rand.nextInt(10) + 15);
			demogorgon.setYCoord(-(rand.nextInt(10) + 15));
			return demogorgon;
		case 2:
			demogorgon.setXCoord(-(rand.nextInt(10) + 15));
			demogorgon.setYCoord(rand.nextInt(10) + 15);
			return demogorgon;
		case 3:
			demogorgon.setXCoord(-(rand.nextInt(10) + 15));
			demogorgon.setYCoord(-(rand.nextInt(10) + 15));
			return demogorgon;
		}
		return demogorgon;
	}

	public boolean checkWin(Object player, Object goal) {
		if (player.getXCoord() == goal.getXCoord() && player.getYCoord() == goal.getYCoord()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDemogorgon(Object demogorgon, Object goal) {
		if (demogorgon.getXCoord() == goal.getXCoord() && demogorgon.getYCoord() == goal.getYCoord()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDead(Object player, Object demogorgon) {
		if (player.getXCoord() == demogorgon.getXCoord() && player.getYCoord() == demogorgon.getYCoord()) {
			return true;
		} else {
			return false;
		}
	}

	public Object takeStep(String step, Object object) {
		switch (step.toLowerCase()) {
		case "north":
		case "n":
			object.setYCoord(object.getYCoord() + 1);
			return object;
		case "south":
		case "s":
			object.setYCoord(object.getYCoord() - 1);
			return object;
		case "east":
		case "e":
			object.setXCoord(object.getXCoord() + 1);
			return object;
		case "west":
		case "w":
			object.setXCoord(object.getXCoord() - 1);
			return object;
		default:
			System.out.println("Try North, South, East, West");
			return object;
		}
	}
	

	public String randomStep() {
		String s = "north";
		switch (rand.nextInt(4)) {
		case 0:
			s = "north";
			return s;
		case 1:
			s = "south";
			return s;
		case 2:
			s = "east";
			return s;
		case 3:
			s = "west";
			return s;
		}
		return s;
	}
	
	public int square(int a) {
		return a * a;
	}
	
	
	public void demogorgonStep(Object demogorgon, Object player, Object goal) {
		if (getDistance(demogorgon, player) <= getDistance(demogorgon, goal)) {
			takeStep(demogorgonChoice(demogorgon, player), demogorgon);
		} else {
			takeStep(demogorgonChoice(demogorgon, goal), demogorgon);
		}
	}
	
	
	public String demogorgonChoice(Object demogorgon, Object object) {
		int xDist = demogorgon.getXCoord() - object.getXCoord();
		int yDist = demogorgon.getYCoord() - object.getYCoord();
		String choice = "";
		if (square(xDist) > square(yDist) ) {
			if (xDist < 0) {
				choice = "east";
				return choice;
			} else {
				choice = "west";
				return choice;
			}
		} else {
			if (yDist < 0) {
				choice = "north";
				return choice;
			} else {
				choice = "south";
				return choice;
			}
		}
	}
	
	
	
	

	public double getDistance(Object player, Object goal) {
		int xDist = player.getXCoord() - goal.getXCoord();
		int yDist = player.getYCoord() - goal.getYCoord();
		return Math.hypot((double) xDist, (double) yDist);
	}

	public String introOld() {
		return ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Welcome to the game~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"
				+ "      You are in the Upside Down. The demogorgon knows you are here, and\n"
				+ "           is hunting you down. The only way out is to find the exit.\n"
				+ "     Luckily, you have a device in your hand that tells you how far away\n"
				+ "  the exit is in a straight line. It also shows how far away the demogorgon is.\n"
				+ "   Try \"North\", \"South\", \"East\" or \"West\". If the demogorgon reaches the exit\n"
				+ " before you do, you will be trapped here forever. If the demogorgon reaches you\n"
				+ "                before you reach the exit, you will be devoured.\n"
				+ "                                 Good luck.");
	}
	
	public void intro() throws InterruptedException {
		printOut("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Welcome to the game~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("\n\n      ");
		printOut("You are in the Upside Down. The demogorgon knows you are here, and");
		System.out.print("\n           ");
		printOut("is hunting you down. The only way out is to find the exit.");
		System.out.print("\n     ");
		printOut("Luckily, you have a device in your hand that tells you how far away");
		System.out.print("\n  ");
		printOut("the exit is in a straight line. It also shows how far away the demogorgon is.");
		System.out.print("\n   ");
		printOut("Try \"North\", \"South\", \"East\" or \"West\". If the demogorgon reaches the exit");
		System.out.print("\n ");
		printOut("before you do, you will be trapped here forever. If the demogorgon reaches you");
		System.out.print("\n                ");
		printOut("before you reach the exit, you will be devoured.");
		System.out.print("\n                                 ");
		printOut("Good luck.");
	}

	public void start() throws InterruptedException {
		scan = new Scanner(System.in);
		boolean play = true;
		while (play = true) {
		Object goal = new Object();
		Object player = new Object();
		Object demogorgon = new Object();
		setGoal(goal);
		setDemogorgon(demogorgon);	
		player.setXCoord(0);
		player.setYCoord(0);
		intro();
		System.out.print("\n\n");
		playGame(player, goal, demogorgon, play);
		}
		scan.close();
	}

	private void playRound(Object player, Object goal, Object demogorgon, boolean play) {
		if (getDistance(demogorgon, player) < 4) {
			System.out.println("The demogorgon apporoaches");
		}
		if (getDistance(demogorgon, goal) < 4) {
			System.out.println("The demogorgon is getting close to the exit");
		}
		System.out.print("The device reads: \'" + df.format(getDistance(player, goal)) + "m\'\n");
		String step = scan.nextLine();
		takeStep(step, player);
		demogorgonStep(demogorgon, player, goal);
		checkWin(player, goal);
	}


	private void playGame(Object player, Object goal, Object demogorgon, boolean play) throws InterruptedException {
		do {
			playRound(player, goal, demogorgon, play);
		} while (checkWin(player, goal) == false && checkDemogorgon(demogorgon, goal) == false
				&& checkDead(demogorgon, player) == false);
		if (checkDead(demogorgon, player) == true) {
			System.out.println("\nThe demogorgon got you! You die screaming");
		} else if (checkDemogorgon(demogorgon, goal) == true) {
			System.out.println("\nThe demogorgon is at the exit, you can't escape.\nYou slowly starve to death");
		} else {
			System.out.println("\nCongratulations, you found the goal!");
		}
		TimeUnit.SECONDS.sleep(2);
		System.out.println("\nWant to play again? Press enter to play again, or enter \'Exit\' to exit the game");
		if (scan.nextLine().equalsIgnoreCase("exit")) {
			System.out.println("Thank you for playing");
			System.exit(0);
		} else {
			System.out.println("Starting a new game");
			TimeUnit.SECONDS.sleep(2);
		}
	}
	
	public void printOut(String s) throws InterruptedException {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '\"') {
				System.out.print('\"');
				TimeUnit.MILLISECONDS.sleep(10);
			} else {
				System.out.print(s.charAt(i));
				TimeUnit.MILLISECONDS.sleep(10);
			}
		}
	}
	
}
