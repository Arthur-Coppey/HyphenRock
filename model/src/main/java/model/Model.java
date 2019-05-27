package model;

import java.util.Observable;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {
    
    /**
     * Instantiates a new model.
     */
    public Model() {
    }
    
    /**
     * Gets the observable.
     *
     * @return the observable
     */
    /*
     * (non-Javadoc)
     * @see contract.IModel#getObservable()
     */
    @Override
    public Observable getObservable() {
        return this;
    }
}
