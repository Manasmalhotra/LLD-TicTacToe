package Models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
   String name;
   char symbol;
   PlayerType type;
   
   public Player(String name,char symbol,PlayerType type){
	   this.name=name;
       this.symbol=symbol;	   
       this.type=type;
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public char getSymbol() {
	return symbol;
}

public void setSymbol(char symbol) {
	this.symbol = symbol;
}

public PlayerType getType() {
	return type;
}

public void setType(PlayerType type) {
	this.type = type;
}

public Move decideMove(Board board) throws InputMismatchException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter the row of the cell:");
	int row=sc.nextInt();
	System.out.println("Please enter the column of the cell: ");
	int col=sc.nextInt();
	return new Move(this,new Cell(row,col));
	
}

}
