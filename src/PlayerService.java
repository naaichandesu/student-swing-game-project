package tictactoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    /* TO DO */
    public Player login(String username, String password) {
        String sql = "SELECT id, username, wins, losses, draws, score "
                + "FROM players WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Player(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getInt("wins"),
                            rs.getInt("losses"),
                            rs.getInt("draws"),
                            rs.getInt("score")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }

    /* TO DO */
    public boolean updateStatistics(Player player, String result) {
        int additionalScore;
        String columnToIncrement;

        if (result.equalsIgnoreCase("WIN")) {
            additionalScore = 10;
            columnToIncrement = "wins";
        } else if (result.equalsIgnoreCase("DRAW")) {
            additionalScore = 3;
        columnToIncrement = "draws";
        } else if (result.equalsIgnoreCase("LOSE")) {
            additionalScore = 0;
            columnToIncrement = "losses";
        } else {
            throw new IllegalArgumentException("Result tidak dikenali: " + result);
}

        String sql = "UPDATE players SET " + columnToIncrement + " = " + columnToIncrement + " + 1, "
                + "score = score + ? WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, additionalScore);
            stmt.setInt(2, player.getId());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                switch (result.toUpperCase()) {
                    case "WIN":
                        player.setWins(player.getWins() + 1);
                        break;
                    case "DRAW":
                        player.setDraws(player.getDraws() + 1);
                        break;
                    case "LOSE":
                        player.setLosses(player.getLosses() + 1);
                        break;
                }
                player.setScore(player.getScore() + additionalScore);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Update statistics error: " + e.getMessage());
        }
        return false;
    }


    public List<Player> getTopFiveScorers() {
        List<Player> results = new ArrayList<>();
        String sql = "SELECT id, username, wins, losses, draws, score "
                + "FROM players ORDER BY score DESC, wins DESC LIMIT 5";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                results.add(new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                ));
            }
        } catch (Exception e) {
            System.out.println("Get top scorers error: " + e.getMessage());
        }
        return results;
    }
}
