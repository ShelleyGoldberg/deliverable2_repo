package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

import org.mockito.*;

public class RoomTestRM {
	
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
	
}
