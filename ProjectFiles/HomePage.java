import javax.swing.*;
import java.awt.*;
import java.sql.*;

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
                    "\n----------------------\n"
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
