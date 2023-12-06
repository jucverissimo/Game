import javax.swing.*;
import java.util.ArrayList;

public class GameSetup {

    public ArrayList<Suspect> createSuspectSetup() {
        ArrayList<Suspect> suspects = new ArrayList<>();
        Suspect carmenSandiego = new Suspect("Carmen Sandiego", "Dark hair, dark eyes, always have red lip stick on, likes dogs.");
        Suspect dazzleAnnie = new Suspect("Dazzle Annie", "Dark hair, green eyes, has a tattoo in one of the arms, likes pets.");
        Suspect earthaBrute = new Suspect("Eartha Brute", "Dark hair, green eyes, has a scar in one of the arms, loves big cats.");
        Suspect jacquelineHyde = new Suspect("Jacqueline Hyde", "Blond, dark eyes, has a tatto in her neck, loves big cats.");

        suspects.add(carmenSandiego);
        suspects.add(dazzleAnnie);
        suspects.add(earthaBrute);
        suspects.add(jacquelineHyde);

        return suspects;
    }

    public Country createStartSetup() {
        // --------- create countries and locations you can visit per country
        Location bank = new Location("Bank", "Welcome to the bank! I'm sorry, but no one suspect was here and nothing suspected has happened.", 60);
        Location cityHall = new Location("City Hall", "Welcome to the City Hall! I'm sorry, but no one suspect was here and nothing suspected has happened.", 50);

        Country england = new Country("England", 700);
        england.addLocation(new Location("Museum", "Welcome to the Museum! One of the employees has reported to seen the suspected. They say it is a white woman with green eyes.", 40));
        england.addLocation(new Location("Library", "Welcome to the Library! A suspicious woman was here, and she asked for books about spiders.", 60));

        Country australia = new Country("Australia", 800);
        australia.addLocation(new Location("Gym", "Welcome to the Gym! A woman matching the descriptions was here and she asked about capoeira classes. She had something in her right arm, I couldn't see if it was a scar or a tattoo.", 20));
        australia.addLocation(new Location("Exchange", "Welcome to the Exchange! A suspicious woman was here. She wanted to exchange money for reais. She had nice green eyes.", 40));

        Country brazil = new Country("Brazil", 600);
        brazil.addLocation(new Location("Zoo", "Welcome to the Zoo!  A suspicious woman was here, she was very interested in the Pandas. She mentioned that her favorite animal was a tiger.", 30));
        brazil.addLocation(new Location("Culinary School", "Welcome to the Culinary School! A suspicious woman was here, she has dark hair and was asking about how to ask Kung Pao Chicken. Airport", 60));

        Country china = new Country("China",300);
        china.addLocation(new Location("Botanic Garden", "Welcome to the Botanic Garden! A suspicious woman was here asking about how to care for Maple trees.", 20));
        china.addLocation(new Location("Hunting Club", "Welcome to the Hunting Club! A suspicious woman was asking about the best time to hunt Moosey.", 40));

        Country canada = new Country("Canada",400);
        canada.addLocation(new Location("Liquor Store", "Welcome to the Liquor Store! A suspicious woman was here and she mentioned that she loves Tequila.", 10));
        canada.addLocation(new Location("Food Truck", "Welcome to the Food Truck. A suspicious woman was here and she mentioned that she loves tacos.", 40));

        Country mexico = new Country("Mexico",300);
        mexico.addLocation(new Location("Language School", "Welcome to the Language School! A suspicious woman was here and she wnated to learn a Latin language, I believe it was Portuguese.", 50));
        mexico.addLocation(new Location("Sommelier School", "Welcome to the Sommelier School! A suspicious woman was here, and she wanted information about green wine.", 30));

        Country portugal = new Country("Portugal",300);
        portugal.addLocation(new Location("Travel Agency", "Welcome to the Travel Agency! A suspicious woman was here. She wanted information about best times to see Aurora Borealis. She mentioned that she liked spicy food.", 60));
        portugal.addLocation(new Location("Sport Club", "Welcome to the Sport Club! A suspicious woman was here and she wanted to learn how to skii.", 20));

        Country norway = new Country("Norway",200);
        norway.addLocation(new Location("Ice Bar", "Welcome to the Ice Bar! A suspicious woman was here, she had distinct red lips",40));
        norway.addLocation(new Location("Interpol", "Welcome back! The Suspect was seeing nearby. Can you name which one of Carmen Sandiego's gang members has the stolen crown?", 10));

        Country netherlands = new Country("Netherlands",800);
        netherlands.addLocation(bank);
        netherlands.addLocation(cityHall);

        Country usa = new Country("USA",400);
        usa.addLocation(bank);
        usa.addLocation(cityHall);

        Country germany = new Country("Germany",700);
        germany.addLocation(bank);
        germany.addLocation(cityHall);

        Country japan = new Country("Japan",600);
        japan.addLocation(bank);
        japan.addLocation(cityHall);

        Country suriname = new Country("Suriname",300);
        suriname.addLocation(bank);
        suriname.addLocation(cityHall);

        Country belgium = new Country("Belgium",400);
        belgium.addLocation(bank);
        belgium.addLocation(cityHall);

        Country spain = new Country("Spain",600);
        spain.addLocation(bank);
        spain.addLocation(cityHall);

        Country tunisia = new Country("Tunisia",700);
        tunisia.addLocation(bank);
        tunisia.addLocation(cityHall);

        england.addDestination(usa);
        england.addDestination(netherlands);
        england.addDestination(australia);

        australia.addDestination(brazil);
        australia.addDestination(england);
        australia.addDestination(germany);

        brazil.addDestination(australia);
        brazil.addDestination(china);
        brazil.addDestination(japan);

        china.addDestination(suriname);
        china.addDestination(brazil);
        china.addDestination(canada);

        canada.addDestination(china);
        canada.addDestination(belgium);
        canada.addDestination(mexico);

        mexico.addDestination(portugal);
        mexico.addDestination(spain);
        mexico.addDestination(canada);

        portugal.addDestination(tunisia);
        portugal.addDestination(norway);
        portugal.addDestination(mexico);

        netherlands.addDestination(england);
        netherlands.addDestination(germany);
        netherlands.addDestination(australia);

        germany.addDestination(england);
        germany.addDestination(usa);
        germany.addDestination(netherlands);

        japan.addDestination(england);
        japan.addDestination(usa);
        japan.addDestination(netherlands);

        suriname.addDestination(japan);
        suriname.addDestination(china);
        suriname.addDestination(brazil);

        belgium.addDestination(canada);
        belgium.addDestination(suriname);
        belgium.addDestination(china);

        spain.addDestination(mexico);
        spain.addDestination(belgium);
        spain.addDestination(suriname);

        tunisia.addDestination(mexico);
        tunisia.addDestination(spain);
        tunisia.addDestination(portugal);

        norway.addDestination(england);
        norway.addDestination(canada);
        norway.addDestination(portugal);

        usa.addDestination(germany);
        usa.addDestination(england);
        usa.addDestination(australia);

        // return country to start at
        return england;
    }

    public void printSuspects() {
        ArrayList<Suspect> suspects = createSuspectSetup();
        StringBuilder suspectsInfo = new StringBuilder();

        for (int i = 0; i < suspects.size(); i++) {
            Suspect suspect = suspects.get(i);
            String name = suspect.getName();
            String hint = suspect.getHint();
            suspectsInfo.append(i + 1).append(" ").append(name).append(": ").append(hint).append("\n");
        }

        JOptionPane.showMessageDialog(null, suspectsInfo.toString());
    }
}
