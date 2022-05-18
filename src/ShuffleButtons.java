import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleButtons extends FrameOfGame {

    boolean fakeRound = true;
    private boolean resetActive;

    private final List<JButton> buttons;
    List<String> winning = new ArrayList<>();
    List<String> winningOrder = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8",
            "9", "10", "11", "12", "13", "14", "15", "");

    public ShuffleButtons() {
        buttons = this.getButtons();
        panel.add(resetButton(), BorderLayout.SOUTH);
    }

    public void shuffleButtons() {
        if (!fakeRound) {
            Collections.shuffle(buttons);
        } else {
            Collections.swap(buttons, 14, 15);
        }
        reLayoutButtons();

    }

    public void reLayoutButtons() {
        buttonPanel.removeAll();
        for (JButton button : buttons) {
            button.addActionListener(mouse);
            buttonPanel.add(button);
        }
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    public final JButton resetButton() {
        JButton resetButton = this.getResetButton();
        resetButton.addActionListener(e -> shuffleButtons());
        resetActive = true;
        return resetButton;
    }

    ActionListener mouse = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton click = (JButton) e.getSource();
            boolean check = false;
            int index = buttonPanel.getComponentZOrder(click);

            while (!check) {

                for (Component c : buttonPanel.getComponents()) {
                    int cIndex = buttonPanel.getComponentZOrder(c);

                    if (c instanceof JButton && ((JButton) c).getText().equals("") &&
                            cIndex == index - 1) {

                        String checkName = click.getText();
                        String nextName = ((JButton) c).getText();
                        click.setText(nextName);
                        ((JButton) c).setText(checkName);
                        check = true;

                    } else if (c instanceof JButton && ((JButton) c).getText().equals("") &&
                            cIndex == index + 1) {

                        String checkName = click.getText();
                        String nextName = ((JButton) c).getText();
                        click.setText(nextName);
                        ((JButton) c).setText(checkName);
                        check = true;

                    } else if (c instanceof JButton && ((JButton) c).getText().equals("") &&
                            cIndex == index - 4) {

                        String checkName = click.getText();
                        String nextName = ((JButton) c).getText();
                        click.setText(nextName);
                        ((JButton) c).setText(checkName);
                        check = true;

                    } else if (c instanceof JButton && ((JButton) c).getText().equals("") &&
                            cIndex == index + 4) {

                        String checkName = click.getText();
                        String nextName = ((JButton) c).getText();
                        click.setText(nextName);
                        ((JButton) c).setText(checkName);
                        check = true;

                    } else if (!click.getText().equals("") || resetActive) {
                        check = true;

                    }
                }
            }

            winning();
        }
    };

    public void winning() {
        for (Component c : buttonPanel.getComponents()) {
            if (c instanceof JButton button) {
                String text = button.getText();
                winning.add(text);
                if (winning.equals(winningOrder)) {
                    JOptionPane.showMessageDialog(null, "GRATTIS DU VANN!");
                }
            }
        }
    }
}


