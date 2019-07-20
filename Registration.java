package classwork;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.regex.*;

public class Registration extends JFrame implements ActionListener {
    JLabel fname, lname,username, dob, email, pass, cpass;
    JTextField tuser, tfname, tlname, tdob, temail;
    JPasswordField ppass, pcpass;
    JButton submit;
    String dbUser, dbPass, dbUrl;
    Pattern dobPattern = Pattern.compile("[/d]{2}[[/.][/]]{1}[/d]{2}[[/.][/]]{1}[/d]{2}");
    Pattern emailPattern = Pattern.compile("[.+]@[/w+][/.][/w]{2,4}");
    
    public Registration() {
        username =  new JLabel("Username: ");
        username.setBounds(20, 20, 100, 20);
                
        pass = new JLabel("Password: ");
        pass.setBounds(20, 50, 100, 20);
        
        cpass = new JLabel("Confirm Password: ");
        cpass.setBounds(20, 80, 100, 20);
        
        fname = new JLabel("First Name: ");
        fname.setBounds(20, 110, 100, 20);
        
        lname = new JLabel("Last name: ");
        lname.setBounds(20, 140, 100, 20);
        
        dob = new JLabel("Date of Birth: ");
        dob.setBounds(20, 170, 100, 20);
        
        email = new JLabel("E-Mail ID: ");
        email.setBounds(20, 200, 100, 20);
        
//        fname = new JLabel("First name: ");
//        fname.setBounds(20, 170, 100, 20);
        
        tuser = new JTextField();
        tuser.setBounds(130, 20, 100, 20);
        
        ppass = new JPasswordField();
        ppass.setBounds(130, 50, 100, 20);
        
        pcpass = new JPasswordField();
        pcpass.setBounds(130, 80, 100, 20);
        
        tfname = new JTextField();
        tfname.setBounds(130, 110, 100, 20);
        
        tlname = new JTextField();
        tlname.setBounds(130, 140, 100, 20);
        
        tdob = new JTextField();
        tdob.setBounds(130, 170, 100, 20);
        
        temail = new JTextField();
        temail.setBounds(130, 200, 100, 20);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(20, 230, 80, 20);
        
        add(username);
        add(fname);
        add(lname);
        add(dob);
        add(email);
        add(pass);
        add(cpass);
        add(tuser);
        add(tfname);
        add(tlname);
        add(tdob);
        add(temail);
        add(ppass);
        add(pcpass);
        add(submit);
        submit.addActionListener(this);
        
        setTitle("REGISTRATION PAGE");
        setSize(500,500);
        setLayout(null);
        setResizable(true);
       
        setVisible(true);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==submit) {
          Matcher dobMatch = dobPattern.matcher(tdob.getText());
          Matcher emailMatch = emailPattern.matcher(temail.getText());
          if(!dobMatch.matches()) {
            JOptionPane.showMessageDialog(this, "Error. Your Date of Birth is in a wrong format!");
            new Registration();
          }
          else if (!emailMatch.matches()) {
            JOptionPane.showMessageDialog(this, "Error. Your E-Mail is in a wrong format/ or is Invalid!");
            new Registration();
          }
           try{
//            String dbUser, dbPass, dbUrl;
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            Statement state = con.createStatement();
            String query = "INSERT INTO USERS VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, tuser.getText());
            ps.setString(2, ppass.getText());
            ps.setString(3, pcpass.getText());
            ps.setString(4, tfname.getText());
            ps.setString(5, tlname.getText());
            ps.setString(6, tdob.getText());
            ps.setString(7, temail.getText());
            ResultSet rs = ps.executeQuery();
           }
           catch (SQLException sqlerr) {
               System.out.println("Sorry, there seems to have been an error somewhere. Take a look: ");
               System.out.print(" ");
               sqlerr.getErrorCode();
           }
           finally{
               JOptionPane.showMessageDialog(this, "Done. Please close the window to exit.");
               System.exit(0);
           }
       }
    }

}
