import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Version1bis {
    private JTextField lignesTextField;
    private JButton genererButton;
    private JButton genererToutButton;
    private JTextField rerollsTextField;
    private JTextArea resultatTextArea;
    private JPanel mainPanel;

    public Version1bis() {
        lignesTextField = new JTextField(10);
        genererButton = new JButton("Generer seul");
        genererToutButton = new JButton("Generer tout");
        rerollsTextField = new JTextField(10);
        resultatTextArea = new JTextArea(10, 20);
        mainPanel = new JPanel();

        genererButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genererPaire();
            }
        });

        genererToutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genererToutesPaires();
            }
        });

        mainPanel.add(new JLabel("Nombre de lignes: "));
        mainPanel.add(lignesTextField);
        mainPanel.add(new JLabel("Nombre de rerolls: "));
        mainPanel.add(rerollsTextField);
        mainPanel.add(genererButton);
        mainPanel.add(genererToutButton);
        mainPanel.add(resultatTextArea);
    }

    private void genererPaire() {
        genererPaires(1);
    }

    private void genererToutesPaires() {
        genererPaires(6);
    }

    private void genererPaires(int nombreDePaires) {
        try {
            int nombreDeLignes = Integer.parseInt(lignesTextField.getText());
    
            int nombreDeRerolls;
            try {
                nombreDeRerolls = Integer.parseInt(rerollsTextField.getText());
            } catch (NumberFormatException ex) {
                // En cas d'échec de conversion, prendre 0 par défaut
                nombreDeRerolls = 0;
            }
    
            StringBuilder resultat = new StringBuilder();
    
            for (int i = 0; i < nombreDePaires; i++) {
                int premierNombre = getRandomBetween(1, nombreDeLignes);
                int deuxiemeNombre = getRandomBetween(1, 5);
                resultat.append("Paire ").append(i + 1).append(": ").append(premierNombre).append(", ").append(deuxiemeNombre).append("\n");
            }
    
            for (int i = 0; i < nombreDeRerolls; i++) {
                int premierNombre = getRandomBetween(1, nombreDeLignes);
                int deuxiemeNombre = getRandomBetween(1, 5);
                resultat.append("Reroll ").append(i + 1).append(": ").append(premierNombre).append(", ").append(deuxiemeNombre).append("\n");
            }
    
            resultatTextArea.setText(resultat.toString());
    
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainPanel, "Veuillez entrer des valeurs valides pour le nombre de lignes.");
        }
    }
    

    private int getRandomBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("RandomRush");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Version1bis().mainPanel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
