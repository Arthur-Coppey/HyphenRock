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

class ViewFrame extends JFrame implements KeyListener {

    private static final int  cellHeight       = 16;
    private static final int  cellWidth        = 16;
    private static final long serialVersionUID = -697358409737458175L;

    private final Camera camera;

    private IController     controller;
    private final JFrame    frame = new JFrame("HyphenRock");
    private final ImageIcon icon  = new ImageIcon("");

    private final JLabel image = new JLabel(this.icon);
    private IModel       model;

    public ViewFrame(final IModel model) throws HeadlessException, IOException {
        this.camera = new Camera();
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
        View.keyCodeToControllerOrder(e.getKeyCode());
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        
    }

    @Override
    public void keyTyped(final KeyEvent e) {

    }

    public void printMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    protected IModel getModel() {
        return this.model;
    }

    protected void setController(final IController controller) {
        this.controller = controller;
    }

    private void buildViewFrame(final IModel model) throws IOException {
        this.setModel(model);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.addKeyListener(this);
        this.frame.setSize(
            (this.camera.getWIDTH() * ViewFrame.cellWidth) + this.getInsets().left + this.getInsets().right,
            (this.camera.getHEIGHT() * ViewFrame.cellHeight) + this.getInsets().top + this.getInsets().bottom
        );
        this.frame.setContentPane(new ViewPanel(this));
        this.frame.setLocationRelativeTo(null);
        this.frame.add(this.image);
        this.frame.setVisible(true);

    }

    private IController getController() {
        return this.controller;
    }

    private void setModel(final IModel model) {
        this.model = model;
    }
}
