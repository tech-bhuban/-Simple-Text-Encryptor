
import javax.swing.*;
import java.awt.*;

public class TextEncryptor extends JFrame {
    private JTextArea inputArea, outputArea;
    private JTextField keyField;
    
    public TextEncryptor() {
        setTitle("Simple Text Encryptor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Input Text:"), BorderLayout.NORTH);
        inputArea = new JTextArea(5, 40);
        inputPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        
        // Key panel
        JPanel keyPanel = new JPanel();
        keyPanel.add(new JLabel("Secret Key (1-10):"));
        keyField = new JTextField(5);
        keyPanel.add(keyField);
        
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");
        keyPanel.add(encryptButton);
        keyPanel.add(decryptButton);
        add(keyPanel, BorderLayout.CENTER);
        
        // Output panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Result:"), BorderLayout.NORTH);
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
        
        encryptButton.addActionListener(e -> process(true));
        decryptButton.addActionListener(e -> process(false));
    }
    
    private void process(boolean encrypt) {
        try {
            int key = Integer.parseInt(keyField.getText());
            String text = inputArea.getText();
            StringBuilder result = new StringBuilder();
            
            for(char c : text.toCharArray()) {
                if(encrypt) {
                    result.append((char)(c + key));
                } else {
                    result.append((char)(c - key));
                }
            }
            
            outputArea.setText(result.toString());
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid key!");
        }
    }
    
    public static void main(String[] args) {
        new TextEncryptor().setVisible(true);
    }
}
