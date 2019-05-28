package controller;

import contract.Direction;

public class Loop extends java.util.TimerTask {
	private Direction directionOrder = null;

	@Override
	public void run() {
		this.directionOrder = null;
		System.out.println("aze");

	}

	public Direction getDirectionOrder() {
		return this.directionOrder;
	}

	public void setDirectionOrder(Direction order) {
		this.directionOrder = order;
	}

}
