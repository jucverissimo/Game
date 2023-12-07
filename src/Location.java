public class Location {
    private String name;
    private String text;
    private int time;

    // construct with no clue
    public Location(String name, int time) {
        this.name = name;
        this.time = time;
        this.text = "Welcome to the " + this.name + "! I'm sorry, but no one suspect was here and nothing suspected has happened.";
    }

    // construct with clue
    public Location(String name, String text, int time) {
        this.name = name;
        this.text = text;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getTime() {
        return this.time;
    }
}
