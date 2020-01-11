package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.isWinner(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.isWinner(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(f -> !f.hasMarkX() && !f.hasMarkO());
    }

    private boolean isWinner(Predicate<Figure3T> predicate) {
        boolean result = false;
        int diagonalCnt = 0;
        int diagonalBackCnt = 0;
        for (int row = 0; row < table.length; row++) {
            if (predicate.test(table[table.length - 1 - row][row])) {
                if (++diagonalBackCnt == table.length) {
                    result = true;
                    break;
                }
            }
            if (predicate.test(table[row][row])) {
                if (++diagonalCnt == table.length) {
                    result = true;
                    break;
                }
                int rowCount = 0;
                int colCount = 0;
                for (int cell = 0; cell < table.length; cell++) {
                    if (predicate.test(table[row][cell])) {
                        rowCount++;
                    }
                    if (predicate.test(table[cell][row])) {
                        colCount++;
                    }
                }
                if (rowCount == table.length || colCount == table.length) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
