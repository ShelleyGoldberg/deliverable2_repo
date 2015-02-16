package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.*;
import org.mockito.stubbing.OngoingStubbing;

public class HouseTestRM {

	@Test
	/*
	 * Test that the creation of a House object is successful (not null)
	 */
	public void testHouseCreation()
	{
		House h = new House(10);
		assertNotNull(h);
		
	}//END testHouseCreation()
	
	@Test
	/*
	 * Test that the getCurrentRoomInfo() method appropriately calls the
	 * Room classes getDescription() method to return the rooms description
	 */
	public void testGetCurrentRoomInfo()
	{
		String test = "Did this work?";
		
		Room mockRoom = mock(Room.class);
		when(mockRoom.getDescription()).thenReturn(test);
		
		Room[] mockRooms = new Room[1];
		mockRooms[0] = mockRoom;
		
		House h = new House( mockRooms );
		
		assertTrue(test.equals(h.getCurrentRoomInfo()));
		
	}//END testGetCurrentRoomInfo()
	
	@Test
	/*
	 * Test that a Room in the House is not null or empty
	 */
	public void testCurrentRoomDescrNotNull()
	{
		//Room mockRoom = Mockito.mock(Room.class);
		House h = new House(10);
		assertNotNull(h.getCurrentRoomInfo());
		assertFalse(h.getCurrentRoomInfo().equals(""));
		
	}//END testCurrentRoomDescrNotNull()
	
	@Test
	/*
	 * Test that the generateRooms() method creates an array of Rooms
	 */
	public void testGenRoomCreatesRooms()
	{
		House h = new House(1);
		
		Room[] rooms = h.generateRooms(8);
		
		assertNotNull(rooms);	
		
	}//testGenRoomCreatesRooms()
	
	@Test
	/*
	 * Test that the specified number of Rooms to create via the House
	 * constructor successfully creates the specified number of Rooms
	 */
	public void testGenRoomCreatesTenRooms()
	{
		House h = new House(1);
		
		int numOfRooms = 10;
		Room[] rooms = h.generateRooms(numOfRooms);
		
		assertEquals(rooms.length, numOfRooms);
				
	}//END testGenRoomCreatesEightRooms()
	
	@Test
	/*
	 * Test that Houses are created with
	 */
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
	
	@Test
	/*
	 * Test that the current Room is different from previous room after
	 * moving North by looking at its description.
	 */
	public void testDifferentRoomAfterMoveNorth()
	{
		Room mockOrigin = mock(Room.class);
		Room mockNorth1 = mock(Room.class);
		Room mockNorth2 = mock(Room.class);
		
		String s_start = "Origin";
		String s_north1 = "Room 1";
		String s_north2 = "Room 2";
		
		when(mockOrigin.getDescription()).thenReturn(s_start);
		when(mockNorth1.getDescription()).thenReturn(s_north1);
		when(mockNorth2.getDescription()).thenReturn(s_north2);
		
		Room[] mockRooms = { mockOrigin, mockNorth1, mockNorth2 };
		
		House h = new House( mockRooms );
		
		assertEquals(h.getCurrentRoomInfo(), s_start);
		
		h.moveNorth();
		
		assertEquals(h.getCurrentRoomInfo(), s_north1);
		
		h.moveNorth();
		
		assertEquals(h.getCurrentRoomInfo(), s_north2);
		
	}//END testDifferentRoomAfterMoveNorth()
	
	@Test
	/*
	 * Test that the current Room is different from previous room after
	 * moving South by looking at its description.
	 */
	public void testDifferentRoomAfterMoveSouth()
	{
		House h = new House(5);
		
		String roomDesc1 = h.getCurrentRoomInfo();
		
		h.moveSouth();
		
		String roomDesc2 = h.getCurrentRoomInfo();
		
		assertFalse(roomDesc1.equals(roomDesc2));
		
	}//END testDifferentRoomAfterMoveSouth()
	
	
	@Test
	/*
	 * Test that the North-most Room has no North exit and that the 
	 * South-most Room has no South exit but can still move toward
	 * center of House.
	 */
	public void testDoorsAtEdgeOfHouse()
	{
		House h = new House(5);
		
		int numOfRooms = 10;
		
		Room[] rooms = h.generateRooms(numOfRooms);
		
		//Check North
		assertTrue(rooms[0].northExit());
		assertFalse(rooms[0].southExit());
		
		//Check South
		assertFalse(rooms[numOfRooms - 1].northExit());
		assertTrue(rooms[numOfRooms - 1].southExit());
		
	}//END testDoorsAtEdgeOfHouse()
	
