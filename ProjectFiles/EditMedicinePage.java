import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class EditMedicinePage extends JFrame {

    int userId;
    JTextField nameField, dosageField, timingField;

    public EditMedicinePage(int userId) {

        this.userId = userId;

        setTitle("DailyDose - Manage Medicines");
        setSize(400,350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        panel.add(new JLabel("Medicine Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Dosage:"));
        dosageField = new JTextField();
        panel.add(dosageField);

        panel.add(new JLabel("Timing:"));
        timingField = new JTextField();
        panel.add(timingField);

        JButton addBtn = new JButton("Add Medicine");
        JButton deleteBtn = new JButton("Remove Medicine");
        JButton backBtn = new JButton("Back to Home");

        panel.add(addBtn);
        panel.add(deleteBtn);
        panel.add(backBtn);

        add(panel);

        addBtn.addActionListener(e -> addMedicine());
        deleteBtn.addActionListener(e -> deleteMedicine());
        backBtn.addActionListener(e -> {
            new HomePage(userId);
            dispose();
        });

        setVisible(true);
    }

    void addMedicine() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO medicines(user_id,name,dosage,timing) VALUES(?,?,?,?)"
            );

            ps.setInt(1, userId);
            ps.setString(2, nameField.getText());
            ps.setString(3, dosageField.getText());
            ps.setString(4, timingField.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Medicine Added!");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    void deleteMedicine() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM medicines WHERE name=? AND user_id=?"
            );

            ps.setString(1, nameField.getText());
            ps.setInt(2, userId);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Medicine Removed!");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}