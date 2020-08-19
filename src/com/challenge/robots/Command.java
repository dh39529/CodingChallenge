package com.challenge.robots;

@FunctionalInterface
public interface Command {
	public void execute(Robot robot);
		
}
