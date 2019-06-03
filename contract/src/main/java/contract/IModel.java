package contract;

import java.util.Observable;

public interface IModel {
    void gameUpdate(Direction direction) throws Exception;
    
    Observable getObservable();
    
    /**
     *
     */
}
