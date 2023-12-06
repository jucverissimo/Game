import java.util.ArrayList;

public class Country {

    private String name;
    private int time;
    private ArrayList<Location> locations = new ArrayList<>();
    private ArrayList<Country> destinations = new ArrayList<>();

    public Country(String name, int time) {
        this.name = name;
        this.time = time;
        addLocation(new Location("Airport", "From the airport you can visit the following destinations:", 0));
    }

    public void addLocation(Location location){
        this.locations.add(location);
    }

    public void addDestination(Country destination) {
        this.destinations.add(destination);
    }

    public String getName(){
        return this.name;
    }

    public int getTime(){
        return this.time;
    }

    public Location getLocation(int locationSelection) {
        return locations.get(locationSelection - 1);
    }

    public Country getDestination(int destinationSelection) {
        return destinations.get(destinationSelection - 1);
    }

    public String getLocationString() {
        StringBuilder locationString = new StringBuilder();
        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            locationString.append(i + 1).append(". ").append(location.getName()).append("\n");
        }
        return locationString.toString();
    }

    public String getDestinationString() {
        StringBuilder destinationString = new StringBuilder();
        for (int i = 0; i < destinations.size(); i++) {
            Country destination = destinations.get(i);
            destinationString.append(i + 1).append(". ").append(destination.getName()).append("\n");
        }
        return destinationString.toString();
    }

    public boolean hasNoDestination() {
        return this.destinations.size() == 0;
    }
}
