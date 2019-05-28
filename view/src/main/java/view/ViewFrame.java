package view;


import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;

class ViewFrame extends JFrame  implements KeyListener {

	private IModel model;
	private ImageIcon icon = new ImageIcon("");
	private JLabel image = new JLabel(icon);
	
	private IController controller;
	
	private static final long serialVersionUID = -697358409737458175L;
	//private static final int FRAMEHEIGHT = 500;
	//private static final int FRAMEWIDTH = 500;
	private Camera camera;
	private JFrame frame = new JFrame("HyphenRock");
	
	//private final File groundImageFile = new File("C:\\ground.png");
	//private final File wallImageFile = new File("C:\\wall.png");
	private int cellWidth = 32;
	private int cellHeight = 32;
	//private final BufferedImage img;
	//private final BufferedImage groundImage;
	//private final BufferedImage wallImage;
	//private final Graphics g;
	
	public ViewFrame(final IModel model) throws HeadlessException, IOException {
		this.camera = new Camera();
		//this.img = new BufferedImage(this.camera.getWIDTH() * cellWidth, this.camera.getHEIGHT() * cellHeight, BufferedImage.TYPE_INT_ARGB);
		//this.g= img.getGraphics();
		this.buildViewFrame(model);
		//this.groundImage = ImageIO.read(groundImageFile);
		//this.wallImage = ImageIO.read(wallImageFile);
		//this.backgroundMapMaking(this.groundImage, this.wallImage);
		

	}

//	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
//		super(gc);
//		this.buildViewFrame(model);
//		groundImage = ImageIO.read(groundImageFile);
//	}
//
//	public ViewFrame(final IModel model, final String title) throws HeadlessException {
//		super(title);
//		this.buildViewFrame(model);
//		groundImage = ImageIO.read(groundImageFile);
//	}
//
//	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
//		super(title, gc);
//		this.buildViewFrame(model);
//		groundImage = ImageIO.read(groundImageFile);
//	}

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

	private void buildViewFrame(final IModel model) throws IOException {
		this.setModel(model);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.addKeyListener(this);
		this.frame.setSize(this.camera.getWIDTH()*cellWidth + this.getInsets().left + this.getInsets().right,
		this.camera.getHEIGHT()*cellHeight + this.getInsets().top + this.getInsets().bottom);
		this.frame.setContentPane(new ViewPanel(this));
		this.frame.setLocationRelativeTo(null);
		this.frame.add(image);
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
		View.keyCodeToControllerOrder(e.getKeyCode());
	}

	@Override
	public void keyReleased(final KeyEvent e) {

	}
}
