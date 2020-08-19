package com.challenge.robots;

public class Forward implements Command {

	@Override
	public void execute(Robot robot) {
			int x = -1, y = -1;
			switch (robot.getDirectionIndex()) {
				case 0: 
					if (robot.getYpos() < MarsGrid.getInstance().getMaxY()) {
						y = robot.getYpos() + 1;
						robot.setYPos(y);
					} 
					break;
				case 1:
					if (robot.getXpos() < MarsGrid.getInstance().getMaxX()) {
						x = robot.getXpos() + 1;
						robot.setXPos(x);
					} 
					break;
				case 2:
					if (robot.getYpos() > 0 ) {
						y = robot.getYpos() - 1;
						robot.setYPos(y);
					}
					break;
				case 3:
					if (robot.getXpos() > 0) {
						x = robot.getXpos() - 1;
						robot.setXPos(x);
					}
					break;
			}
			if (x + y ==-2 && !MarsGrid.getInstance().isScent(robot.getXpos(),robot.getYpos())) {
				robot.setLost();
				MarsGrid.getInstance().setScent(robot.getXpos(),robot.getYpos());
			}
	}

}
