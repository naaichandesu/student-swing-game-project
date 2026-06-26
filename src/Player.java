package tictactoe;

public class Player {

    private final int id;
    private final String username;
    private int wins;
    private int losses;
    private int draws;
    private int score;

    public Player(int id, String username, int wins, int losses, int draws, int score) {
        this.id = id;
        this.username = username;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getScore() {
        return score;
    }

    /* Setter supaya setelah statistik update, gak perlu query ulang*/
    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return username + " (Score: " + score + ")";
    }
}
