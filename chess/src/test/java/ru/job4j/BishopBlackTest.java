package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(bishopBlack.position(), Cell.C1);
    }

    @Test
    public void testCopyPosition() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack = bishopBlack.copy(Cell.G5);
        assertEquals(bishopBlack.position(), Cell.G5);
    }

    @Test
    public void testCopyFigure() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure newBishop = bishopBlack.copy(Cell.G5);
        assertNotSame(newBishop, bishopBlack);
    }

    @Test
    public void testWay() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] actual = bishopBlack.way(Cell.C1, Cell.G5);
        assertThat(actual, is(expect));
    }

    @Test
    public void testWayAnotherDirection() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell[] expect = {Cell.D7, Cell.E6};
        Cell[] actual = bishopBlack.way(Cell.C8, Cell.E6);
        assertThat(actual, is(expect));
    }

    @Test(expected = IllegalStateException.class)
    public void testWrongWay() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C1, Cell.E1);
    }

    @Test
    public void testDiagonalValid() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertTrue(bishop.isDiagonal(Cell.C1, Cell.G5));
    }

    @Test
    public void testDiagonalInvalid() {
        BishopBlack bishop = new BishopBlack(Cell.D4);
        assertFalse(bishop.isDiagonal(Cell.D4, Cell.G4));
    }
}
