import javax.swing.*;+

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterGUI extends JFrame {
    private JTextArea textArea;
    private JLabel countLabel;

    public WordCounterGUI() {
        setTitle("Word Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                countLabel.setText("Word Count: " + wordCount);
            }
        });

        countLabel = new JLabel("Word Count: 0");
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(countButton, BorderLayout.SOUTH);
        panel.add(countLabel, BorderLayout.NORTH);

        add(panel);
        setVisible(true);
    }

    private int countWords(String text) {
        if (text.isEmpty())
            return 0;
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterGUI();
            }
        });
    }
}