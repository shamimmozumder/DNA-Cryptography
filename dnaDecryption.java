import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dnaDecryption extends JFrame implements ActionListener {

    private JTextField input, output;
    private JButton decryptButton, clearButton, backButton;

    public dnaDecryption() 
    {
        setTitle("DNA Cryptography decryption");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Font making
        Font font = new Font("Arial", Font.BOLD + Font.ITALIC, 25);

        // label of Dna Sequance
        JLabel inputLabel = new JLabel(" DNA Cipher Text:");
        inputLabel.setFont(font);
        
        //level of plaintext
        JLabel outputLabel = new JLabel(" Plaintext:");
        outputLabel.setFont(font);

        // Text fields
        input = new JTextField(25);
        input.setFont(font);

        output = new JTextField(25);
        output.setFont(font);
        //outputField.setEditable(false);

        // Decryption Button
        decryptButton = new JButton("Decrypt");
        decryptButton.setFont(font);
         decryptButton.setForeground(Color.BLACK);
         decryptButton.setBackground(Color.CYAN);

        //clear Button
        clearButton = new JButton("Clear");
        clearButton.setFont(font);
         clearButton.setForeground(Color.RED);
         clearButton.setBackground(Color.WHITE);

        //backButton
        backButton = new JButton("Back");
        backButton.setFont(font);
        backButton.setForeground(Color.ORANGE);
         backButton.setBackground(Color.RED);

        decryptButton.setFont(font);
        clearButton.setFont(font);
        backButton.setFont(font);

        decryptButton.addActionListener(this);
        clearButton.addActionListener(this);
        backButton.addActionListener(this);

        // Center layout
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

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(decryptButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        // Add panels to frame
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // DNA to Plaintext conversion
    private String fromDNA(String dna) 
    {
        StringBuilder binary = new StringBuilder();

        // Convert DNA letters to 2-bit binary
        for (char c : dna.toUpperCase().toCharArray()) 
        {
            switch (c) 
            {
                case 'A': 
                binary.append("00"); 
                break;

                case 'T': 
                binary.append("01"); 
                break;

                case 'C': 
                binary.append("10"); 
                break;

                case 'G': 
                binary.append("11"); 
                break;

                default: 
                binary.append(""); // Skip invalid chars
            }
        }

        StringBuilder text = new StringBuilder();

        // Every 8 bits = 1 character
        for (int i = 0; i + 8 <= binary.length(); i += 8) 
        {
            String byteStr = binary.substring(i, i + 8);

            int ascii = Integer.parseInt(byteStr, 2);
            text.append((char) ascii);
        }

        return text.toString();
    }

    public void actionPerformed(ActionEvent e) 
    {

        if (e.getSource() == decryptButton) 
        {
            String inputt = input.getText().trim();

            if (!inputt.isEmpty()) 
            {
                output.setText(fromDNA(inputt));
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Please enter a DNA sequence!");
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
        //SwingUtilities.invokeLater(() -> new dnaDecryption());

        dnaDecryption dd = new dnaDecryption();
        dd.setVisible(true);
    }
}
