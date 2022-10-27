
package quiz.application;


 import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
public class Login2 extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardnof,namef;
    JPasswordField pinf;
    JLabel namea, nameae;
   
   
    Login2(){
        setLayout(null);
        setSize(300,300);
        setVisible(true);
        setLocation(500,300);
        ImageIcon a=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image b=a.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);
        ImageIcon c=new ImageIcon(b);
        JLabel label= new JLabel(c);
        label.setBounds(700,50,200,100);
        Component add = add(label);

        namea=new JLabel("ONLINE EXAM");
        namea.setBounds(700,50,300,300);
        namea.setFont(new Font("Buffalo.",Font.BOLD,30));
        add(namea);
        
        nameae=new JLabel("NAME");
        nameae.setBounds(755,250,300,25);
        nameae.setFont(new Font("Serif",Font.BOLD,20));
        add(nameae);

        namef=new JTextField();
        namef.setBounds(640,300,310,25);
        namef.setFont(new Font("Arial",Font.BOLD,10));
        add(namef);

        JLabel cardno=new JLabel("ENTER YOUR CARD NUMBER");
        cardno.setBounds(650,350,300,30);
        cardno.setFont(new Font("Serif",Font.BOLD,20));
        add(cardno);

        cardnof=new JTextField();
        cardnof.setBounds(640,400,310,25);
        cardnof.setFont(new Font("Arial",Font.BOLD,10));
        add(cardnof);

        JLabel pin=new JLabel("ENTER YOUR PASSWORD");
        pin.setBounds(700,450,300,25);
        pin.setFont(new Font("Serif",Font.BOLD,20));
        add(pin);

        pinf=new JPasswordField();
        pinf.setBounds(640,500,310,25);
        pinf.setFont(new Font("Arial",Font.BOLD,10));
        add(pinf);

        login=new JButton("SIGN IN");
        login.setBounds(640,550,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);

        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(850,550,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);


        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(640,600,310,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);


        add(signup);


        getContentPane().setBackground(Color.WHITE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
        cardnof.setText("");
        pinf.setText("");

        }
        else if(e.getSource()==login){
           Conn conn= new Conn();
           String name=namef.getText();
           String cardnumber=cardnof.getText();
           String pinnumber=pinf.getText();
           String query ="Select * from login where Name = '"+name+"' and ID = '"+cardnumber+"' and Password ='"+pinnumber+"' ";
           try{
               ResultSet rs = conn.s.executeQuery(query);
               if (rs.next()){
                   setVisible(false);
                   new Rules(name).setVisible(true);               }
               else{
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or pin");
               }
           } catch(HeadlessException | SQLException b){
               System.out.println(b);
           }
        }
        else if(e.getSource() == signup)
        {
            setVisible(false);
          
            new signupone().setVisible(true);
        }
        
    }
    public static void main(String args[]) {
        new Login2();
        
    }
  
 
    
    
}


