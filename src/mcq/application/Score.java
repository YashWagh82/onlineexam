package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import static quiz.application.Quiz.score;
import java.util.*;

public class Score extends JFrame implements ActionListener {
          JButton back,submit,sc;
          String name;
    Score(String name, int score) {
        this.name=name;
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon a=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image b=a.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        ImageIcon c=new ImageIcon(b);
        JLabel label= new JLabel(c);
        label.setBounds(300,20,100,50);
        Component add = add(label);
        
        
        JLabel heading = new JLabel("Thanyou " + name + " for giving exam.");
        heading.setBounds(200, 100, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 150, 100, 100);
        add(image);
        
        JLabel lblscore = new JLabel("Your score is  " + score);
        lblscore.setBounds(250, 250, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);
        
           try {
            if(name.equals(" ")){
                JOptionPane.showMessageDialog(null, "Name is Requried" );
        
            }
            else{
                Conn conn = new Conn();
                String q1="insert into score values('"+name+"','"+score+"')";
                conn.s.executeUpdate(q1);
               
                
               
            }
        }
        catch(Exception ae){
            System.out.println(ae);
        }
        
        
       submit = new JButton("Play Again");
        submit.setBounds(280, 300, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
        back =new JButton("CHANGE PASSWORD");
        back.setBounds(400, 400, 200, 30);
         
         back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        sc =new JButton("View Score Card");
         sc.setBounds(100, 400, 200, 30);
         
          sc.setBackground(Color.BLACK);
          sc.setForeground(Color.white);
          sc.addActionListener(this);
        add(  sc);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
          
        if(ae.getSource() == back){
            setVisible(false);
            new passwordchange(name).setVisible(true);
        }
        else if(ae.getSource()==submit){
        setVisible(false);
        new Login2();
        }
        else {
            setVisible(false);
            new pscore(name).setVisible(rootPaneCheckingEnabled);
        }
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
