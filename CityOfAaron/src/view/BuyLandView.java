package view;

/**
 *
 * @author Jeremy
 */
public class BuyLandView extends ViewBase {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;

    /**
     * Constructor
     */
    public BuyLandView() {
        super();
    }

    @Override
    protected String getMessage() {

        return "Buy Land\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("How many acres of new land do you want to buy?", true);

        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        //Generate a random number between 17 and 27 for the price of an acre of land and display the price.
        //Ask the user "How many acres of new land do you want to buy?"
        //The user enters a value
        //Verify the entered value is positive. If not, show a message and ask the user to enter the value again.
        //Make sure the player has enough wheat to make the purchase. If not, show a message and ask the user to enter the value again.
        //Add the number of acres purchased to the acres owned
        //Subtract the wheat used to purchase the land from the wheat in storage

//        return false;
        if (inputs[0] == null || inputs[0].equals("")) {
            ErrorView.display(this.getClass().getName(), "No acres entered. Returning to the Main Menu...");
            return false;
        }
        int acreInput = 0;
        try {
            acreInput = Integer.parseInt(inputs[0]);
        } catch (NumberFormatException nfe) {
            ErrorView.display("BuyLandView", nfe.getMessage());
        }

        if (acreInput < 0) {
            ErrorView.display("BuyLandView", "Acre value must be positive. Please try again.");
            getInputs();
        }

        buyLand(acreInput);

        return false;

    }

    private boolean buyLand(int acreInput) {
        //TODO replace this message
        this.console.println("LandControl class coming soon!");
        return true;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void startBuyLandView() {
        pause(1500);
        View buyLandMenu = new BuyLandView();
        buyLandMenu.displayView();
    }
}
