package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
  private List<List<Cell>>board;
  Board(int dimension){
	  board=new ArrayList<>();
	  int i,j;
	  for(i=0;i<dimension;i++) {
		  ArrayList<Cell>row=new ArrayList<>();
		  for(j=0;j<dimension;j++) {
			  row.add(new Cell(i,j));
		  }
		  board.add(row);
	  }
  }
  public void display() {
	  int i,j;
	  for(i=0;i<board.size();i++) {
		  for(j=0;j<board.size();j++) {
			  if(board.get(i).get(j).state.equals(CellState.EMPTY)) {
				  System.out.printf("|   |");
			  }
			  else {
				  System.out.printf("| " + board.get(i).get(j).getPlayer().getSymbol() + " |");
			  }
		  }
		  System.out.println("\n");
	  }
  }
public boolean isValidMove(int row, int col) {
	if(row<0 || row>=board.size() || col>=board.size() || col<0) {
	return false;
}
    CellState cs=board.get(row).get(col).getState();
    if(cs.equals(CellState.FILLED) || cs.equals(CellState.BLOCKED)) {
    	return false;
     }
    return true;
}
public List<List<Cell>> getBoard() {
	return board;
}
public void setBoard(List<List<Cell>> board) {
	this.board = board;
}

}