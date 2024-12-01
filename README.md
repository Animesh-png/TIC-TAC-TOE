# TIC-TAC-TOE Code Explanation

1. Class and Instance Variables:
•	PLAYER_X and PLAYER_O: These are constants of type String that represent the two players in the Tic-Tac-Toe game. PLAYER_X is "X" and PLAYER_O is "O". They are used to track which player's turn it is and to mark the board.
•	currentPlayer: A String that keeps track of the current player, starting with "X". This variable alternates between "X" and "O" after each move.
•	buttons[]: An array of JButton objects, each representing a cell on the Tic-Tac-Toe grid. There are 9 buttons in total (3x3 grid).
•	gameOver: A boolean flag that tracks if the game has ended. It's set to true when a player wins, which prevents further actions (like clicks) during a finished game.
3. Main Method (main):
•	SwingUtilities.invokeLater(): This is an inbuilt method from the SwingUtilities class that ensures that the Swing components are created and updated in the Event Dispatch Thread (EDT), which is the correct thread for managing GUI updates in Swing applications.
•	The main method creates an instance of the TicTacToeGame class and calls the createAndShowGUI() method to initialize the graphical user interface (GUI).
4. Creating and Showing GUI (createAndShowGUI()):
•	JFrame: A JFrame is a top-level container provided by Swing that represents the main window of the application. In this code, it's used to create the main window titled "Tic-Tac-Toe".
o	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE): This method ensures that when the user closes the window, the program terminates.
o	setSize(400, 400): This method sets the size of the JFrame window to 400x400 pixels.
o	setLayout(new GridLayout(3, 3)): The GridLayout manager is used to arrange the buttons in a 3x3 grid, which corresponds to the Tic-Tac-Toe board.
•	JButton: A JButton is a Swing component that represents a clickable button. Here, each button is used as a cell on the Tic-Tac-Toe grid.
o	buttons[i] = new JButton(""): Initializes each button with an empty label, indicating an empty cell on the board.
o	setFont(new Font("Arial", Font.PLAIN, 60)): Sets the font of the button text to "Arial" with a font size of 60, making the "X" and "O" characters large and readable.
o	setFocusPainted(false): Disables the default focus outline that Swing buttons show when clicked.
o	addActionListener(new ButtonClickListener(i)): Adds an ActionListener to each button. When clicked, it triggers the actionPerformed() method inside the ButtonClickListener class (explained below).
o	frame.add(buttons[i]): Adds each button to the JFrame, arranging them in the 3x3 grid layout.
•	frame.setVisible(true): This method makes the JFrame visible on the screen after all the components are added.
5. ButtonClickListener Class:
•	ButtonClickListener: This is an inner class that implements ActionListener. It listens for button clicks and processes the player's move.
o	ButtonClickListener(int index): The constructor takes an index parameter, which corresponds to the index of the clicked button in the buttons[] array. This ensures that each button knows which position it corresponds to on the board.
o	actionPerformed(ActionEvent e): This method is called when a button is clicked. It checks if the clicked button is empty (buttons[index].getText().equals("")) and if the game isn't over. If both conditions are true, it sets the text of the button to the current player's symbol and disables the button (setEnabled(false)), preventing further clicks.
o	checkWin(): This method checks if the current player has won the game after their move. If a player wins, it calls showWinner() to display the winner and sets gameOver = true.
6. Game Logic Methods:
•	checkWin(): This method checks if any of the predefined winning patterns have been achieved by the current player. The possible winning patterns are stored in a 2D array (winPatterns), where each pattern is a set of three indices corresponding to buttons in the grid.
o	String[][] winPatterns: An array that defines the 8 possible winning line patterns for the Tic-Tac-Toe game.
o	Integer.parseInt(pattern[0]): Converts the string representation of the index (like "0") into an integer to access the corresponding button in the buttons[] array.
o	buttons[Integer.parseInt(pattern[0])].getText(): Retrieves the text from the button at the given index. The method compares the text of three buttons to see if they are the same and not empty. If so, the player wins.
o	highlightWinningLine(pattern): If a player wins, this method is called to highlight the winning buttons by changing their background color to green.
•	showWinner(): This method uses JOptionPane.showMessageDialog(), which is a Swing utility that shows a message dialog to the user. It displays the winner of the game.
o	JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!"): This shows a dialog indicating which player won the game.
o	gameOver = true: This flag is set to true, which prevents any further moves or button clicks after the game has ended.
•	highlightWinningLine(String[] pattern): This method highlights the winning line of buttons by changing their background color to green.
o	buttons[i].setBackground(Color.GREEN): This method sets the background color of the winning buttons to green, visually indicating the winning line.
7. Inbuilt Functions Used:
•	setFont(): This method sets the font of a Swing component. In this case, it changes the font of each button to be larger and more readable.
•	setFocusPainted(): Disables the focus painting (highlighted border) on buttons.
•	setEnabled(): Disables a button so that it can't be clicked again once the player has made a move.
•	getText(): Retrieves the current text displayed on the button, which is either "X", "O", or an empty string.
•	setBackground(): Changes the background color of the button, used to highlight winning moves.
•	JOptionPane.showMessageDialog(): Displays a simple pop-up dialog with a message, in this case, used to announce the winner.
Conclusion:
This program makes use of key Swing components and event-driven programming to create an interactive Tic-Tac-Toe game. The JButton objects represent the cells of the game, and ActionListener listens for button clicks to update the game state. The code uses basic logic to alternate players, check for a win, and display the winner through message dialogs and UI updates. The use of inbuilt Swing methods, like setFont(), setEnabled(), JOptionPane.showMessageDialog(), and others, provides functionality to control the game's flow and user interaction.

