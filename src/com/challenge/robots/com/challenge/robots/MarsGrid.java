package com.challenge.robots;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarsGrid {

	private int maxX;
	private int maxY;
	private List<Robot> robots;
	private boolean[][] robotScents;

	private static MarsGrid marsGrid;

	private MarsGrid() {
		robots = new ArrayList<>();
	}
	
	public static MarsGrid getInstance() {
		if (marsGrid == null) {
			marsGrid = new MarsGrid();
		}
		return marsGrid;
	}
	
	public void setupGrid(int xMax, int yMax) {
		maxX = xMax;
		maxY = yMax;
		robotScents = new boolean[maxX+1][maxY+1];
	}
	
	public int getMaxX() {
		return maxX;
	}
	
	public int getMaxY() {
		return maxY;
	}
	
	public List<Robot> getRobots() {
		return robots;
	}
	
	public boolean isScent(int xPos, int yPos) {
		return robotScents[xPos][yPos];
	}
	public void setScent(int xPos, int yPos) {
		robotScents[xPos][yPos] = true;
	}
	
	public void writeOutput() {
			robots.forEach(System.out::println);
	}

	public void addRobot(Robot robot) {
		robots.add(robot);	
	}
	
	public void run() {
		robots.forEach(robot->issueInstructions(robot));
		robots.forEach(System.out::println);
	}
	
	private void issueInstructions(Robot robot) {
		Arrays.stream(robot.getInstructions().split("")).forEach(s -> {
																		if (!robot.isLost()) {
																			getCommand(s).execute(robot);
																		}
																	  }
																);
	}
	
	private Command getCommand(String instruction) {
		switch (instruction) {
			case "R" :
				return new TurnRight();			
			case "L" :
				return new TurnLeft();
			case "F" :
				return new Forward();
			default :
				return null;
		}
	
	}
}
