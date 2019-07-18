package classwork;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Registration extends JFrame implements ActionListener {
    JLabel fname, lname,username, dob, email, pass, cpass;
    JTextField tuser, tfname, tlname, tdob, temail;
    JPasswordField ppass, pcpass;
    JButton submit;
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
            
       }
    }

}
