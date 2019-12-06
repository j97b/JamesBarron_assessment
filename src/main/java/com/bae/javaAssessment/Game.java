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

	public boolean checkWin(Object player, Object goal) {
		if (player.getXCoord() == goal.getXCoord() && player.getYCoord() == goal.getYCoord()) {
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
		return ("~~~~~Welcome to the game~~~~~\n" + "Grey foggy clouds float oppressively close to you,\n"
				+ "reflected in the murky grey water which reaches up your shins.\n"
				+ "Some black plants barely poke out of the shallow water.\n"
				+ "Try \"north\", \"south\", \"east\", or \"west\"\n"
				+ "You notice a small watch-like device in your left hand.\n"
				+ "It has hands like a watch, but the hands don't seem to tell time.");
	}

	public void start() {
		scan = new Scanner(System.in);
		Object goal = new Object();
		Object player = new Object();
		setGoal(goal);
		player.setXCoord(0);
		player.setYCoord(0);
		System.out.print(intro() + "\n\n");
		playGame(player, goal);
		scan.close();
	}

	private void playRound(Object player, Object goal) {
		System.out.print("The dial reads: \'" + df.format(goalDistance(player, goal)) + "m\'\n>");
		String step = scan.nextLine();
		takeStep(step, player);
		checkWin(player, goal);
	}

	private void playGame(Object player, Object goal) {
		do {
			playRound(player, goal);
		} while (checkWin(player, goal) == false);
		System.out.println("Congratulations, you found the goal!");
	}
}
