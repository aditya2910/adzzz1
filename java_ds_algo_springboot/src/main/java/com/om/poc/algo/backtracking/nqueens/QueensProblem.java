package com.om.poc.algo.backtracking.nqueens;

public class QueensProblem {

  int[][] chessTable;
  int noOfQueens;

  public QueensProblem(final int noOfQueens) {
    this.chessTable = new int[noOfQueens][noOfQueens];
    this.noOfQueens = noOfQueens;
  }

  public void solve() {
    if (setQueens(0)) {
      printQueens(chessTable);
    } else {
      System.out.println("VehicleService is not possible....");
    }
  }

  private void printQueens(final int[][] chessTable) {
    for (int i = 0; i < chessTable.length; i++) {
      for (int j = 0; j < chessTable.length; j++) {
        if (chessTable[i][j] == 1) {
          System.out.print(" * ");
        } else {
          System.out.print(" - ");
        }
      }
      System.out.println();
    }
  }

  private boolean setQueens(final int colIndex) {
    if (colIndex == noOfQueens) {
      return true;
    }

    for (int rowIndex = 0; rowIndex < noOfQueens; rowIndex++) {
      if (isValidPlace(rowIndex, colIndex)) {
        chessTable[rowIndex][colIndex] = 1;
        if (setQueens(colIndex + 1)) {
          return true;
        }
      }
      // backtracking
      chessTable[rowIndex][colIndex] = 0;

    }
    return false;
  }

  private boolean isValidPlace(int rowIndex, int colIndex) {

    for (int i = 0; i < colIndex; i++) {
      if (chessTable[rowIndex][i] == 1) {
        return false;
      }
    }

    for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
      if (chessTable[i][j] == 1) {
        return false;
      }
    }

    for (int i = rowIndex, j = colIndex; i < chessTable.length && j >= 0; i++, j--) {
      if (chessTable[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

}
