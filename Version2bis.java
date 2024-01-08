import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Version2bis {
    private JTextField lignesTextField;
    private JButton generateButton;
    private JButton generateAllButton;
    private JTextField rerollsTextField;
    private JTextArea resultTextArea;
    private JPanel mainPanel;

    public Version2bis() {
        lignesTextField = new JTextField(10);
        generateButton = new JButton("Generer seul");
        generateAllButton = new JButton("Generer tout");
        rerollsTextField = new JTextField(10);
        resultTextArea = new JTextArea(10, 20);
        mainPanel = new JPanel();

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePairs("One");
            }
        });

        generateAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePairs("All");
            }
        });

        mainPanel.add(new JLabel("Nombre de lignes: "));
        mainPanel.add(lignesTextField);
        mainPanel.add(new JLabel("Nombre de rerolls: "));
        mainPanel.add(rerollsTextField);
        mainPanel.add(generateButton);
        mainPanel.add(generateAllButton);
        mainPanel.add(resultTextArea);
    }

    private void generatePairs(String type){
        switch(type){
            case "All":
                pairsGenerator(6);
                break;
            case "One": 
                pairsGenerator(1);
                break;
        }
    }

    private void pairsGenerator(int pairsNumber) {
        try {
            int linesNumber = Integer.parseInt(lignesTextField.getText());
    
            int rerollsNumber;
            try {
                rerollsNumber = Integer.parseInt(rerollsTextField.getText());
            } catch (NumberFormatException ex) {
                // En cas d'échec de conversion, prendre 0 par défaut
                rerollsNumber = 0;
            }
    
            StringBuilder result = new StringBuilder();
    
            printPairs(pairsNumber, "Pair", linesNumber, result);

            printPairs(rerollsNumber, "Reroll", linesNumber, result);

            resultTextArea.setText(result.toString());
    
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainPanel, "Veuillez entrer des valeurs valides pour le nombre de lignes.");
        }
    }
    

    private static int getRandomBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static void printPairs(int length, String type, int linesNumber, StringBuilder result){
        for (int i = 0; i < length; i++) {
            int firstNumber = getRandomBetween(1, linesNumber);
            int secondNumber = getRandomBetween(1, 5);
            result.append(type).append(i + 1).append(": ").append(firstNumber).append(", ").append(secondNumber).append("\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("RandomPairs");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Version2bis().mainPanel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
