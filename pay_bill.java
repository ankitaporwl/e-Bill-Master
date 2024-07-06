import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import javax.swing.*;

public class pay_bill extends JFrame{

    public pay_bill() {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Paytm Electricity Bill Payment");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            JButton openPaytmButton = new JButton("Open Paytm for Electricity Bill Payment");
            openPaytmButton.addActionListener(e -> openPaytmURL());


            frame.getContentPane().add(openPaytmButton, BorderLayout.CENTER);


            frame.setSize(400, 150);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private void openPaytmURL() {
        try {

            URI uri = new URI("https://paytm.com/electricity-bill-payment");
            Desktop.getDesktop().browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to open Paytm website.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new pay_bill();
    }
}
