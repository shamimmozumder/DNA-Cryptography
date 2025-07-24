import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dnaEncryption extends JFrame implements ActionListener {

    private JTextField input, output;
    private JButton encryptButton, clearButton, backButton;

    public dnaEncryption() 
    {
        setTitle("DNA Cryptography");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        Font font = new Font("Arial",Font.BOLD + Font.ITALIC,25);

        // Labe of plaintext
        JLabel inputLabel = new JLabel("Plaintext:");
        inputLabel.setFont(font);

        //Level of Dna Message
        JLabel outputLabel = new JLabel(" DNA Cipher Text:");
        outputLabel.setFont(font);

        // Text fields
        input = new JTextField(25);
        input.setFont(font);

        output = new JTextField(25);
        output.setFont(font);
        //outputField.setEditable(false);

        // encryption Button
        encryptButton = new JButton("Encrypt");
         encryptButton.setFont(font);
         encryptButton.setForeground(Color.BLACK);
         encryptButton.setBackground(Color.CYAN);

         //clear button
        clearButton = new JButton("Clear");
        clearButton.setFont(font);
         clearButton.setForeground(Color.RED);
         clearButton.setBackground(Color.WHITE);

        //back button
        backButton = new JButton("Back");
        backButton.setFont(font);
         backButton.setForeground(Color.ORANGE);
         backButton.setBackground(Color.RED);

        encryptButton.setFont(font);
        clearButton.setFont(font);
        backButton.setFont(font);

        encryptButton.addActionListener(this);
        clearButton.addActionListener(this);
        backButton.addActionListener(this);

        // Layout for center content
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(inputLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(input, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(outputLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        centerPanel.add(output, gbc);

        // Layout for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(encryptButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        // Add to frame
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // DNA Encoding method
    private String toDNA(String text) 
    {
        StringBuilder binary = new StringBuilder();

        for (char c : text.toCharArray()) 
        {
            binary.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0'));
        }

        StringBuilder dna = new StringBuilder();

        for (int i = 0; i < binary.length(); i += 2) 
        {
            String bits = binary.substring(i, Math.min(i + 2, binary.length()));

            switch (bits) 
            {
                case "00":
                    dna.append("A");
                    break;

                case "01":
                    dna.append("T");
                    break;

                case "10":
                    dna.append("C");
                    break;

                case "11":
                    dna.append("G");
                    break;

                default:
                    dna.append("N"); // error case
                    break;
            }
        }

        return dna.toString();

    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == encryptButton) 
        {
            String inputt = input.getText().trim();

            if (!inputt.isEmpty()) 
            {
                output.setText(toDNA(inputt));
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Please enter some text!");
            }
        } 
        else if (e.getSource() == clearButton) 
        {
            input.setText("");
            output.setText("");
        } 
        

        backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt)
                {
                    if(evt.getSource()== backButton)
                    {
                        dispose();
                        Llistfrontpage xy =  new Llistfrontpage();
                        xy.setVisible(true);
                    }
                }
               });
    }

    

    public static void main(String[] args) {
        //SwingUtilities.invokeLater(() -> new dnaEncryption());

        dnaEncryption de = new dnaEncryption();
        de.setVisible(true);
    }

}
