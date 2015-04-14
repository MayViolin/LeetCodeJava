import java.util.HashSet;
import java.util.Set;

/**
 * User: May
 * Date: 2015-03-12
 * Time: 16:14
 */
public class ValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
        Set<Character> number = new HashSet<Character>();
        for (char[] line :board) {
            for (char elem : line) {
                if (elem != '.' && !number.contains(elem)) {
                    number.add(elem);
                } else if (number.contains(elem)) {
                    return false;
                }
            }
            number.clear();
        }

        System.out.println("line invalid");

        for (int j=0;j<9;j++) {
            for (int i = 0; i < 9; i++) {
                char elem = board[i][j];
                if (elem != '.' && !number.contains(elem)) {
                    number.add(elem);
                } else if (number.contains(elem)) {
                    return false;
                }
            }
            number.clear();
        }

        int row = 0;
        int col = 0;
        while (col < 9) {
            while (row < 9) {
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        char elem = board[i][j];
                        if (elem != '.' && !number.contains(elem)) {
                            number.add(elem);
                        } else if (number.contains(elem)) {
                            return false;
                        }
                    }
                }
                number.clear();
                row = row + 3;
            }
            col = col + 3;
            row = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = {{'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}};
        ValidSudoku a = new ValidSudoku();
        System.out.println(a.isValidSudoku(chars));
    }
}
