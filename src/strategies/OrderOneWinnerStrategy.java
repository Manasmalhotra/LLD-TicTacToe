package strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Models.Board;
import Models.Cell;
import Models.Player;

public class OrderOneWinnerStrategy implements GameWinnerStrategy{
    List<HashMap<Character,Integer>>rowSymbolCount=new ArrayList<>();
    List<HashMap<Character,Integer>>columnSymbolCount=new ArrayList<>();
    HashMap<Character, Integer> topLeftDiagSymbolCount = new HashMap<>();
    HashMap<Character, Integer> topRightDiagSymbolCount = new HashMap<>();
    
    public OrderOneWinnerStrategy(int dimension){
    	  for (int i = 0; i < dimension; i++) {
              rowSymbolCount.add(new HashMap<>());
              columnSymbolCount.add(new HashMap<>());
          }
    }
	@Override
	public boolean checkWinner(Board board, Player player, Cell cell) {
		int row=cell.getRow();
		int col=cell.getCol();
		int dimension=board.getBoard().size();
		char symbol=player.getSymbol();
		
		if(!rowSymbolCount.get(row).containsKey(symbol)) {
			rowSymbolCount.get(row).put(symbol, 0);
		}
		rowSymbolCount.get(row).put(symbol,rowSymbolCount.get(row).get(symbol)+1);
		
		if(!columnSymbolCount.get(col).containsKey(symbol)) {
			columnSymbolCount.get(col).put(symbol, 0);
		}
		columnSymbolCount.get(col).put(symbol,columnSymbolCount.get(col).get(symbol)+1);
		
		if(row==col && !(topLeftDiagSymbolCount.containsKey(symbol))) {
			topLeftDiagSymbolCount.put(symbol, 0);
		}
		if(row==col) {
			topLeftDiagSymbolCount.put(symbol, topLeftDiagSymbolCount.get(symbol)+1);
		}
		if(row+col==dimension-1 && !(topRightDiagSymbolCount.containsKey(symbol))) {
			topRightDiagSymbolCount.put(symbol, 0);
		}
		if(row+col==dimension-1) {
			topRightDiagSymbolCount.put(symbol,topRightDiagSymbolCount.get(symbol)+1);
		}
		 if (rowSymbolCount.get(row).get(symbol) == dimension ||
		            columnSymbolCount.get(col).get(symbol) == dimension) {
		            return true;
		        }

         if (row == col && topLeftDiagSymbolCount.get(symbol) == dimension) {
		        return true;
		  }

		 if (row + col == dimension - 1 && topRightDiagSymbolCount.get(symbol) == dimension)  {
		        return true;
		  }
		 
		return false;
	}

}
