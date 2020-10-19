import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class TetrisTest {

	/**
	 * Test for the row removal feature whether it behaves correctly.
	 * Fill up all grids with square except two grids at 4th and 6th column in row 11,
	 * after calling checkRows(),check if all filled grids are removed except
	 * two grids at 4th and 6th column in the bottom row.
	 */	
	@Test
	void testCheckRows() {
		Grid g = new Grid();
		for (int row = 0; row < Grid.HEIGHT; row++) {
			for (int col = 0; col < Grid.WIDTH; col++) {
				if(row != 10 || col == 3 || col == 5) {
					g.set(row, col, Color.MAGENTA);
				}
			}
		}
		g. checkRows();

		for (int row = 0; row < Grid.HEIGHT; row++) {
			for (int col = 0; col < Grid.WIDTH; col++) {
				if (row < Grid.HEIGHT - 1 || col != 3 && col != 5) {
					assertFalse(g.isSet(row, col));
				}
			}
		}
	}
	
	
	Grid g = new Grid();
	LShape l = new LShape(10, 0, g);
	
	/**
	 * Test for the motion of the L-Shape whether it moves correctly
	 * L-Shape will be detected every time it moves to the right until it reaches all the way to right
	 */	
	@Test
	void testMove() {
		for (int col = 0; col < Grid.WIDTH - 2; col++) {
			l.move(Direction.RIGHT);	
		}
		assertTrue(!l.canMove(Direction.RIGHT));
	}

	/**
	 * Test for the motion of the L-Shape when there is a square in the way
	 * The L-Shape will not be able to move right or left but down
	 */
	@Test
	void testCanMove() {
		g.set(10,  1, Color.MAGENTA);
		assertTrue((!l.canMove(Direction.RIGHT)) && (!l.canMove(Direction.LEFT)) && (l.canMove(Direction.DOWN)));
		
	}

}
