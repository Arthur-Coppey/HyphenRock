package controller;

import contract.Direction;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class Controller implements IController {
    
    private IModel model;
    
    private IView view;
    
    public Controller(final IView view, final IModel model) {
        this.setView(view);
        this.setModel(model);
    }
    
    @Override
    public void control() {
        this.view.printMessage(
            "Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix."
        );
    }
    

    @Override
    public void orderPerform(final Direction direction) {
        switch (direction) {
            default:
                break;
        }
    }
    
    /**
     * Sets the model.
     *
     * @param model
     *              the new model
     */
    private void setModel(final IModel model) {
        this.model = model;
    }
    
    /**
     * Sets the view.
     *
     * @param pview
     *              the new view
     */
    private void setView(final IView pview) {
        this.view = pview;
    }
    
}