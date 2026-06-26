package tictactoe;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    private final Player currentPlayer;

    private JButton btnStartGame;
    private JButton btnStatistics;
    private JButton btnTopScorers;
    private JButton btnExit;

    public MainMenuFrame(Player player) {
        this.currentPlayer = player;
        initComponents();
    }

    private void initComponents() {
        setTitle("Tic-Tac-Toe - Main Menu");
        setSize(380, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel lblWelcome = new JLabel("Halo, " + currentPlayer.getUsername() + "!", JLabel.CENTER);
        lblWelcome.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Button yg ada di main menu
        btnStartGame = new JButton("Start Game");
        btnStatistics = new JButton("View My Statistics");
        btnTopScorers = new JButton("View Top 5 Scorers");
        btnExit = new JButton("Exit");

        for (JButton btn : new JButton[]{btnStartGame, btnStatistics, btnTopScorers, btnExit}) {
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(250, 35));
        }

        panel.add(lblWelcome);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnStartGame);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnStatistics);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnTopScorers);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnExit);

        add(panel);

        btnStartGame.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame(currentPlayer);
            gameFrame.setVisible(true);
            this.dispose();
        });

        btnStatistics.addActionListener(e -> {
            StatisticsFrame statisticsFrame = new StatisticsFrame(currentPlayer);
            statisticsFrame.setVisible(true);
        });

        btnTopScorers.addActionListener(e -> {
            TopScorersFrame topScorersFrame = new TopScorersFrame();
            topScorersFrame.setVisible(true);
        });

        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Apakah Anda yakin ingin keluar?",
                    "Konfirmasi Keluar",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }
}
