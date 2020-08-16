package com.challenge.robots;

public class Robot implements Moveable{

	private int xpos;
	private int ypos;
	private String directions[] = new String[] {"N", "E", "S", "W"};
	private int directionIndex;
	private boolean isLost;
	private boolean isMoved;
	
	
	public Robot(int x, int y, String direction) {
		xpos = x;
		ypos = y;
		int index = 0;
		for (String point : directions) {
			if (direction.equals(point)) {
				this.directionIndex = index;
				break;
			}
			index++;
		}
	}
	
	public int getXpos() {
		return xpos;
	}
	
	public int getYpos() {
		return ypos;
	}
	
	@Override
	public void move(String[] instructions) {

		for (String instruct : instructions) {
			if (isLost) {
				break;
			}
			Instruction instruction = Instruction.getInstruction(instruct);
			if (instruction != null) {
				instruction.moveRobot(this);
			}
		}
	}
	
	public void moveRight() {
		directionIndex = directionIndex < 3 ? directionIndex+1 : 0;
	}
	
	public void moveLeft() {
		directionIndex = directionIndex > 0 ? directionIndex-1 : 3;
	}
	
	public void moveLocation(int steps) {
		isMoved = false;
		switch (directionIndex) {
			case 0: 
				if (ypos < MarsGrid.getInstance().getMaxY()) {
					ypos+=steps;
					isMoved = true;
				} 
				break;
			case 1:
				if (xpos< MarsGrid.getInstance().getMaxX()) {
					xpos+=steps;
					isMoved = true;
				} 
				break;
			case 2:
				if (ypos > 0 ) {
					ypos-=steps;
					isMoved = true;
				}
				break;
			case 3:
				if (xpos > 0) {
					xpos-=steps;
					isMoved = true;
				}
				break;
		}
		if (!isMoved) {
			checkLost();
		}
	}

	private void checkLost() {
		if (!MarsGrid.getInstance().getLostRobots()[xpos][ypos]) {
			isLost = true;
			MarsGrid.getInstance().getLostRobots()[xpos][ypos] = true;
		}
	}
		
	public boolean isLost() {
		return isLost;
	}
	
	@Override
	public String toString() {
		return xpos + " " + ypos + " " + directions[directionIndex] + (isLost ? " LOST" : "");		
	}
	

}
