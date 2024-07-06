import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class customer_details extends JFrame implements ActionListener{
		
	DefaultTableModel model;
    JTable table;
    JScrollPane sp;
    Timer timer;
	JButton b1;
    customer_details() {
		super("Customer Details");
		setSize(1200,650);
        setLocation(200,200);
        setLayout(new BorderLayout());
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Name");
        model.addColumn("Meter_Number");
        model.addColumn("Address");
        model.addColumn("State");
        model.addColumn("City");
        model.addColumn("Email");
        model.addColumn("Phone");

        try {
            conn c1 = new conn();

            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        ResultSet rs = c1.s.executeQuery("select * from emp");

                        while (model.getRowCount() > 0) {
                            model.removeRow(0);
                        }

                        while (rs.next()) {
                            String s1 = rs.getString("name");
                            String s2 = rs.getString("meter_number");
                            String s3 = rs.getString("address");
                            String s4 = rs.getString("state");
                            String s5 = rs.getString("city");
                            String s6 = rs.getString("email");
                            String s7 = rs.getString("phone");
                            model.addRow(new Object[]{s1, s2, s3, s4, s5, s6, s7});
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace(); 
                        JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                }
            };

            timer = new Timer(100, taskPerformer);
            timer.start();

            sp = new JScrollPane(table);
            add(sp, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    


        b1 = new JButton("Print");
        add(b1,"South");
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            table.print();
        }catch(Exception e){}
    }

    public static void main(String[] args){
        new customer_details().setVisible(true);
    }

}