package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.*;

public class HouseTestRM {

	@Test
	public void testHouseCreation()
	{
		House h = new House(10);
		assertNotNull(h);
	}
	
	@Test
	public void testCurrentRoomDescription()
	{
		//Room mockRoom = Mockito.mock(Room.class);
		House h = new House(10);
		assertNotNull(h.getCurrentRoomInfo());
		assertNotSame(h.getCurrentRoomInfo(), "");
	}
	
	@Test
	public void testGenRoomCreatesRooms()
	{
		House h = new House(1);
		
		Room[] rooms = h.generateRooms(8);
		
		assertNotNull(rooms);	
		
	}//testGenRoomCreatesRooms
	
	@Test
	public void testGenRoomCreatesEightRooms()
	{
		House h = new House(1);
		
		Room[] rooms = h.generateRooms(8);
		
		assertEquals(rooms.length, 8);
		
	}//END testGenRoomCreatesEightRooms()
	
	@Test
	public void testWinnableHouse()
	{
		boolean foundCoffee = false;
		boolean foundSugar = false;
		boolean foundCream = false;
		
		House h = new House(1);
		
		Room[] rooms = h.generateRooms(10);
		
		for(Room r : rooms)
		{
			if(r.hasCoffee()){ foundCoffee = true; }
			if(r.hasSugar()) { foundSugar = true; }
			if(r.hasCream()) { foundCream = true; }
		}
		
		assertTrue(foundCream);
		assertTrue(foundCoffee);
		assertTrue(foundSugar);
		
	}//END testWinnableLargeHouse()
	
	
	
	
}
