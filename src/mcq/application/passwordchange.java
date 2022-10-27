
package quiz.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class passwordchange extends JFrame implements ActionListener {
     JTextField  pin, repin;
      JButton change,back ;
      String name;
     
    passwordchange(String name){
        this.name=name;
          setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon a=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image b=a.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        ImageIcon c=new ImageIcon(b);
        JLabel label= new JLabel(c);
        label.setBounds(680,20,100,50);
        Component add = add(label);
    
        JLabel text=new JLabel("Change your Password ");
         text.setFont(new Font("Arial",Font.BOLD,30));
        text.setBounds(500,80,600,50);
        add(text);
        
         JLabel pintext=new JLabel("NEW PASSWORD :");
         pintext.setFont(new Font("Arial",Font.BOLD,30));
        pintext.setBounds(500,200,600,50);
        add(pintext);
        
         pin=new JTextField();
         pin.setFont(new Font("Arial",Font.BOLD,30));
        pin.setBounds(500,300,600,50);
        add(pin);
        
        JLabel repintext=new JLabel("Re-Enter NEW PASSWORD :");
         repintext.setFont(new Font("Arial",Font.BOLD,30));
        repintext.setBounds(500,400,600,50);
        add(repintext);
        
        repin=new JTextField();
        repin.setFont(new Font("Arial",Font.BOLD,30));
        repin.setBounds(500,500,600,50);
        add(repin);
        
       change =new JButton("CHANGE");
        change.setBounds(800, 600, 200, 50);
        change.setFont(new Font("Arial",Font.BOLD,30));
        change.setBackground(Color.BLACK);
       change.setForeground(Color.white);
       change.addActionListener(this);
        add(change);
       
        back =new JButton("BACK");
        back.setBounds(500, 600, 200, 50);
       
         back.setFont(new Font("Arial",Font.BOLD,30));
         back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
           
     setLayout(null);
       setSize(300,300);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
       setLocation(300,300);
      
       setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
  {
      
      if(e.getSource()== change){
 
     try{
         String npin=pin.getText();
         String rpin=repin.getText();
         
         if(!npin.equals(rpin))
         {
             JOptionPane.showMessageDialog(null, "Enter pin doesn't Match ");
             return;
         }
          if(npin.equals(""))
         {
             JOptionPane.showMessageDialog(null, "Please Enter New Pin ");
             return;
         }
           if(rpin.equals(""))
         {
             JOptionPane.showMessageDialog(null, "Please Reenter New Pin ");
             return;
         }
           Conn conn =new Conn();
       
            String q2="update  login set Password = '"+rpin+"'where Name ='"+name+"'";
             
             
             
             conn.s.executeUpdate(q2);
           
             
             JOptionPane.showMessageDialog(null, "PIN Changed successfully  ");
             setVisible(false);
             new Login2().setVisible(true);
     }        
     
     catch(Exception k){
         System.out.println(k);
     }
     
     
     }
      else {
             setVisible(false);
             new Login2().setVisible(true);
             }
  }
      
   public static void main(String args[]){
        new passwordchange("" );
    }
}

