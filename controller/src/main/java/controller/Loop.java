package controller;

import contract.Direction;
import contract.IModel;

public class Loop extends java.util.TimerTask {

    private Direction directionOrder = null;
    private IModel    model;
    
    public Loop(final IModel Model) {
        this.setModel(Model);
    }
    
    public Direction getDirectionOrder() {
        return this.directionOrder;
    }
    
    public IModel getModel() {
        return this.model;
    }
    
    @Override
    public void run() {
        try {
            this.model.gameUpdate(this.directionOrder);
        }
        catch (final Exception error) {
            // TODO Auto-generated catch block
            error.printStackTrace();
        }
        this.setDirectionOrder(null);
        System.out.println("aze");
        
    }
    
    public void setDirectionOrder(final Direction order) {
        this.directionOrder = order;
    }
    
    public void setModel(final IModel model) {
        this.model = model;
    }
    
}
