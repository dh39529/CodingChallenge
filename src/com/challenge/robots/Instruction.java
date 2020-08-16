package com.challenge.robots;

public enum Instruction {
	FORWARD("F"), RIGHT("R"), LEFT("L");
	
	String code;
	private Instruction(String code) {
		this.code = code;
	}
	
	public static Instruction getInstruction(String code) {
		switch (code) {
			case "F":
				return Instruction.FORWARD;
			case "R":
				return Instruction.RIGHT;
			case "L":
				return Instruction.LEFT;
		}
		return null;
	}

	public void moveRobot(Robot robot) {
		switch (code) {
			case "F":
				robot.moveLocation(1);
				break;
			case "R":
				robot.moveRight();;
				break;
			case "L":
				robot.moveLeft();
				break;
		}
		
	}
	
}
