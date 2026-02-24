import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalTime;

public class HomePage extends JFrame {

    int userId;
    JTextArea medicineArea;

    public HomePage(int userId) {

        this.userId = userId;

        setTitle("DailyDose - Home");
        setSize(500,400);
        setLocationRelativeTo(null);

        medicineArea = new JTextArea();
        medicineArea.setEditable(false);

        JButton addBtn = new JButton("Add / Edit Medicines");

        add(new JScrollPane(medicineArea), BorderLayout.CENTER);
        add(addBtn, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {
            new EditMedicinePage(userId);
            dispose();
        });

        loadMedicines();
        startReminderChecker();   

        setVisible(true);
    }

    void loadMedicines() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM medicines WHERE user_id=?"
            );

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            medicineArea.setText("");

            while(rs.next()) {
                medicineArea.append(
                    "Name: " + rs.getString("name") +
                    "\nDosage: " + rs.getString("dosage") +
                    "\nTiming: " + rs.getString("timing") +
                    "\nReminder: " + rs.getTime("reminder_time") +
                    "\n----------------------\n"
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    void startReminderChecker() {

        Timer timer = new Timer(60000, e -> {  

            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM medicines WHERE user_id=?"
                );

                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();

                LocalTime now = LocalTime.now().withSecond(0).withNano(0);

                while(rs.next()) {

                    Time dbTime = rs.getTime("reminder_time");

                    if(dbTime != null) {

                        LocalTime medicineTime = dbTime.toLocalTime();

                        if(now.equals(medicineTime)) {

                            Toolkit.getDefaultToolkit().beep();

                            JOptionPane.showMessageDialog(this,
                                "Time to take: " + rs.getString("name") +
                                "\nDosage: " + rs.getString("dosage"));
                        }
                    }
                }

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        });

        timer.start();
    }
}