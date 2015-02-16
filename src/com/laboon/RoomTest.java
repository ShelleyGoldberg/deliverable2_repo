/* Shelley Goldberg & Ryan McDonald
 * CS 1699 Deliverable 2
 * Unit tests for Room.java
 */
package com.laboon;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
public class RoomTest {

	//A room with cream should return true from hasCream()
	//Create a room object which only has cream and assert that hasCream() is true
	@Test
	public void testWithCream() {
		Room room = new Room(false, true, false, false, false);
		assertTrue(room.hasCream());
	}
	//Create a room object which all items except for cream and assert that hasCream() is false
	@Test
	public void testWithoutCream() {
		Room room = new Room(true, false, true, true, true);
		assertFalse(room.hasCream());
	}
	//A room with a North Exit should return ture from northExit()
	//Create an object without a north exit and assert northExit() returns false
	@Test
	public void testNoNorthExit(){
		Room room = new Room(true, true, true, false, true);
		assertFalse(room.northExit());
	}
	//Create an object with a north exit and assert northExit() returns true
	@Test
	public void testNorthExit(){
		Room room = new Room(false, false, false, true, false);
		assertTrue(room.northExit());
	}
	//A room with no items should return false from hasItem()
	//Create a room with no items and assert that hasItem() is false
	@Test
	public void testNoItems(){
		Room room = new Room(false, false, false, false, false);
		assertFalse(room.hasItem());
	}
	//A room object with any combination of items should return true
	//from hasItem()
	//Create a room with only coffee and assert that hasItem() is true
	@Test
	public void testOnlyCoffee(){
		Room room = new Room(true, false, false, false, false);
		assertTrue(room.hasItem());
	}
	//Create a room with only cream and assert that hasItem() is true
	@Test
	public void testOnlyCream(){
		Room room = new Room(false, true, false, false, false);
		assertTrue(room.hasItem());
	}
	//Create a room with only sugar and assert that hasItem() is true
	@Test
	public void testOnlySugar(){
		Room room = new Room(false, false, true, false, false);
		assertTrue(room.hasItem());
	}
	//A room should always have a description, made in generateDescription
	//when instantiated
	//Create a room and assert that there is a description returned, not null
	//The getDescription method itself only returns a private variable and is 
	//dependent on several private methods. 
	@Test
	public void testDescrip(){
		Room room = new Room(false, false, false, false, false);
		assertNotNull(room.getDescription());
		
	}
	
    @Test
	/*
	 * Test that Room object is created appropriately.
	 */
	public void testRoomCreation()
	{
		Room r = new Room(false, false, false, false, false);
		assertNotNull(r);		
		
	}//END testRoomCreation()
	
	@Test
	/*
	 * Test that a Room equals itself.
	 */
	public void testRoomEqualsRoom()
	{
		Room r = new Room(false, false, false, false, false);
		assertEquals(r, r);
		
	}//END testRoomEqualsRoom()
	
	@Test
	/*
	 * Test that a Room with sugar hasSugar().
	 */
	public void testWithSugar()
	{
		Room r = new Room(false, false, true, false, false);
		assertEquals(true, r.hasSugar());
		
	}//END testWithSugar()
	
	@Test
	/* 
	 * Test that a Room without Sugar !hasSugar().
	 */
	public void testWithoutSugar()
	{
		Room r = new Room(true, true, false, true, true);
		assertEquals(false, r.hasSugar());		
		
	}//END testWithoutSugar()
	
	@Test
	/*
	 * Test that a Room with Coffee hasCoffe().
	 */
	public void testWithCoffee()
	{
		Room r = new Room(true, false, false, false, false);
		assertEquals(true, r.hasCoffee());
		
	}//END testWithCoffee()
	
	@Test
	/*
	 * Test that a Room without Coffee !hasCoffee()
	 */
	public void testWithoutCoffee()
	{
		Room r = new Room(false, true, true, true, true);
		assertEquals(false, r.hasCoffee());
		
	}//END testWithoutCoffee()
	
	@Test
	/*
	 * Test that Room has south exit.
	 */
	public void testSouthExit()
	{
		Room r = new Room(false, false, false, false, true);
		assertEquals(true, r.southExit());
		
	}//END testSouthExit()
	
	@Test
	/*
	 * Test that Room without South exit has no South exit.
	 */
	public void testNoSouthExit()
	{
		Room r = new Room(true, true, true, true, false);
		assertEquals(false, r.southExit());		
		
	}//END testNoSouthExit()
	
	@Test
	/*
	 * Test description when North exit exists.
	 */
	public void testDescNorth()
	{
		Room r = new Room(false, false, false, true, false);
		assertTrue(r.getDescription().contains("door leads North"));	
		
	}//END testDescNorth()
	
	@Test
	/*
	 * Test description when South exit exists.
	 */
	public void testDescSouth()
	{
		Room r = new Room(false, false, false, false, true);
		assertTrue(r.getDescription().contains("door leads South"));
		
	}//END testDescSouth()
	
	@Test
	/*
	 * Test description when North and South exit exist.
	 */
	public void testDescNorthAndSouth()
	{
		Room r = new Room(false, false, false, true, true);
		assertTrue(r.getDescription().contains("door leads North"));
		assertTrue(r.getDescription().contains("door leads South"));
		
	}//END testDescNorthAndSouth()
	
	

}
