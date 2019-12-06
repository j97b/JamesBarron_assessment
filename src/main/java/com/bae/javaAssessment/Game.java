package com.bae.javaAssessment;

import java.util.Random;

public class Game {
	
	Random rand = new Random();
	
	public Object setGoal(Object goal) {
		switch (rand.nextInt(4)) {
		case 0:
			goal.setXCoord(rand.nextInt(10)+5);
			goal.setYCoord(rand.nextInt(10)+5);
			return goal;
		case 1:
			goal.setXCoord(rand.nextInt(10)+5);
			goal.setYCoord(-(rand.nextInt(10)+5));
			return goal;
		case 2:
			goal.setXCoord(-(rand.nextInt(10)+5));
			goal.setYCoord(rand.nextInt(10)+5);
			return goal;
		case 3:
			goal.setXCoord(-(rand.nextInt(10)+5));
			goal.setYCoord(-(rand.nextInt(10)+5));
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
		case "south":
			object.setYCoord(object.getYCoord() - 1);
			return object;
		case "east":
			object.setXCoord(object.getXCoord() + 1);
			return object;	
		case "west":
			object.setXCoord(object.getXCoord() - 1);
			return object;
		}
		return object;
	}

	public double goalDistance(Object player, Object goal) {
		int xDist = player.getXCoord() - goal.getXCoord();
		int yDist = player.getYCoord() - goal.getYCoord();
		return Math.hypot((double) xDist, (double) yDist);
	}
	
	public String intro() {
		return ("~~~~~Welcome to the game~~~~~\n" +
				"Grey foggy clouds float oppressively close to you,\n" +
				"reflected in the murky grey water which reaches up your shins.\n" + 
				"Some black plants barely poke out of the shallow water.\n" + 
				"Try \"north\", \"south\", \"east\", or \"west\"\n" +
				"You notice a small watch-like device in your left hand.\n" +
				"It has hands like a watch, but the hands don't seem to tell time.");
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
