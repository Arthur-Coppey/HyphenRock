package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

class ViewPanel extends JPanel implements Observer {
    

    private static final long serialVersionUID = -998294702363713521L;
 
    private ViewFrame         viewFrame;
    private view.Camera	      camera;
    
    public ViewPanel(final ViewFrame viewFrame) {
        this.setViewFrame(viewFrame);
        viewFrame.getModel().getObservable().addObserver(this);
    }
    
    @Override
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }
    
    @Override
    protected void paintComponent(final Graphics graphics) {
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        graphics.drawString("a string", 10, 20);
    }
    
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }
    
    private void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }
}

