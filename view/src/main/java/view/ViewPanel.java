package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class ViewPanel extends JPanel implements Observer {
    

    private static final long serialVersionUID = -998294702363713521L;
 
    private ViewFrame         viewFrame;
    private Camera	      camera;
    
    private final File groundImageFile = new File("C:\\ground.png");
  	private final File wallImageFile = new File("C:\\wall.png");
  	private int cellWidth = 32;
  	private int cellHeight = 32;
  	private final BufferedImage img;
  	private final BufferedImage groundImage;
  	private final BufferedImage wallImage;
    
    public ViewPanel(final ViewFrame viewFrame) throws IOException {
        this.setViewFrame(viewFrame);
        viewFrame.getModel().getObservable().addObserver(this);
        this.camera = new Camera();
        this.img = new BufferedImage(this.camera.getWIDTH() * cellWidth, this.camera.getHEIGHT() * cellHeight, BufferedImage.TYPE_INT_ARGB);
		this.groundImage = ImageIO.read(groundImageFile);
		this.wallImage = ImageIO.read(wallImageFile);
    }
    
    @Override
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }
    
    @Override
    protected void paintComponent(final Graphics graphics) {
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
//        graphics.drawString("aze", 10, 10);
        backgroundMapMaking(this.groundImage, this.wallImage, graphics);
    }
    
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }
    
    private void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }
    
    
    public void backgroundMapMaking(BufferedImage groundImage, BufferedImage wallImage, Graphics graphics) {
		for(int xCell = 0; xCell <= this.camera.getWIDTH(); xCell++ ) {
			for(int yCell = 0; yCell <= this.camera.getHEIGHT(); yCell++) {
				if(xCell == 0 || xCell == this.camera.getHEIGHT()-1 || yCell == 0 || yCell == this.camera.getWIDTH()-1) {
					graphics.drawImage(wallImage, xCell*cellWidth, yCell*cellHeight, this);
				} else {
					graphics.drawImage(groundImage, xCell*cellWidth, yCell*cellHeight, this);
				}
			}
			
		}
		graphics.drawImage(wallImage, 5*cellWidth/2, 5*cellHeight/2, this);
	}
}
