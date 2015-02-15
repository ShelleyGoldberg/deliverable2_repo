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
	
	@Test
	public void testAllItems(){
		Player play = new Player(true, true, true);
		assertTrue(play.hasAllItems());
	}
	@Test
	public void testAllItemsDrink(){
		Player play = new Player(true, true, true);
		//Mockito.doNothing().when(play).showInventory();
		assertTrue(play.drink());		
	}
	@Test
	public void testNoItemsDrink() {
		Player play= new Player(true, true, true);
		assertTrue(play.hasAllItems());
	}
	
	@Test
	public void testNoSugarDrink() {
		Player play= new Player(false, true, true);
		assertFalse(play.hasAllItems());
	}
	
	@Test
	public void testNoCreamDrink() {
		Player play= new Player(true, false, true);
		assertFalse(play.hasAllItems());
	}
	@Test
	public void testNoCoffeeDrink() {
		Player play= new Player(true, true, false);
		assertFalse(play.hasAllItems());
	}
	
}