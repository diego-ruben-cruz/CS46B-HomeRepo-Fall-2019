package simpledoku;

import java.util.*;

public class SimpledokuGrid {
	private int nCellsPerSide;
	private int[][] values;

	public SimpledokuGrid(int nCellsPerSide) {
		this.nCellsPerSide = nCellsPerSide;
		values = new int[nCellsPerSide][nCellsPerSide];
	}

	// copy constructor that effectively clones another
	public SimpledokuGrid(SimpledokuGrid source) {
		this.nCellsPerSide = source.nCellsPerSide;
		this.values = new int[source.nCellsPerSide][source.nCellsPerSide];
		for (int row = 0; row < source.nCellsPerSide; row++) {
			for (int col = 0; col < source.nCellsPerSide; col++) {
				this.values[row][col] = source.values[row][col];
			}
		}
	}

	// Returns true if the input list contains a repeated value that isn't zero.
	private boolean containsNonZeroRepeats(ArrayList<Integer> ints) {
		HashSet<Integer> set = new HashSet<Integer>(ints.size());
		for (int ref : ints) {
			if (ref != 0 && set.add(ref) == false) {
				return true;
			}
		}
		return false;
	}

	// checks if values[][] is acceptable as a sudoku grid through row, column, and diagonal checks.
	public boolean isLegal() {
		//Row check
		for (int row = 0; row < this.nCellsPerSide; row++) {
			ArrayList<Integer> intList = new ArrayList<Integer>();
			for (int col = 0; col < this.nCellsPerSide; col++) {
				intList.add(values[row][col]);
				if (this.containsNonZeroRepeats(intList) == true) {
					return false;
				}
			}
		}
		
		//Column check
		for (int col = 0; col < this.nCellsPerSide; col++) {
			ArrayList<Integer> intList2 = new ArrayList<Integer>();
			for (int row = 0; row < this.nCellsPerSide; row++) {
				intList2.add(values[row][col]);
				if (this.containsNonZeroRepeats(intList2) == true) {
					return false;
				}
			}
		}
		
		// Check top-left to bottom-right diagonal.
		ArrayList<Integer> intList3 = new ArrayList<Integer>();
		for (int row = 0; row < this.nCellsPerSide; row++) {
			intList3.add(values[row][row]);
			if (this.containsNonZeroRepeats(intList3) == true) {
				return false;
			}
		}

		// Check top-right to bottom-left diagonal.
		ArrayList<Integer> intList4 = new ArrayList<Integer>();
		for (int row = 0; row < this.nCellsPerSide; row++) {
			intList4.add(values[row][this.nCellsPerSide - row - 1]);
			if (this.containsNonZeroRepeats(intList4) == true) {
				return false;
			}
		}

		// If we haven't returned yet, this grid must be legal.
		return true;

	}

	// Returns true if all members of the values[][] array are non-zero.
	public boolean isFull() {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int row = 0; row < this.nCellsPerSide; row++) {
			for (int col = 0; col < this.nCellsPerSide; col++) {
				intList.add(this.values[row][col]);
			}
		}
		boolean temp = true;
		for (int ref : intList) {
			if (ref <= 0) {
				temp = false;
			}
		}
		return temp;
	}

	// Returns the Evaluation corresponding to the state of this grid. The return
	// will be
	// Evaluation.ABANDON, Evaluation.ACCEPT, or Evaluation.CONTINUE. To determine
	// what to
	// return, call isLegal() and isFull().
	public Evaluation evaluate() {
		if (!isLegal())
			return Evaluation.ABANDON;
		else if (isFull())
			return Evaluation.ACCEPT;
		else
			return Evaluation.CONTINUE;
	}

	// Returns a size = 2 array of ints that index the next empty cell in the
	// values[][] array.
	// The 2 ints in the returned array are the first and second indices into the
	// values[][] array.
	// Returns null if this grid is full.
	private int[] getIndicesOfNextEmptyCell() {
		int[] xy = new int[2];

		for (xy[0] = 0; xy[0] < nCellsPerSide; xy[0]++)
			for (xy[1] = 0; xy[1] < nCellsPerSide; xy[1]++)
				if (values[xy[0]][xy[1]] == 0)
					return xy;

		return null;
	}

	// Finds an empty member of values[][]. Returns an array list containing
	// nCellsPerSide grids that look like the
	// current grid, except the empty member contains 1, 2, 3 .... nCellsPerSide.
	//
	//
	// Example: if this grid = 12300
	// 00000
	// 00000
	// 00000
	// 00000
	//
	// Then the returned array list contains:
	//
	// 12310 	12320 	 12330    12340    12350
	// 00000 	00000 	 00000 	  00000    00000
	// 00000 to 00000 to 00000 to 00000 to 00000
	// 00000 	00000 	 00000    00000    00000
	// 00000 	00000 	 00000    00000    00000
	//
	ArrayList<SimpledokuGrid> generateNextGrids() {
		int[] indicesOfNext = this.getIndicesOfNextEmptyCell();
		ArrayList<SimpledokuGrid> nextGrids = new ArrayList<SimpledokuGrid>();
		// Generate some grids and put them in nextGrids. Be sure that every
		// grid is a separate object.
		for (int digit = 1; digit < this.nCellsPerSide + 1; digit++) {
			SimpledokuGrid grid = new SimpledokuGrid(this);
			grid.values[indicesOfNext[0]][indicesOfNext[1]] = digit;
			nextGrids.add(grid);
		}

		// return ArrayList
		return nextGrids;

	}

	// Use this for debugging if it's helpful.
	public String toString() {
		String s = "";
		for (int j = 0; j < nCellsPerSide; j++) {
			for (int i = 0; i < nCellsPerSide; i++) {
				if (values[j][i] == 0)
					s += ".";
				else
					s += ("" + values[j][i]);
			}
			s += "\n";
		}
		return s;
	}
}
