import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginPage extends JFrame {

    JTextField emailField;
    JPasswordField passwordField;

    public LoginPage() {

        setTitle("DailyDose - Login");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginBtn = new JButton("Login");
        JButton signupBtn = new JButton("Sign Up");

        JPanel btnPanel = new JPanel();
        btnPanel.add(loginBtn);
        btnPanel.add(signupBtn);

        add(panel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        loginBtn.addActionListener(e -> loginUser());
        signupBtn.addActionListener(e -> {
            new SignupPage();
            dispose();
        });

        setVisible(true);
    }

    void loginUser() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );

            ps.setString(1, emailField.getText());
            ps.setString(2, new String(passwordField.getPassword()));

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                new HomePage(rs.getInt("id"));
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Invalid Credentials");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}