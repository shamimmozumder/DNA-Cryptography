import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;


public class Llistfrontpage extends JFrame {
    private Container c;
    private Font f;
    private JButton encryptButton,decryptButton,backButton;
    private Cursor cursor;

    Llistfrontpage()
    {
        setSize(1550, 900);
        setTitle("Dna Cryptography");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon background_image2 = new ImageIcon("DNA1.jpg");
        Image img2 = background_image2.getImage();
        Image temp_img2 = img2.getScaledInstance(1550,900,Image.SCALE_SMOOTH);
        background_image2 = new ImageIcon(temp_img2);
       JLabel background = new JLabel("", background_image2,JLabel.CENTER);
        background.setBounds(0,0,1550,900);
        add(background);

        setVisible(true);

        initComponents();
    }

    public void initComponents()
    {
        c = this.getContentPane();
        c.setLayout(null);
 
         f = new Font("Arial",Font.BOLD + Font.ITALIC,35);
          //Cursor making
        cursor = new Cursor(Cursor.HAND_CURSOR);

         //Back Button
         
         backButton = new JButton("Back");
         backButton.setFont(f);
         backButton.setBounds(1250,650,200,50);
         backButton.setForeground(Color.ORANGE);
         backButton.setBackground(Color.RED);
         backButton.setCursor(cursor);
         c.add(backButton);


         //Singly button
         encryptButton = new JButton("Encryption");
         encryptButton.setFont(f);
         encryptButton.setBounds(630, 370, 350, 50);
         encryptButton.setForeground(Color.BLACK);
         encryptButton.setBackground(Color.YELLOW);
         encryptButton.setCursor(cursor);
         c.add(encryptButton);

         //Doubley LinkedList
         decryptButton = new JButton("Decryption");
         decryptButton.setFont(f);
         decryptButton.setBounds(630, 450, 350, 50);
         decryptButton.setForeground(Color.BLACK);
         decryptButton.setBackground(Color.yellow);
        decryptButton.setCursor(cursor);
         c.add(decryptButton);

         encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
             {
                 if(e.getSource()==encryptButton)
                 {
                     dispose();
                     dnaEncryption sll= new dnaEncryption();
                     sll.setVisible(true);
                     
                 }  
             }
            }); 

            decryptButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                 {
                     if(e.getSource()==decryptButton)
                     {
                         dispose();
                        dnaDecryption DL = new dnaDecryption();
                        DL.setVisible(true);
                         
                     }  
                 }
                }); 
            
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt)
                {
                    if(evt.getSource()== backButton)
                    {
                        dispose();
                        frontPage xy =  new frontPage();
                        xy.setVisible(true);
                    }
                }
               });
    }

    public static void main(String[] args) {
        Llistfrontpage lf = new Llistfrontpage();
        lf.setVisible(true);
       
    }
    
}