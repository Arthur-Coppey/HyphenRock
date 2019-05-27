package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;

class ViewFrame extends JFrame implements KeyListener {

	private IModel model;

	private IController controller;

	private static final long serialVersionUID = -697358409737458175L;
	private static final int FRAMEHEIGHT = 500;
	private static final int FRAMEWIDTH = 500;
	private view.Camera camera;
	private final JFrame frame = new JFrame("HyphenRock");

	public ViewFrame(final IModel model) throws HeadlessException {
		this.camera = new Camera();
		this.buildViewFrame(model);

	}

	/*
	 * public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
	 * super(gc); this.buildViewFrame(model); }
	 */

	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	private IController getController() {
		return this.controller;
	}

	protected void setController(final IController controller) {
		this.controller = controller;
	}

	protected IModel getModel() {
		return this.model;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.addKeyListener(this);
		this.frame.setContentPane(new ViewPanel(this));
		this.frame.setSize(this.camera.getWIDTH() + this.getInsets().left + this.getInsets().right,
				this.camera.getHEIGHT() + this.getInsets().top + this.getInsets().bottom);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}

	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void keyTyped(final KeyEvent e) {

	}

	@Override
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		System.out.println(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	@Override
	public void keyReleased(final KeyEvent e) {

	}
}
