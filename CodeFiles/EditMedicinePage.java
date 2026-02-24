import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class EditMedicinePage extends JFrame {

    int userId;
    JTextField nameField, dosageField, timingField, timeField;

    public EditMedicinePage(int userId) {

        this.userId = userId;

        setTitle("DailyDose - Manage Medicines");
        setSize(550,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        panel.add(new JLabel("Medicine Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Dosage:"));
        dosageField = new JTextField();
        panel.add(dosageField);

        panel.add(new JLabel("Timing (Morning/Afternoon/Night):"));
        timingField = new JTextField();
        panel.add(timingField);

        panel.add(new JLabel("Reminder Time (HH:MM - 24hr format):"));
        timeField = new JTextField();
        panel.add(timeField);

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
                "INSERT INTO medicines(user_id,name,dosage,timing,reminder_time) VALUES(?,?,?,?,?)"
            );

            ps.setInt(1, userId);
            ps.setString(2, nameField.getText());
            ps.setString(3, dosageField.getText());
            ps.setString(4, timingField.getText());

            // Convert HH:MM to HH:MM:SS
            ps.setTime(5, Time.valueOf(timeField.getText() + ":00"));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Medicine Added!");

        } catch(Exception e) {
            JOptionPane.showMessageDialog(this,"Invalid Time Format! Use HH:MM");
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