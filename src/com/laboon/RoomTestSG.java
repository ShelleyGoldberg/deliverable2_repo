/* hasItem()
 * hasCream()
 * northExit()
 * getDescription()
 * public Room(boolean hasCoffee, 
				boolean hasCream, 
				boolean hasSugar,
				boolean northExit,
				boolean southExit)
 */
package com.laboon;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
public class RoomTestSG {

	@Test
	public void testWithCream() {
		Room room = new Room(false, true, false, false, false);
		assertTrue(room.hasCream());
	}
	
	@Test
	public void testWithoutCream() {
		Room room = new Room(true, false, true, true, true);
		assertFalse(room.hasCream());
	}
	
	@Test
	public void testNoNorthExit(){
		Room room = new Room(true, true, true, false, true);
		assertFalse(room.northExit());
	}
	
	@Test
	public void testNorthExit(){
		Room room = new Room(false, false, false, true, false);
		assertTrue(room.northExit());
	}
	
	@Test
	public void testNoItems(){
		Room room = new Room(false, false, false, false, false);
		assertFalse(room.hasItem());
	}
	
	@Test
	public void testOnlyCoffee(){
		Room room = new Room(true, false, false, false, false);
		assertTrue(room.hasItem());
	}
	@Test
	public void testOnlyCream(){
		Room room = new Room(false, true, false, false, false);
		assertTrue(room.hasItem());
	}
	@Test
	public void testOnlySugar(){
		Room room = new Room(false, false, true, false, false);
		assertTrue(room.hasItem());
	}
	
	/*@Test
	public void twoItems(){
		Room room = new Room(false, true, true, false, false);
		assertTrue(room.hasItem());
	}
	
	@Test
	public void hasAllItems(){
		Room room = new Room(true, true, true, false, false);
		assertTrue(room.hasItem());
	}*/
	
	@Test
	public void testDescrip(){
		//Room mockRoom= Mockito.mock(Room.class,"mockRoom" );
		//mockRoom.when(mockRoom.generateDescription());
		Room room = new Room(false, false, false, false, false);
		assertNotNull(room.getDescription());
		
	}
	
	

}
