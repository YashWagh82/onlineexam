
package quiz.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


    
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
public class pscore extends JFrame {
    String name;
    int score;
   pscore(String name){
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
        
           JLabel text=new JLabel("Score Card ");
        text.setBounds(650,100,800,50);
         text.setFont(new Font("Arial",Font.BOLD,30));
         add(text);
          JLabel mini=new JLabel();
           mini.setFont(new Font("Arial",Font.BOLD,10));
          add(mini);
         JLabel bank = new JLabel("Your Score In Examination");
         bank.setBounds(550,200,600,50);
         bank.setFont(new Font("Arial",Font.BOLD,30));
         add(bank);
         
         JLabel card=new JLabel();
         card.setBounds(600,300,900,20);

        card.setFont(new Font("Arial",Font.BOLD,20));
         add(card);
         
         
        

      
         
         try{
             Conn conn = new Conn();
             ResultSet rs = conn.s.executeQuery("select * from login where Name = '"+name+"'");
             while(rs.next()){
              card.setText("ID :  "+ rs.getString("ID").substring(0,4)+"XXXXXXXX"+rs.getString("ID").substring(12));
             }
         }catch(Exception n){
             System.out.println(n);
         }
         try{
             Conn conn= new Conn();
             ResultSet rs=conn.s.executeQuery("select * from score where NAME = '"+name+"'");
             while(rs.next()){
              mini.setText (mini.getText()+ "<html>" + rs.getString("NAME") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("Score") + "<br><br>" + "<html>");
             }
             setVisible(false);
             new Login2().setVisible(true);
         }catch(Exception v){
             System.out.println(v);
         }
          mini.setBounds(600,350,900,400);
         
         
          setLayout(null);
       setSize(300,300);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
       setLocation(30,30);
      
        
    }
    public static void main(String args[]){
        new pscore("");
    }
}
