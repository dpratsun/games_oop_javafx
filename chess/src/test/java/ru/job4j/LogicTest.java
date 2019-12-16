package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LogicTest {
    private Logic logic = new Logic();

    @Test
    public void whenMoveIsCorrectAndNoFiguresOnTheWayTest() {
        logic.add(new BishopBlack(Cell.C1));
        assertTrue(logic.move(Cell.C1, Cell.G5));
    }

    @Test(expected = IllegalStateException.class)
    public void whenMoveIsNotCorrectTest() {
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.G4);
    }

    @Test
    public void whenMoveIsCorrectAndFigureOnTheWayTest() {
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.E3));
        assertFalse(logic.move(Cell.C1, Cell.G5));
    }
}
