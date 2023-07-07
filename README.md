# LLD-TicTacToe

This is a multiplayer Tic Tac Toe game designed by following the concepts of object- oriented programming, S.O.L.I.D principles and 
design patterns including builder, factory and strategy design patterns.

The project structure is in accordance to the Model-View-Controller(MVC) pattern.

The following requirements were identified for the system:

1) There will be a n*n board and n can be any number greater than equal to 3.
2) For a n*n board we will have n-1 players.
3) Each player will have their unique symbol, which will be decided by the user input.
4) The players will have sequential turns which will start with player 1 and go till player n-1, then it will again come to player 1 and so on.
5) There are multiple ways to win a game: Getting a symbol all across a row, getting a symbol all across a column and getting a symbol all across any of the two diagonals.
6) We will have an undo operation using which we can undo the most recent move. 
7) We can also have exactly one bot to play with the players.
8) There will be three levels of difficulty for bot: Easy,Medium and Hard.
9) We can quit the game anytime we want by pressing the q button.
