package com.bae.javaAssessment;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class javaAssessmentTests {
	
	Game game = new Game();
	Object goal = new Object();
	Object player = new Object();
	
	@Test
	public void setGoalTest() {
		goal = game.setGoal(goal);
		Assert.assertTrue(Math.hypot(4, 4) < Math.hypot(goal.getXCoord(), goal.getYCoord()));
	}
	
	@Test
	public void checkWinTest() {
		player.setXCoord(4);
		player.setYCoord(7);
		goal.setXCoord(4);
		goal.setYCoord(7);
		Assert.assertTrue(game.checkWin(player, goal));
		goal.setXCoord(3);
		Assert.assertFalse(game.checkWin(player, goal));
	}
	
	@Test
	public void takeStepTest() {
		player.setXCoord(0);
		player.setYCoord(0);
		game.takeStep("north", player);
		Assert.assertTrue(0 == player.getXCoord() && 1 == player.getYCoord());
		player.setXCoord(0);
		player.setYCoord(0);
		game.takeStep("EAst", player);
		Assert.assertTrue(1 == player.getXCoord() && 0 == player.getYCoord());
		player.setXCoord(0);
		player.setYCoord(0);
		game.takeStep("South", player);
		Assert.assertTrue(0 == player.getXCoord() && -1 == player.getYCoord());
		player.setXCoord(0);
		player.setYCoord(0);
		game.takeStep("WEST", player);
		Assert.assertTrue(-1 == player.getXCoord() && 0 == player.getYCoord());
		player.setXCoord(0);
		player.setYCoord(0);
		game.takeStep("n", player);
		Assert.assertTrue(0 == player.getXCoord() && 1 == player.getYCoord());
		player.setXCoord(0);
		player.setYCoord(0);
		game.takeStep("E", player);
		Assert.assertTrue(1 == player.getXCoord() && 0 == player.getYCoord());
		player.setXCoord(0);
		player.setYCoord(0);
		game.takeStep("s", player);
		Assert.assertTrue(0 == player.getXCoord() && -1 == player.getYCoord());
		player.setXCoord(0);
		player.setYCoord(0);
		game.takeStep("W", player);
		Assert.assertTrue(-1 == player.getXCoord() && 0 == player.getYCoord());
		player.setXCoord(0);
		player.setYCoord(0);
		game.takeStep("I can't follow simple instructions", player);
		Assert.assertTrue(0 == player.getXCoord() && 0 == player.getYCoord());
	}
	
	@Test
	public void goalDistanceTest() {
		player.setXCoord(4);
		player.setYCoord(7);
		goal.setXCoord(8);
		goal.setYCoord(13);
		double distance = game.goalDistance(player, goal);
		Assert.assertTrue(Math.hypot(4, 6) == distance);
	}
	
	@Test
	public void introTest() {
		Assert.assertEquals("~~~~~Welcome to the game~~~~~\n" +
				"Grey foggy clouds float oppressively close to you,\n" +
				"reflected in the murky grey water which reaches up your shins.\n" + 
				"Some black plants barely poke out of the shallow water.\n" + 
				"Try \"north\", \"south\", \"east\", or \"west\"\n" +
				"You notice a small watch-like device in your left hand.\n" +
				"It has hands like a watch, but the hands don't seem to tell time.", game.intro());
	}

}
