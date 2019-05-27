package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;


import contract.Direction;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class View implements IView, Runnable {

	private final ViewFrame viewFrame;

	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	protected static Direction keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_A:
				return Direction.UP;
			case KeyEvent.VK_S:
				return Direction.DOWN;
			case KeyEvent.VK_Q:
				return Direction.LEFT;
			case KeyEvent.VK_D:
				return Direction.RIGHT;
			default:
				return null;
		}
	}

	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	public void run() {
		this.viewFrame.setVisible(true);
	}

	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
