/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;


import java.awt.HeadlessException;
import java.io.IOException;


import controller.Controller;
import model.Model;
import view.View;

public abstract class Main {


    public static void main(final String[] args) throws HeadlessException, IOException {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.control();
        //controller.orderPerform(Direction.UP);
    }

}

