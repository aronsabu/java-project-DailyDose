import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SignupPage extends JFrame {

    JTextField nameField, emailField;
    JPasswordField passwordField;

    public SignupPage() {

        setTitle("DailyDose - Sign Up");
        setSize(400,350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton registerBtn = new JButton("Register");
        panel.add(registerBtn);

        JButton backBtn = new JButton("Back to Login");
        panel.add(backBtn);

        add(panel);

        registerBtn.addActionListener(e -> registerUser());
        backBtn.addActionListener(e -> {
            new LoginPage();
            dispose();
        });

        setVisible(true);
    }

    void registerUser() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,email,password) VALUES(?,?,?)"
            );

            ps.setString(1, nameField.getText());
            ps.setString(2, emailField.getText());
            ps.setString(3, new String(passwordField.getPassword()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"User Registered!");
            new LoginPage();
            dispose();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}