import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToeGame {

    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";
    private String currentPlayer = PLAYER_X;
    private JButton[] buttons = new JButton[9];
    private boolean gameOver = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeGame game = new TicTacToeGame();
            game.createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(new ButtonClickListener(i));
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int index;

        public ButtonClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[index].getText().equals("") && !gameOver) {
                buttons[index].setText(currentPlayer);
                buttons[index].setEnabled(false);
                if (checkWin()) {
                    showWinner();
                } else {
                    currentPlayer = (currentPlayer.equals(PLAYER_X)) ? PLAYER_O : PLAYER_X;
                }
            }
        }
    }

    private boolean checkWin() {
        String[][] winPatterns = {
            {"0", "1", "2"}, 
            {"3", "4", "5"}, 
            {"6", "7", "8"}, 
            {"0", "3", "6"}, 
            {"1", "4", "7"}, 
            {"2", "5", "8"}, 
            {"0", "4", "8"}, 
            {"2", "4", "6"}  
        };

        for (String[] pattern : winPatterns) {
            String a = buttons[Integer.parseInt(pattern[0])].getText();
            String b = buttons[Integer.parseInt(pattern[1])].getText();
            String c = buttons[Integer.parseInt(pattern[2])].getText();
            if (a.equals(b) && b.equals(c) && !a.equals("")) {
                highlightWinningLine(pattern);
                return true;
            }
        }
        return false;
    }

    private void showWinner() {
        JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
        gameOver = true;
    }

    private void highlightWinningLine(String[] pattern) {
        for (String index : pattern) {
            int i = Integer.parseInt(index);
            buttons[i].setBackground(Color.GREEN); 
        }
    }
}
