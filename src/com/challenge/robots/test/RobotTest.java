package com.challenge.robots.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.challenge.robots.MarsGrid;
import com.challenge.robots.Robot;

public class RobotTest {
	
	@Before
	public void setup() {
		MarsGrid.getInstance().setupGrid(5, 8);
	}
	
	@Test
	public void lostInMiddleOfInstructionSet() {
		Robot testRobot = new Robot(1,1,"E");
		testRobot.move("FFRRFLRLFFFFF".split(""));
		assertEquals("Incorrect robot location ", "2 0 S LOST", testRobot.toString());
		testRobot.move("RRFFF".split(""));
		//robot lost therefore no change to location
		assertEquals("Robot is lost no location change ", "2 0 S LOST", testRobot.toString());
	}
	
	@Test
	public void notLostAfterFullInstructionSet() {
		Robot testRobot = new Robot(3,3,"S");
		testRobot.move("RFFRFFLFRRFFRFFFLLFFFFFFRFFFLLLFFFFFFFF".split(""));
		assertEquals("Incorrect robot location ", "5 0 S", testRobot.toString());		
	}
	
	@Test
	public void topLeftTest() {
		Robot testRobot = new Robot(0,8,"S");
		testRobot.move("FLFLFLFF".split(""));
		assertEquals("Incorrect robot location ", "0 8 W LOST", testRobot.toString());		
	}

	@Test
	public void topRightAndScentTest() {
		Robot testRobot = new Robot(5,8,"W");
		testRobot.move("FLFRRFRFF".split(""));
		assertEquals("Incorrect robot location ", "5 8 E LOST", testRobot.toString());		
		testRobot = new Robot(5,8,"E");
		testRobot.move("F".split(""));
		assertTrue("Robot should not be lost, scent exists", !testRobot.isLost());		
	}

	@Test
	public void bottomLeftTest() {
		Robot testRobot = new Robot(0,0,"N");
		testRobot.move("FRFRFRFLF".split(""));
		assertEquals("Incorrect robot location ", "0 0 S LOST", testRobot.toString());		
	}

	@Test
	public void bottomRightTest() {
		Robot testRobot = new Robot(5,0,"E");
		testRobot.move("F".split(""));
		assertEquals("Incorrect robot location ", "5 0 E LOST", testRobot.toString());		
	}
	
	@Test
	public void singlePointandScentTest() {
		MarsGrid.getInstance().setupGrid(0, 0);
		Robot testRobot = new Robot(0,0,"N");
		testRobot.move("F".split(""));
		assertTrue("Robot should be lost", testRobot.isLost());		
		testRobot = new Robot(0,0,"S");
		testRobot.move("F".split(""));
		assertTrue("Robot should not be lost, scent exists", !testRobot.isLost());		
	}

}
