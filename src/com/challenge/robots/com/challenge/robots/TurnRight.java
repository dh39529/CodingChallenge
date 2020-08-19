package com.challenge.robots;

public class TurnRight implements Command {

	@Override
	public void execute(Robot robot) {
		int directionIndex = robot.getDirectionIndex();
		robot.setDirectionIndex(directionIndex < 3 ? directionIndex+1 : 0);
	}

}
