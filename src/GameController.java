import javax.swing.JOptionPane;
import java.util.Scanner;
class GameController {
    private Scanner scanner = new Scanner(System.in);
    private GameSetup gameSetup = new GameSetup();

    int time = 4320;

    void startGame() {
        Country startingPoint = gameSetup.createStartSetup();
        goToDestination(startingPoint);
    }

    void interpolIntro() {
        String firstName = JOptionPane.showInputDialog("Dear agent, enter your credentials.\nEnter your first name: ");
        String lastName = JOptionPane.showInputDialog("Enter your last name: ");
        JOptionPane.showMessageDialog(null, "Welcome to Interpol, " + firstName + " " + lastName + ". Your new mission has been assigned.\n" +
                "Someone in Carmen Sandiego's gang has stolen the Queen's crown from the London Museum.\n" +
                "Your mission is to find which member of the gang has stolen the crown and recover it.\n" +
                "You have 3 days to complete your mission.\n\n" +
                "Have a safe flight to London.\n\n" +
                "Welcome to London!");
    }

    void interpolEndGame() {

        JOptionPane.showMessageDialog(null, "Welcome to the Interpol! You still need to arrest the correct suspect.");

        gameSetup.printSuspects();

        int suspectSelection = Integer.parseInt(JOptionPane.showInputDialog("Please enter the correct suspect number."));

        if (suspectSelection == 3) { // user wins the game
            JOptionPane.showMessageDialog(null, "Congratulations! You've successfully identified the suspect and recovered the crown.");
        } else { // user selected the wrong suspect
            JOptionPane.showMessageDialog(null, "Mission failed! You arrested the wrong suspect, and Carmen Sandiego's gang run away with the crown.");
        }

        System.exit(0); // exit the app
    }

    public void goToDestination(Country country) {
        if (this.time >= 0) {
            int locationSelection = Integer.parseInt(JOptionPane.showInputDialog("Where would you like to visit next? You have " + this.time + " min left.\n" +
                    country.getLocationString()));

            if (locationSelection == 1) { // user selected airport
                int destinationSelection = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the airport! Where would you like to go? You have " + this.time + " min left.\n" +
                        country.getDestinationString()));

                Country nextDestination = country.getDestination(destinationSelection);
                this.time -= nextDestination.getTime();
                goToDestination(nextDestination);


            } else { // user selected other location
                Location location = country.getLocation(locationSelection);

                if (location.getName().equals("Interpol")) {
                    interpolEndGame();
                }

                JOptionPane.showMessageDialog(null, location.getText());
                this.time -= location.getTime();
                goToDestination(country);

            }
        } else {
            JOptionPane.showMessageDialog(null, "\"Mission failed! You run out of time and Carmen Sandiego's gang has run away with the crown.");
            System.exit(0); // exit the app
        }
    }
}