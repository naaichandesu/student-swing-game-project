package tictactoe;

import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {
        initComponents(player);
    }

    private void initComponents(Player player) {
        setTitle("My Statistics - " + player.getUsername());
        setSize(320, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        JLabel lblHeader = new JLabel("Player Statistics", JLabel.CENTER);
        lblHeader.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel lblUsername = new JLabel("Username : " + player.getUsername());
        JLabel lblWins = new JLabel("Wins     : " + player.getWins());
        JLabel lblLosses = new JLabel("Losses   : " + player.getLosses());
        JLabel lblDraws = new JLabel("Draws    : " + player.getDraws());
        JLabel lblScore = new JLabel("Total Score : " + player.getScore());
        lblScore.setFont(new Font("SansSerif", Font.BOLD, 14));

        panel.add(lblHeader);
        panel.add(lblUsername);
        panel.add(lblWins);
        panel.add(lblLosses);
        panel.add(lblDraws);
        panel.add(lblScore);

        add(panel);
    }
}
