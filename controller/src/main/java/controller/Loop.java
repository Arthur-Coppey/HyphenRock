package controller;

import contract.Direction;
import contract.IModel;

public class Loop extends java.util.TimerTask {
	private Direction directionOrder = null;
	private IModel model;

	public Loop(IModel Model) {
		this.setModel(Model);
	}

	@Override
	public void run() {
		try {
			this.model.gameUpdate(this.directionOrder);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDirectionOrder(null);
		System.out.println("aze");

	}

	public Direction getDirectionOrder() {
		return this.directionOrder;
	}

	public void setDirectionOrder(Direction order) {
		this.directionOrder = order;
	}

	public IModel getModel() {
		return this.model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

}
