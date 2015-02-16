package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

import org.mockito.*;

public class RoomTestRM {
	
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
