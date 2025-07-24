import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

public class frontPage extends JFrame {
    private Container c;
    private Font f;
    private JButton dna;
    private Cursor cursor;
    
    frontPage()
    {
        //freme
       setSize(1550, 900);
        setTitle("DNA Cryptography");
       setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon background_image = new ImageIcon("DNA.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1550,900,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
       JLabel background = new JLabel("", background_image,JLabel.CENTER);
        background.setBounds(0,0,1550,900);
        add(background);

        setVisible(true);

        initComponents();
    }
    public void initComponents()
    {
        c = this.getContentPane();
       c.setLayout(null);

        f = new Font("Arial",Font.BOLD + Font.ITALIC,30);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
     dna = new JButton("DNA Cryptography");
        dna.setFont(f);
        dna.setBounds(600,375,330,80);
        dna.setForeground(Color.RED);
        dna.setBackground(Color.WHITE);
       dna.setCursor(cursor);
        c.add( dna);

       dna.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==dna)
                {
                    dispose();
                    Llistfrontpage dst = new Llistfrontpage();
                    dst.setVisible(true);   
                }  
            }
           });  
    }
    public static void main(String[] args) {
       
        frontPage fp = new frontPage();
        fp.setVisible(true);
       
        
    } 
}