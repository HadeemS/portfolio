/*
 * Hadeem Secka
 */
class GameSearch {
    public static LinkedList<VideoGame> search(LinkedList<VideoGame> games, String title, String console) {
        return games.filter(game -> (title.equals("*") || game.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                                    (console.equals("*") || game.getConsole().toLowerCase().contains(console.toLowerCase())));
    }
}
