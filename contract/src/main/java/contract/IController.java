package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {
    
    /**
     * Control.
     */
    public void control();
    
    /**
     * Order perform.
     *
     * @param direction
     *                  the direction given
     */
    public void orderPerform(Direction direction);
}
