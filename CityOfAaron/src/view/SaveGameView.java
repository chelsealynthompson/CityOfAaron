package view;

import cityofaaron.CityOfAaron;
import control.GameControl;
import model.Game;
import Exceptions.GameControlException;

/**
 *
 * @author DIDIM
 */
public class SaveGameView extends ViewBase {

    protected String message;

    /**
     * Constructor
     *
     * The program will prompt the user for where the file should be saved if
     * the game state is saved to a file, the computer will display a success-
     * not working yet- will stub if the game state is not saved the program
     * will throw and error Then the computer will return to the main menu
     *
     */
    @Override
    protected String getMessage() {
        return "Thank you for playing the game, let's save your game!";

    }

    /**
     * The program will prompt the user for where the file should be saved if
     * the game state is saved to a file, the computer will display a success-
     * not working yet- will stub if the game state is not saved the program
     * will throw and error
     *
     * @return
     */
    @Override
    protected String[] getInputs() {
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please enter the name of your file where you would like to save your game\n");

        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        // If the user hits enter go back to main menu by returning false
        if (inputs[0] == null || inputs[0].equals("")) {
            this.console.println("You did not enter a valid file name. Returning to the Main menu. . . ");
            return false;
        }
        // return false because the function is not built yet.
        String fileName = inputs[0];
        // add a call to the file save method//which will be created soon
        Game game = CityOfAaron.getCurrentGame();
        try {
            GameControl.saveGameToFile(game, fileName);
        }
        catch (GameControlException gce){
            ErrorView.display(this.getClass().getName(), "No file path provided" + gce.getMessage());
        }
        //return false so we do not keep looping
        return false;
    }

}
