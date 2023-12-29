package com.mycompany.bismillah;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Bismillah implements ActionListener{
    
    JFrame frame;
    
    //North
    JLabel lbl_title;
    JPanel pnl_title;
    
    //Center
    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10;
    JComboBox<String> combobox;
    JTextArea txt;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
    JPanel pnl_center, pnl_inside, pnl1, pnl2, pnl3, pnl4, pnl5, pnl6, pnl7, pnl8, pnl9, pnl10;
    
    //South
    JButton btn_get, btn_update, btn_clear;
    JPanel pnl_button, pnl_south;
    
    //SQL
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    String url = "jdbc:mysql://localhost/prefaipt";
    String username = "root";
    String db_password = "";
    
    
    Bismillah(){
        
        frame = new JFrame("Car");
        frame.setLayout(new BorderLayout());
        
        //North title
        pnl_title = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lbl_title = new JLabel("Car");
        pnl_title.add(lbl_title);
        
        //Center
        pnl_center = new JPanel();
        pnl_center.setLayout(new BoxLayout(pnl_center, BoxLayout.Y_AXIS));
        
        pnl_inside = new JPanel();
        pnl_inside.setLayout(new BoxLayout(pnl_inside, BoxLayout.Y_AXIS));
        
        //Declare label
        lbl1 = new JLabel("Car Plate:");
        lbl1.setPreferredSize(new Dimension(150, 15));
        
        lbl2 = new JLabel("Car Make:");
        lbl2.setPreferredSize(new Dimension(150, 15));
        
        lbl3 = new JLabel("Car Model:");
        lbl3.setPreferredSize(new Dimension(150, 15));
        
        lbl4 = new JLabel("Current Mileage:");
        lbl4.setPreferredSize(new Dimension(150, 15));
        
        lbl5 = new JLabel("Service Date:");
        lbl5.setPreferredSize(new Dimension(150, 15));
        
        lbl6 = new JLabel("Next Service Mileage:");
        lbl6.setPreferredSize(new Dimension(150, 15));
        
        lbl7 = new JLabel("Next Service Date:");
        lbl7.setPreferredSize(new Dimension(150, 15));
        
        lbl8 = new JLabel("Customer Name:");
        lbl8.setPreferredSize(new Dimension(150, 15));
        
        lbl9 = new JLabel("Customer Contact No:");
        lbl9.setPreferredSize(new Dimension(150, 15));
        
        lbl10 = new JLabel("Remarks:");
        lbl10.setPreferredSize(new Dimension(150, 15));
        
        //All input fields
        String[] comboBoxItemSelected = {"Proton", "Toyota", "Honda", "Perodua"};
        combobox = new JComboBox<String>(comboBoxItemSelected);
        txt =  new JTextArea();
        txt.setPreferredSize(new Dimension(200,100));
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        tf4 = new JTextField(20);
        tf5 = new JTextField(20);
        tf6 = new JTextField(20);
        tf7 = new JTextField(20);
        tf8 = new JTextField(20);
        
        //Declare panel
        pnl1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        //Add to each individuals
        pnl1.add(lbl1);
        pnl1.add(tf1);
        
        pnl2.add(lbl2);
        pnl2.add(combobox);
        
        pnl3.add(lbl3);
        pnl3.add(tf2);
        
        pnl4.add(lbl4);
        pnl4.add(tf3);
        
        pnl5.add(lbl5);
        pnl5.add(tf4);
        
        pnl6.add(lbl6);
        pnl6.add(tf5);
        
        pnl7.add(lbl7);
        pnl7.add(tf6);
        
        pnl8.add(lbl8);
        pnl8.add(tf7);
        
        pnl9.add(lbl9);
        pnl9.add(tf8);
        
        pnl10.add(lbl10);
        pnl10.add(txt);
        
        //inside panel
        pnl_inside.add(pnl1);
        pnl_inside.add(pnl2);
        pnl_inside.add(pnl3);
        pnl_inside.add(pnl4);
        pnl_inside.add(pnl5);
        pnl_inside.add(pnl6);
        pnl_inside.add(pnl7);
        pnl_inside.add(pnl8);
        pnl_inside.add(pnl9);
        pnl_inside.add(pnl10);
        
        pnl_center.add(pnl_inside);
        
        // South
        pnl_button = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl_south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        btn_get = new JButton("Retrieve");
        btn_get.addActionListener(this);
        
        btn_update = new JButton("Update");
        btn_update.addActionListener(this);
        
        btn_clear = new JButton("Clear");
        btn_clear.addActionListener(this);
        
        pnl_button.add(btn_get);
        pnl_button.add(btn_update);
        pnl_button.add(btn_clear);
        
        pnl_south.add(pnl_button);
        
        //Frame 
        frame.add(pnl_title, BorderLayout.NORTH);
        frame.add(pnl_center, BorderLayout.CENTER);
        frame.add(pnl_south, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Bismillah app = new Bismillah();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_clear){
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            tf8.setText("");
            txt.setText("");
            combobox.setSelectedItem(null);
        }
        
        if(e.getSource() == btn_get){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, db_password);
                String insertQuery = "SELECT * FROM users WHERE car_plate = ?";
                
                stmt = conn.prepareStatement(insertQuery, ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                stmt.setString(1, tf1.getText());
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    rs.beforeFirst();
                    while(rs.next()){
                        
                        //Set value 
                        tf1.setText(rs.getString("car_plate"));
                        combobox.setSelectedItem(rs.getString("car_make"));
                        tf2.setText(rs.getString("car_model"));
                        tf3.setText(rs.getString("mileage"));
                        tf4.setText(rs.getString("service_date"));
                        tf5.setText(rs.getString("service_mileage"));
                        tf6.setText(rs.getString("next_service"));
                        tf7.setText(rs.getString("cust_name"));
                        tf8.setText(rs.getString("contact"));
                        txt.setText(rs.getString("remarks"));
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Data not found");
                }
            }
            catch(Exception se){
                JOptionPane.showMessageDialog(null, "Error occured"+se);
            }
        }
        
        if(e.getSource() == btn_update){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url,username, db_password);
                String updateQuery = "UPDATE users SET car_make = ?, car_model = ?, mileage = ?, service_date = ?, service_mileage = ?,"
                    + "next_service = ?, cust_name = ?, contact = ?, remarks = ? WHERE car_plate = ?";
                stmt = conn.prepareStatement(updateQuery);
                
                stmt.setString(1, combobox.getSelectedItem().toString());
                stmt.setString(2, tf2.getText());
                stmt.setString(3, tf3.getText());
                stmt.setString(4, tf4.getText());
                stmt.setString(5, tf5.getText());
                stmt.setString(6, tf6.getText());
                stmt.setString(7, tf7.getText());
                stmt.setString(8, tf8.getText());
                stmt.setString(9, txt.getText());
                stmt.setString(10, tf1.getText());
                
                
                int status = stmt.executeUpdate();
                
                if (status > 0){
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Data cannot be updated");
                }
            }
            catch(Exception ses){
                JOptionPane.showMessageDialog(null, "Error occured" + ses);
            }
        }
    }
}
