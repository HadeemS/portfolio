/*
 * Hadeem Secka
 */
class VideoGame {
    private String title;
    private String console;

    public VideoGame(String title, String console) {
        this.title = title;
        this.console = console;
    }

    public String getTitle() {
        return title;
    }

    public String getConsole() {
        return console;
    }

    @Override
    public String toString() {
        return title + " - " + console;
    }
}
