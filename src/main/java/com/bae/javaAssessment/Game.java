package com.bae.javaAssessment;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Game {

	Random rand = new Random();
	DecimalFormat df = new DecimalFormat("#.##");
	Scanner scan;

	public Object setGoal(Object goal) {
		switch (rand.nextInt(4)) {
		case 0:
			goal.setXCoord(rand.nextInt(10) + 5);
			goal.setYCoord(rand.nextInt(10) + 5);
			return goal;
		case 1:
			goal.setXCoord(rand.nextInt(10) + 5);
			goal.setYCoord(-(rand.nextInt(10) + 5));
			return goal;
		case 2:
			goal.setXCoord(-(rand.nextInt(10) + 5));
			goal.setYCoord(rand.nextInt(10) + 5);
			return goal;
		case 3:
			goal.setXCoord(-(rand.nextInt(10) + 5));
			goal.setYCoord(-(rand.nextInt(10) + 5));
			return goal;
		}
		return goal;
	}

	public Object setDemogorgon(Object demogorgon) {
		switch (rand.nextInt(4)) {
		case 0:
			demogorgon.setXCoord(rand.nextInt(10));
			demogorgon.setYCoord(rand.nextInt(10));
			return demogorgon;
		case 1:
			demogorgon.setXCoord(rand.nextInt(10));
			demogorgon.setYCoord(-(rand.nextInt(10)));
			return demogorgon;
		case 2:
			demogorgon.setXCoord(-(rand.nextInt(10)));
			demogorgon.setYCoord(rand.nextInt(10));
			return demogorgon;
		case 3:
			demogorgon.setXCoord(-(rand.nextInt(10)));
			demogorgon.setYCoord(-(rand.nextInt(10)));
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
			object.setYCoord(object.getYCoord() + 1);
			return object;
		case "n":
			object.setYCoord(object.getYCoord() + 1);
			return object;
		case "south":
			object.setYCoord(object.getYCoord() - 1);
			return object;
		case "s":
			object.setYCoord(object.getYCoord() - 1);
			return object;
		case "east":
			object.setXCoord(object.getXCoord() + 1);
			return object;
		case "e":
			object.setXCoord(object.getXCoord() + 1);
			return object;
		case "west":
			object.setXCoord(object.getXCoord() - 1);
			return object;
		case "w":
			object.setXCoord(object.getXCoord() - 1);
			return object;
		default:
			System.out.println("Try North, South, East, West");
			return object;
		}
	}

	public double goalDistance(Object player, Object goal) {
		int xDist = player.getXCoord() - goal.getXCoord();
		int yDist = player.getYCoord() - goal.getYCoord();
		return Math.hypot((double) xDist, (double) yDist);
	}

	public String intro() {
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

	public void start() {
		scan = new Scanner(System.in);
		Object goal = new Object();
		Object player = new Object();
		Object demogorgon = new Object();
		setGoal(goal);
		setDemogorgon(demogorgon);
		player.setXCoord(0);
		player.setYCoord(0);
		System.out.print(intro() + "\n\n");
		playGame(player, goal, demogorgon);
		scan.close();
	}

	private void playRound(Object player, Object goal, Object demogorgon) {
		System.out.print("The device reads: \'" + df.format(goalDistance(player, goal)) + "m\'\nThe demogorgon is " + df.format(goalDistance(player, demogorgon)) + " metres away\n>");
		String step = scan.nextLine();
		takeStep(step, player);
		takeStep(randomStep(), demogorgon);
		checkWin(player, goal);
	}
	
	private String randomStep() {
		String s = "";
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

	private void playGame(Object player, Object goal, Object demogorgon) {
		do {
			playRound(player, goal, demogorgon);
		} while (checkWin(player, goal) == false && checkDemogorgon(demogorgon, goal) == false
				&& checkDead(demogorgon, player) == false);
		if (checkDead(demogorgon, player) == true) {
			System.out.println("The demogorgon got you! You die screaming");
		} else if (checkDemogorgon(demogorgon, goal) == true) {
			System.out.println("The demogorgon is at the exit, you can't escape.\nYou slowly starve to death");
		} else {
			System.out.println("Congratulations, you found the goal!");
		}
	}
}
