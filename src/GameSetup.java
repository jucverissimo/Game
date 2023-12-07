import javax.swing.*;
import java.io.*;
import java.util.*;

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
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Story1.csv"))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Map<String, Country> countries = new HashMap<>();
        for (List<String> row : records) {
            // parsing countries
            if (row.get(0).equals("1")) {
                String rowCounry = row.get(1);
                if (countries.get(rowCounry) != null) {
                    Location l = new Location(row.get(1), row.get(2));
                    Country c = countries.get(rowCounry);
                    c.addLocation(l);
                } else {
                    Country c = new Country(rowCounry, row.get(2));
                    countries.put(rowCounry, c);
                }
            }
        }

        for (List<String> row : records) {
            // parsing countries
            if (row.get(0).equals("0")) {
                String rowCounry = row.get(1);
                if (countries.get(rowCounry) != null) {
                    Country c = countries.get(rowCounry);
                    String desCounry = row.get(2);
                    c.addDestination(countries.get(desCounry));
                }
            }
        }


        Location bank = new Location("Bank", 60);
        Location cityHall = new Location("City Hall",50);

        Country england = new Country("England",700);
        england.addLocation(new Location("Museum",40));
        england.addLocation(new Location("Library",60));

        Country australia = new Country("Australia", 800);
        australia.addLocation(new Location("Gym", 20));
        australia.addLocation(new Location("Exchange", 40));

        Country brazil = new Country("Brazil", 600);
        brazil.addLocation(new Location("Zoo", 30));
        brazil.addLocation(new Location("Culinary School", 60));

        Country china = new Country("China",300);
        china.addLocation(new Location("Botanic Garden", 20));
        china.addLocation(new Location("Hunting Club", 40));

        Country canada = new Country("Canada",400);
        canada.addLocation(new Location("Liquor Store", 10));
        canada.addLocation(new Location("Food Truck", 40));

        Country mexico = new Country("Mexico",300);
        mexico.addLocation(new Location("Language School", 50));
        mexico.addLocation(new Location("Sommelier School", 30));

        Country portugal = new Country("Portugal",300);
        portugal.addLocation(new Location("Travel Agency", 60));
        portugal.addLocation(new Location("Sport Club", 20));

        Country norway = new Country("Norway",200);
        norway.addLocation(new Location("Ice Bar",40));
        norway.addLocation(new Location("Interpol", 10));

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

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
