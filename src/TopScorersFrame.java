package tictactoe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TopScorersFrame extends JFrame {

    private JTable table;
    private final PlayerService playerService;

    public TopScorersFrame() {
        playerService = new PlayerService();
        initComponents();
    }

    private void initComponents() {
        setTitle("Top 5 Scorers");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"Rank", "Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // tabel hanya untuk ditampilkan, tidak bisa diedit
            }
        };

        List<Player> topPlayers = playerService.getTopFiveScorers();

        int rank = 1;
        for (Player player : topPlayers) {
            model.addRow(new Object[]{
                    rank++,
                    player.getUsername(),
                    player.getWins(),
                    player.getLosses(),
                    player.getDraws(),
                    player.getScore()
            });
        }

        if (topPlayers.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Belum ada data pemain di database, atau koneksi database gagal.",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("SansSerif", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(scrollPane, BorderLayout.CENTER);
    }
}
