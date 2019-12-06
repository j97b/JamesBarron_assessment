package com.bae.javaAssessment;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class javaAssessmentTests {
	
	Game game = new Game();
	Object goal = new Object();
	Object player = new Object();
	Object demogorgon = new Object();
	
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
	public void checkDemogorgonTest() {
		demogorgon.setXCoord(4);
		demogorgon.setYCoord(7);
		goal.setXCoord(4);
		goal.setYCoord(7);
		Assert.assertTrue(game.checkDemogorgon(demogorgon, goal));
		goal.setXCoord(3);
		Assert.assertFalse(game.checkDemogorgon(demogorgon, goal));
	}
	
	@Test
	public void checkDeadTest() {
		player.setXCoord(4);
		player.setYCoord(7);
		demogorgon.setXCoord(4);
		demogorgon.setYCoord(7);
		Assert.assertTrue(game.checkDead(player, demogorgon));
		player.setXCoord(3);
		Assert.assertFalse(game.checkDead(player, demogorgon));
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
		Assert.assertEquals("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Welcome to the game~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n" + 
						       "      You are in the Upside Down. The demogorgon knows you are here, and\n" + 
							   "           is hunting you down. The only way out is to find the exit.\n" + 
							   "     Luckily, you have a device in your hand that tells you how far away\n" + 
							   "  the exit is in a straight line. It also shows how far away the demogorgon is.\n" + 
							   "   Try \"North\", \"South\", \"East\" or \"West\". If the demogorgon reaches the exit\n" + 
							   " before you do, you will be trapped here forever. If the demogorgon reaches you\n" + 
							   "                before you reach the exit, you will be devoured.\n" + 
							   "                                 Good luck.", game.intro());
	}
	
	@Test
	public void randomStepTest() {
		Assert.assertFalse(!game.randomStep().equals("north") && !game.randomStep().equals("south") && !game.randomStep().equals("east") && !game.randomStep().equals("west"));
	}
}
