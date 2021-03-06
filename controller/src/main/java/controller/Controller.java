package controller;

import java.util.Timer;

import contract.Direction;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class Controller implements IController {

	private final int FPS = 4;

	private Loop loop;

	private IModel model;

	private IView view;

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.setLoop(new Loop(this.model));
		this.view.setController(this);
	}

	@Override
	public void control() {
		// this.view.printMessage("Jouez avec ZQSD");
	}

	public void gameStart() {
		final Timer timer = new Timer();
		timer.schedule(this.getLoop(), 0, 1000 / this.FPS);
	}

	public Loop getLoop() {
		return this.loop;
	}

	@Override
	public void orderPerform(final Direction direction) {
		if (this.getLoop().getDirectionOrder() == Direction.NULL) {

			this.getLoop().setDirectionOrder(direction);
		}
	}

	public void setLoop(final Loop loop) {
		this.loop = loop;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Sets the view.
	 *
	 * @param pview
	 *            the new view
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

}
