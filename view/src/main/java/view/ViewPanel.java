package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class ViewPanel extends JPanel implements Observer {
    
    private static final long serialVersionUID = -998294702363713521L;
    
    private final Camera camera;
    private final Font   font;
    
    private final BufferedImage groundImage;
    private final File          groundImageFile = new File("C:\\ground.png");
    private ViewFrame           viewFrame;
    
    public ViewPanel(final ViewFrame viewFrame) throws IOException {
        this.setViewFrame(viewFrame);
        viewFrame.getModel().getObservable().addObserver(this);
        this.font   = new Font("Helvetica", Font.BOLD, 40);
        this.camera = new Camera();
        new BufferedImage(
            this.camera.getWIDTH() * ViewFrame.getCellwidth(), this.camera.getHEIGHT() * ViewFrame.getCellheight(),
            BufferedImage.TYPE_INT_ARGB
        );
        this.groundImage = ImageIO.read(this.groundImageFile);
    }
    
    public void backgroundMapMaking(final Graphics graphics) {
        for (int xCell = 0; xCell <= this.camera.getWIDTH(); xCell++ ) {
            for (int yCell = 0; yCell <= this.camera.getHEIGHT(); yCell++ ) {
                graphics.drawImage(this.groundImage, xCell * ViewFrame.getCellwidth(), yCell * ViewFrame.getCellheight(), this);
                
            }
            
        }
    }
    
    @Override
    public void update(final Observable arg0, final Object arg1) {
        this.viewFrame.getModel().getMap();
        this.repaint();
    }
    
    @Override
    protected void paintComponent(final Graphics graphics) {
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        graphics.setFont(this.font);
        graphics.setColor(Color.white);
        // graphics.drawString(this.score.getPlayerName() + " : " +
        // this.score.getPlayerScore(), this.camera.getWIDTH() - 1, 0);
        this.backgroundMapMaking(graphics);
    }
    
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }
    
    private void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }
}
