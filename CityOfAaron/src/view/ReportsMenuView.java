package view;

import java.util.Scanner;
import control.ProvisionsControl;
import model.Provision;

/**
 *
 * @author chelseawaite
 */
public class ReportsMenuView extends ViewBase {

    /**
     * Constructor
     */
    public ReportsMenuView() {

    }

    @Override
    protected String getMessage() {
        return "Reports Menu\n"
                + "-------------\n"
                + "A - View the animals in the storehouse.\n"
                + "T - View the tools in the storehouse.\n"
                + "P - View the provisions in the storehouse. \n"
                + "G - View the authors of this game.\n";
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

        inputs[0] = getUserInput("What would you like to do?.");

        // Repeat for each input you need, putting it into its proper slot in the array.
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

        switch (inputs[0].trim().toUpperCase()) {
            case "A":
                animalsInStorehouse();
                break;
            case "T":
                toolsInStorehouse();
                break;
            case "P":
                provisionsInStorehouse();
                break;
            case "G":
                authorsView();
                break;
        }
        return true;
    }

    private void animalsInStorehouse() {
        System.out.println("animalsInStorehouse will be coming soon.");
    }

    private void toolsInStorehouse() {
        System.out.println("toolsInStorehouse will be coming soon.");
    }

    private void provisionsInStorehouse() {
    }

    private static class Item {

        private String description;

        public Item(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[4];
        items[0] = new Item("Water");
        items[1] = new Item("Bedding");
        items[2] = new Item("Clothes");
        items[3] = new Item("Shoes");

        for (int i = 0; i < items.length - 1; i++) {

            for (int j = i + 1; j < items.length; j++) {

                if (items[i].getDescription().compareTo(items[j].getDescription()) > 0) {
                    Item temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }

            }
        }

        for (Item item : items) {
            System.out.println(item.getDescription());
        }

    }

    private void authorsView() {
        System.out.println("authorsView will be coming soon.");
    }

}
