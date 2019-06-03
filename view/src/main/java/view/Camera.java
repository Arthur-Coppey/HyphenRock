package view;

public class Camera {
    
    private static int HEIGHT = 20;
    private static int WIDTH  = 20;
    private int        x      = 0;
    private int        y      = 0;
    
    public int getHEIGHT() {
        return Camera.HEIGHT;
    }
    
    public int getWIDTH() {
        return Camera.WIDTH;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setHEIGHT(final int HEIGHT) {
        Camera.HEIGHT = HEIGHT;
    }
    
    public void setWIDTH(final int WIDTH) {
        Camera.WIDTH = WIDTH;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
    
}
