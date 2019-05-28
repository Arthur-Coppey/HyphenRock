package controller;

import java.util.Timer;

import contract.Direction;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class Controller implements IController {

	private final int FPS = 1;

	private IModel model;

	private IView view;

	private Timer timer;

	private Loop loop;

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.setLoop(new Loop(model));
	}

	@Override
	public void control() {
		this.view.printMessage("Jouez avec ZQSD");
	}

	@Override
	public void orderPerform(final Direction direction) {

		if (this.getLoop().getDirectionOrder() == null) {
			System.out.println(direction);
			this.getLoop().setDirectionOrder(direction);
		}
	}

	public void gameStart() {
		this.timer = new Timer();
		this.timer.schedule(this.getLoop(), 0, 1000 / this.FPS);
	};

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

	public Loop getLoop() {
		return this.loop;
	}

	public void setLoop(Loop loop) {
		this.loop = loop;
	}

}