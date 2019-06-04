package controller;

import contract.Direction;
import contract.IModel;

public class Loop extends java.util.TimerTask {

	private Direction directionOrder;
	private IModel model;

	public Loop(final IModel Model) {
		this.resetDirectionOrder();
		this.setModel(Model);
	}

	public Direction getDirectionOrder() {
		return this.directionOrder;
	}

	public IModel getModel() {
		return this.model;
	}

	@Override
	public void run() {
		try {
			this.model.gameUpdate(this.directionOrder);
		} catch (final Exception error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
		}
		this.resetDirectionOrder();

	}

	public void setDirectionOrder(final Direction order) {
		this.directionOrder = order;
	}

	public void resetDirectionOrder() {
		this.setDirectionOrder(Direction.NULL);
	}

	public void setModel(final IModel model) {
		this.model = model;
	}

}
