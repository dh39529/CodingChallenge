package com.challenge.robots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MarsGrid {

	private int maxX;
	private int maxY;
	private Map<String, List<Robot>> robotMap;
	private boolean[][] lostRobots;

	private static MarsGrid marsGrid;

	private MarsGrid() {
		robotMap = new HashMap<String, List<Robot>>();
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
	    lostRobots = new boolean[maxX+1][maxY+1];
	}
	
	public int getMaxX() {
		return maxX;
	}
	
	public int getMaxY() {
		return maxY;
	}
	
	public Map<String, List<Robot>> getRobotMap() {
		return robotMap;
	}
	
	public boolean[][] getLostRobots() {
		return lostRobots;
	}
	
	public void writeOutput() {
		for (List<Robot> robotList : robotMap.values()) {
			robotList.forEach(System.out::println);
		}
	}

	public void addRobot(Robot robot) {
		List<Robot> robotList = robotMap.get(robot.getXpos() + "," + robot.getYpos());
		if (robotList == null) {
			robotList = new ArrayList<>();
		} 
		robotList.add(robot);
		robotMap.put(robot.getXpos() + "," + robot.getYpos(), robotList);		
	}
}
