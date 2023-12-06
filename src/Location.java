public class Location {
    private String name;
    private String text;
    private int time;

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
