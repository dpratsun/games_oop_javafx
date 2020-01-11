package job4j.tictactoe;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class Logic3TTest {

    @Test
    public void whenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }


    @Test
    public void whenNotFill() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(false));
        assertThat(logic.isWinnerX(), is(false));
    }

    @Test
    public void whenHasXHorizontalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXVerticalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXDiagonalWinner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXBackDiagonalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    @Test
    public void whenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false, true), new Figure3T(), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    @Test
    public void whenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.hasGap(), is(true));
    }

    @Test
    public void whenHasNoGap() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(false, true), new Figure3T(false, true)},
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(false, true)},
                {new Figure3T(false, true), new Figure3T(true, false), new Figure3T(true, false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.hasGap(), is(false));
    }
}