	@Test
	/*
	 * Test that that the the Room traveled to when passing through 
	 * a non-existent South door is handled appropriately.
	 */
	public void testDescriptionWhenNoSouthDoor()
	{
		House h = new House(3);
		
		Room[] rooms = h.generateRooms(3);
		h = new House(rooms);
		
		//Valid origin
		assertEquals(rooms[0].getDescription(), h.getCurrentRoomInfo());
		
		h.moveSouth();
		
		//Fell off map
		assertTrue(h.getCurrentRoomInfo().contains("You are in a magical land!"));
		
		//Returned to origin
		assertEquals(rooms[0].getDescription(), h.getCurrentRoomInfo());
	}
	
	@Test
	/*
	 * Test that that the the Room traveled to when passing through 
	 * a non-existent North door is handled appropriately.
	 */
	public void testDescriptionWhenNoNorthDoor()
	{		
		int numOfRooms = 3;
		House h = new House(numOfRooms);

		Room[] rooms = h.generateRooms(numOfRooms);
		h = new House(rooms);
		
		h.moveNorth();
		h.moveNorth();
		
		//Valid last room
		assertEquals(rooms[numOfRooms - 1].getDescription(), h.getCurrentRoomInfo());
		
		h.moveNorth();
		
		//Fell off map
		assertTrue(h.getCurrentRoomInfo().contains("You are in a magical land!"));
		
		//Returned to origin
		assertEquals(rooms[0].getDescription(), h.getCurrentRoomInfo());
	}
	
	@Test
	/*
	 * Test if look() method calls appropriate methods when evaluating.
	 */
	public void testLookIfRoomHasItems()
	{
		Player mockPlayer = mock(Player.class);
		Room mockRoom = mock(Room.class);
		when(mockRoom.hasItem()).thenReturn(true);
		when(mockRoom.hasCoffee()).thenReturn(true);
		when(mockRoom.hasCream()).thenReturn(true);
		when(mockRoom.hasSugar()).thenReturn(true);
		
		Room [] mockRooms = { mockRoom };
		House h = new House( mockRooms );
		
		h.look(mockPlayer, mockRooms[0]);
		
		verify(mockPlayer).getCoffee();
		verify(mockPlayer).getCream();
		verify(mockPlayer).getSugar();
	}//END test
	
	@Test
	/*
	 * Test that look() method acts appropriately when user has no 
	 * items. 
	 */
	public void testLookIfRoomHasNoItems()
	{
		Player mockPlayer = mock(Player.class);
		Room mockRoom = mock(Room.class);
		when(mockRoom.hasItem()).thenReturn(false);
		when(mockRoom.hasCoffee()).thenReturn(true);
		when(mockRoom.hasCream()).thenReturn(true);
		when(mockRoom.hasSugar()).thenReturn(true);
		
		Room [] mockRooms = { mockRoom };
		House h = new House( mockRooms );
		
		h.look(mockPlayer, mockRooms[0]);
		
		verify(mockPlayer, never()).getCoffee();
		verify(mockPlayer, never()).getCream();
		verify(mockPlayer, never()).getSugar();
	}//END testLookIfRoomHasNoItems()
	
	@Test
	/*
	 * Test that look() method acts appropriately if Room is null.
	 */
	public void testLookIfRoomIsNull()
	{
		Player mockPlayer = mock(Player.class);
		Room mockRoom = mock(Room.class);
		when(mockRoom.hasItem()).thenReturn(false);
		
		Room [] mockRooms = { mockRoom };
		House h = new House(mockRooms);
		
		h.look(mockPlayer, null);
		
		verify(mockRoom, times(1)).hasItem();
		
	}//END testLookIfRoomIsNull()
	
}