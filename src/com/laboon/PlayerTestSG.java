/*
 * hasAllItems()
 * drink()
 * public Player(boolean sugar, boolean cream, boolean coffee)
 */
package com.laboon;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class PlayerTestSG {

	@Test
	public void testNoItems() {
		Player play= new Player(true, true, true);
		assertTrue(play.hasAllItems());
	}
	
	@Test
	public void testNoSugar() {
		Player play= new Player(false, true, true);
		assertFalse(play.hasAllItems());
	}
	
	@Test
	public void testNoCream() {
		Player play= new Player(true, false, true);
		assertFalse(play.hasAllItems());
	}
	@Test
	public void testNoCoffee() {
		Player play= new Player(true, true, false);
		assertFalse(play.hasAllItems());
	}
}