package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

import org.mockito.*;

public class RoomTestRM {
	
	@Test
	public void testRoomCreation()
	{
		Room r = new Room(false, false, false, false, false);
		assertNotNull(r);		
	}
	
	@Test
	public void testRoomEqualsRoom()
	{
		Room r = new Room(false, false, false, false, false);
		assertEquals(r, r);
	}
	
	@Test
	public void testWithSugar()
	{
		Room r = new Room(false, false, true, false, false);
		assertEquals(true, r.hasSugar());
	}
	
	@Test
	public void testWithoutSugar()
	{
		Room r = new Room(true, true, false, true, true);
		assertEquals(false, r.hasSugar());		
	}
	
	@Test
	public void testWithCoffee()
	{
		Room r = new Room(true, false, false, false, false);
		assertEquals(true, r.hasCoffee());
	}
	
	@Test
	public void testWithoutCoffee()
	{
		Room r = new Room(false, true, true, true, true);
		assertEquals(false, r.hasCoffee());
	}
	
	@Test
	public void testSouthExit()
	{
		Room r = new Room(false, false, false, false, true);
		assertEquals(true, r.southExit());
	}
	
	@Test
	public void testNoSouthExit()
	{
		Room r = new Room(true, true, true, true, false);
		assertEquals(false, r.southExit());		
	}
	
	@Test
	public void testDescNorth()
	{
		Room r = new Room(false, false, false, true, false);
		assertTrue(r.getDescription().contains("door leads North"));		
	}
	
	@Test
	public void testDescSouth()
	{
		Room r = new Room(false, false, false, false, true);
		assertTrue(r.getDescription().contains("door leads South"));
	}
	
	@Test
	public void testDescNorthAndSouth()
	{
		Room r = new Room(false, false, false, true, true);
		assertTrue(r.getDescription().contains("door leads North"));
		assertTrue(r.getDescription().contains("door leads South"));
	}
	
}
