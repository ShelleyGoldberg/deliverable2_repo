/* Shelley Goldberg & Ryan McDonald
 * CS 1699 Deliverable 2
 * Unit tests for Player.java
 */
package com.laboon;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class PlayerTestSG {

	//hasAllItems() should return false if the player
	//does not have all of the items. 
	//Create a player with no items and assert that hasAllItems() is false
	@Test
	public void testNoItems() {
		Player play= new Player(false, false, false);
		assertFalse(play.hasAllItems());
	}
	//hasAllItems() should return false if the player
	//does not have all of the items. 
	//Create a player missing only sugar and assert that hasAllItems() is false
	@Test
	public void testNoSugar() {
		Player play= new Player(false, true, true);
		assertFalse(play.hasAllItems());
	}
	//Create a player missing only cream and assert that hasAllItems() is false
	@Test
	public void testNoCream() {
		Player play= new Player(true, false, true);
		assertFalse(play.hasAllItems());
	}
	//Create a player missing only coffee and assert that hasAllItems() is false
	@Test
	public void testNoCoffee() {
		Player play= new Player(true, true, false);
		assertFalse(play.hasAllItems());
	}
	//hasAllItems() should return true if the player has all of the items
	//Create a player with all of the items and assert that hasAllItems() is true
	@Test
	public void testAllItems(){
		Player play = new Player(true, true, true);
		assertTrue(play.hasAllItems());
	}
	//drink() should return true if the the player has all of the items,
	//the player wins(true) if it has all items and loses(false) if not
	//Create a player with all items and assert that drink() is true
	@Test
	public void testAllItemsDrink(){
		Player play = new Player(true, true, true);
		assertTrue(play.drink());		
	}
	//Create a player with no items and assert that drink() is false
	@Test
	public void testNoItemsDrink() {
		Player play= new Player(false, false, false);
		assertFalse(play.drink());
	}
	//Create a player missing only sugar and assert that drink() is false
	@Test
	public void testNoSugarDrink() {
		Player play= new Player(false, true, true);
		assertFalse(play.hasAllItems());
	}
	//Create a player missing only Cream and assert that drink() is false
	@Test
	public void testNoCreamDrink() {
		Player play= new Player(true, false, true);
		assertFalse(play.hasAllItems());
	}
	//Create a player missing only Coffee and assert that drink() is false
	@Test
	public void testNoCoffeeDrink() {
		Player play= new Player(true, true, false);
		assertFalse(play.hasAllItems());
	}
	
}