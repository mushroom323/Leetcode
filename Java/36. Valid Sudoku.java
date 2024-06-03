package Java;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> myset = new HashSet<Character>();
        // 检查行
        for (int i = 0; i < 9; i++) {
            myset.clear();
            for (int j = 0; j < 9; j++) {
                if (myset.contains(board[j][i])) {
                    return false;
                }
                else if (board[j][i] != '.') myset.add(board[j][i]);
            }
        }
        // 检查列
        for (int i = 0; i < 9; i++) {
            myset.clear();
            for (int j = 0; j < 9; j++) {
                if (myset.contains(board[i][j])) return false;
                else if (board[i][j] != '.') myset.add(board[i][j]);
            }
        }
        // 检查九宫格
        for (int rs = 0; rs < 9; rs += 3) {
            for (int cs = 0; cs < 9; cs += 3) {
                myset.clear();
                for (int i = rs; i < rs + 3; i++) {
                    for (int j = cs; j < cs + 3; j++) {
                        if (myset.contains(board[i][j])) return false;
                        else if (board[i][j] != '.') myset.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}