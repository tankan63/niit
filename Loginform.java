
package classwork;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Loginform extends JFrame implements ActionListener {
//    JPanel panel;
    JLabel user, pass;
    JTextField usertext;
    JPasswordField passtext;
    JButton enter, signup;

    public Loginform() {
//        panel = new JPanel();
//        panel.setSize(1400, 900);
       
        user = new JLabel("USERNAME: ");
        user.setBounds(500,200,100,20);
//        user.setBackground(Color.ORANGE);
//        user.setFont(new Font("Serif", Font.PLAIN, 20));
        
        usertext = new JTextField();
        usertext.setBounds(600,200,100,20);
        
        pass = new JLabel("PASSWORD: ");
        pass.setBounds(500,240,100,20);
//        user.setBackground(Color.ORANGE);
//        user.setFont(new Font("Serif", Font.PLAIN, 20));
        
        passtext = new JPasswordField();
        passtext.setBounds(600,240,100,20);
        
        enter = new JButton("ENTER");
//        enter.setFont(new Font("Serif",Font.PLAIN , 20));
        enter.setBounds(500,280,80,20);
        
        signup = new JButton("SIGNUP");
        signup.setBounds(600, 280, 80, 20);
               
         add(user); add(pass); add(usertext); add(passtext); add(enter); add(signup);
         enter.addActionListener(this);
         signup.addActionListener(this);
        setTitle("LOGIN PAGE");
        setSize(1400,900);
        
        setLayout(null);
        setVisible(true);
        setResizable(true);
             setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==enter) {
            if(usertext.getText().equalsIgnoreCase("root") && passtext.getText().equalsIgnoreCase("root"))
                JOptionPane.showMessageDialog(this, "Login confirmed!");
            else 
                JOptionPane.showMessageDialog(this, "Login Failed.");
        }
        else if(e.getSource()==signup) {
            new Registration();
        }
    }
    public static void main(String[] args) throws IOException
    {
      Loginform t=new Loginform();
    }        
    }