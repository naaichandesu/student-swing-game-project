package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblInfo;

    private final PlayerService playerService;

    public LoginFrame() {
        playerService = new PlayerService();
        initComponents();
    }

    private void initComponents() {
        setTitle("Tic-Tac-Toe - Login");
        setSize(380, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("Login Pemain", JLabel.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(new JLabel("Username:"), gbc);

        txtUsername = new JTextField(15);
        gbc.gridx = 1;
        panel.add(txtUsername, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(new JLabel("Password:"), gbc);

        txtPassword = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(txtPassword, gbc);

        btnLogin = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);

        lblInfo = new JLabel(" ", JLabel.CENTER);
        lblInfo.setForeground(Color.RED);
        gbc.gridy = 4;
        panel.add(lblInfo, gbc);

        add(panel);

        btnLogin.addActionListener(this::handleLoginAction);
        txtPassword.addActionListener(this::handleLoginAction);
    }

    private void handleLoginAction(ActionEvent e) {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            lblInfo.setText("Username dan password tidak boleh kosong!");
            return;
        }

        Player player = playerService.login(username, password);

        if (player != null) {
            JOptionPane.showMessageDialog(this,
                    "Login berhasil! Selamat datang, " + player.getUsername(),
                    "Login Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

            MainMenuFrame menuFrame = new MainMenuFrame(player);
            menuFrame.setVisible(true);
            this.dispose();
        } else {
            lblInfo.setText("Username atau password salah!");
            JOptionPane.showMessageDialog(this,
                    "Invalid username or password!",
                    "Login Gagal",
                    JOptionPane.ERROR_MESSAGE);
            txtPassword.setText("");
        }
    }
}
