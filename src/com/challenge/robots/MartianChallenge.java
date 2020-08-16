package com.challenge.robots;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MartianChallenge {

	private static final String GRID_RANGE = "[0-9]\\d{0,1}\\s+[0-9]\\d{0,1}";
	private static final String ROBOT_LOCATION = GRID_RANGE + "\\s+[N,S,E,W]";
	private static final String MOVE_INSTRUCTIONS = "[F,L,R]{1,50}";

	
	private static MarsGrid createMarsGrid(String gridSize) {
		MarsGrid marsGrid = null;
		if (gridSize.matches(GRID_RANGE)) {
		    String[] parts = gridSize.split("\\s+");
			marsGrid = MarsGrid.getInstance();
		    marsGrid.setupGrid(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		} else {
			System.out.println("Invalid grid dimensions found in input file");
			System.exit(99);
		} 		
		return marsGrid;
	}
	
	private static Robot createRobot(MarsGrid marsGrid, String robotPosition) {
		Robot robot = null;
		if (robotPosition.matches(ROBOT_LOCATION)) {
			String [] parts = robotPosition.split("\\s+");
			int xpos = Integer.parseInt(parts[0]);
			int ypos = Integer.parseInt(parts[1]);
			if (xpos >= 0 && xpos <= marsGrid.getMaxX() && ypos >=0 && ypos <= marsGrid.getMaxY()) {
				robot = new Robot(xpos, ypos, parts[2]);
				marsGrid.addRobot(robot);
			}
		} else {
			System.out.println("Invalid format for robot location found in input file");
			System.exit(99);			
		}
		return robot;
	}
		
	private static String[] getInstructions(String instructions) {
		if (instructions.matches(MOVE_INSTRUCTIONS)) {
			return instructions.split("");
		} else {
			System.out.println("Invalid format for robot instruction set found in input file");
			System.exit(99);						
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		int lineIndex = 0;
		Robot robot = null;
		MarsGrid marsGrid = null;
		try {
			for (String line : Files.readAllLines(Paths.get("./robotInstructions.txt"))) {
				if (line.trim().isEmpty()) {
					continue;
				}
				if (lineIndex == 0) {
					marsGrid = createMarsGrid(line);
					lineIndex++;
				} else if (lineIndex == 1) {
					robot = createRobot(marsGrid, line);
					lineIndex++;
				} else {
					String[] instructions = getInstructions(line);
					if (robot == null) {
						System.out.println("Invalid robot location in input file - instructions ignored");
					} else if (instructions != null) {
						robot.move(instructions);
					}
					lineIndex = 1;
				}
			}
		} catch (IOException e) {
			System.out.println("Input text file <robotInstructions.txt> not found!");
			System.exit(99);
		}	
		marsGrid.writeOutput();
	}
}
