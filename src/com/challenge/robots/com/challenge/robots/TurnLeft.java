package com.challenge.robots;

public class TurnLeft implements Command {

	@Override
	public void execute(Robot robot) {	
		int directionIndex = robot.getDirectionIndex();
		robot.setDirectionIndex(directionIndex > 0 ? directionIndex-1 : 3);
	}

}
