import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FrameOfGame extends JFrame {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel buttonPanel = new JPanel();
    ImageIcon ruta = new ImageIcon("ruta.png");
    JButton resetButton = new JButton("NYTT SPEL");
    private final List<JButton> buttons;

    public List<JButton> getButtons() {
        return buttons;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    FrameOfGame() {
        frame.setPreferredSize(new Dimension(450, 500));
        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
        frame.setLocationRelativeTo(null);

        panel.setLayout(new BorderLayout());
        resetButton.setPreferredSize(new Dimension(10, 50));
        resetButton.setFont(new Font("FUTURA", Font.BOLD, 30));
        resetButton.setBackground(Color.WHITE);
        resetButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0, false));
        panel.setVisible(true);
        panel.add(resetButton, BorderLayout.SOUTH);
        frame.add(panel);

        buttonPanel.setLayout(new GridLayout(4, 4));
        buttonPanel.setBorder(BorderFactory.createLineBorder(null, 0, false));
        panel.add(buttonPanel, BorderLayout.CENTER);

        buttons = new ArrayList<>(16);

        JButton empty = new JButton("");
        empty.setIcon(ruta);
        empty.setName(String.valueOf(0));
        empty.setBackground(Color.BLACK);
        empty.setForeground(Color.WHITE);
        empty.setBorderPainted(true);
        empty.setOpaque(true);
        empty.setFont(new Font("FUTURA", Font.BOLD, 30));
        empty.setHorizontalTextPosition(JButton.CENTER);
        empty.setVerticalTextPosition(JButton.CENTER);
        empty.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0, false));
        empty.setVisible(true);

        for (int i = 1; i < 16; i++) {
            JButton button = new JButton();
            button.setIcon(ruta);
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            button.setBorderPainted(true);
            button.setOpaque(true);
            button.setFont(new Font("FUTURA", Font.BOLD, 30));
            button.setName(String.valueOf(i));
            button.setText(String.valueOf(i));
            button.setHorizontalTextPosition(JButton.CENTER);
            button.setVerticalTextPosition(JButton.CENTER);
            buttons.add(button);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0, false));
            buttonPanel.add(button);
            buttonPanel.add(empty);
        }

        buttons.add(empty);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShuffleButtons::new);

    }
}
