/* Shelley Goldberg & Ryan McDonald
 * CS 1699 Deliverable 2
 * Unit tests for Game.java
 */
package com.laboon;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
public class GameTestSG {

	//create mocks for Player and House to remove dependencies in Game
	@Mock	
	Player mockPlay= Mockito.mock(Player.class);
	House mockHouse= Mockito.mock(House.class);
	Game game;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockPlay);
		MockitoAnnotations.initMocks(mockHouse);
		game= new Game(mockPlay, mockHouse);		
	}
	//The command N should return 0 when passed to Game
	//Create a Game object with mocked Player and House objects
	//Assert that doSomething returns 0 when N is entered
	@Test
	public void testCapNReturn() {
		Mockito.doNothing().when(mockHouse).moveNorth();
		assertEquals(0,game.doSomething("N"));		
	}
	//The game should be case-insensitive for accepted commands
	//Create A Game object with mocked Player and House objects
	//Assert that doSomething returns 0 when lower-case n is entered
	@Test
	public void testSmallNReturn() {
		Mockito.doNothing().when(mockHouse).moveNorth();
		assertEquals(0,game.doSomething("n"));
		 
	}
	//The game should call moveNorth when doSomething() is called
	//with the N command. 
	//The game should be case-insensitive and call moveNorth when "n" is passed
	//Create A Game object with mocked Player and House objects
	//Verify that doSomething calls House.moveNorth() when lower-case n is entered
	@Test
	public void testSmallNCall(){
		Mockito.doNothing().when(mockHouse).moveNorth();
		game.doSomething("n");
		Mockito.verify(mockHouse).moveNorth();		
	}
	//The game should call moveNorth when doSomething() is called
	//with the N command. 
	//Create A Game object with mocked Player and House objects
	//Verify that doSomething calls House.moveNorth() when N is entered
	@Test
	public void testCapNCall(){
		Mockito.doNothing().when(mockHouse).moveNorth();
		game.doSomething("N");
		Mockito.verify(mockHouse).moveNorth();				
	}
	//The command S should return 0 when passed to Game
	//Create a Game object with mocked Player and House objects
	//Assert that doSomething returns 0 when S is entered
	@Test
	public void testCapSReturn() {
		Mockito.doNothing().when(mockHouse).moveSouth();
		assertEquals(0,game.doSomething("S"));		 
	}
	//The game should be case-insensitive
	//Assert that doSomething returns 0 when lower-case s is entered
	@Test
	public void testSmallSReturn() {
		Mockito.doNothing().when(mockHouse).moveSouth();
		assertEquals(0,game.doSomething("s"));		 
	}
	
	//The game should be case-insensitive and call moveSouth when "s" is passed
	//Create A Game object with mocked Player and House objects
	//verify that doSomething calls House.moveSouth() when lower-case s is entered
	@Test
	public void testSmallSCall(){
		Mockito.doNothing().when(mockHouse).moveSouth();
		game.doSomething("s");
		Mockito.verify(mockHouse).moveSouth();		
	}
	//The game should be case-insensitive and call moveSouth when "S" is passed
	//Create A Game object with mocked Player and House objects
	//verify that doSomething calls House.moveSouth() when Capital S is entered
	@Test
	public void testCapSCall(){
		Mockito.doNothing().when(mockHouse).moveSouth();
		game.doSomething("S");
		Mockito.verify(mockHouse).moveSouth();				
	}
	//The command L should return 0 when passed to Game
	//Create a Game object with mocked Player and House objects
	//Assert that doSomething returns 0 when L is entered
	@Test
	public void testCapLReturn() {
		Mockito.doNothing().when(mockHouse).look(null,null);
		assertEquals(0,game.doSomething("L"));		 
	}
	//The game should be case-insensitive
	//Assert that doSomething returns 0 when lower-case l is entered
	@Test
	public void testSmallLReturn() {
		Mockito.doNothing().when(mockHouse).look(null,null);
		assertEquals(0,game.doSomething("l"));		 
	}
	//The game should be case-insensitive and call look when "l" is passed
	//Create A Game object with mocked Player and House objects
	//verify that doSomething calls House.look() when lower-case l is entered
	@Test
	public void testSmallLCall(){
		Mockito.doNothing().when(mockHouse).look(mockPlay,null);
		game.doSomething("l");
		Mockito.verify(mockHouse).look(null,null);		
	}
	//The game should be case-insensitive and call look when "L" is passed
	//Create A Game object with mocked Player and House objects
	//verify that doSomething calls House.look() when Capital L is entered
	@Test
	public void testCapLCall(){
		Mockito.doNothing().when(mockHouse).look(null,null);
		game.doSomething("L");
		Mockito.verify(mockHouse).look(null,null);				
	}	
	//The command I should return 0 when passed to Game
	//Create a Game object with mocked Player and House objects
	//Assert that doSomething returns 0 when I is entered
	@Test
	public void testCapIReturn() {
		Mockito.doNothing().when(mockPlay).showInventory();
		assertEquals(0,game.doSomething("I"));		 
	}
	//The game should be case-insensitive
	//Assert that doSomething returns 0 when lower-case i is entered
	@Test
	public void testSmallIReturn() {
		Mockito.doNothing().when(mockPlay).showInventory();
		assertEquals(0,game.doSomething("i"));		 
	}
	//The game should be case-insensitive and call showInventory when "i" is passed
	//Create A Game object with mocked Player and House objects
	//verify that doSomething calls Player.showInventory() when lower-case i is entered
	@Test
	public void testSmallICall(){
		Mockito.doNothing().when(mockPlay).showInventory();
		game.doSomething("i");
		Mockito.verify(mockPlay).showInventory();		
	}
	//The game should be case-insensitive and call showInventory when "I" is passed
	//Create A Game object with mocked Player and House objects
	//verify that doSomething calls Player.showInventory() when capital I is entered
	@Test
	public void testCapICall(){
		Mockito.doNothing().when(mockPlay).showInventory();
		game.doSomething("I");
		Mockito.verify(mockPlay).showInventory();				
	}
	//The command D should return 1 when passed to Game with a player has all items
	//Create a Game object with mocked Player and House objects
	//Stub Player.drink() to return true when called in doSomething
	//Assert that doSomething returns 1 when I is entered
	@Test
	public void testCapDReturnWin() {
		Mockito.doReturn(true).when(mockPlay).drink();
		assertEquals(1,game.doSomething("D"));
		 
	}
	//The command D should return -1 when passed to Game with a player doesn't have all items
	//The game should be case insensitive and accept lower-case "d"
	//Create a Game object with mocked Player and House objects
	//Stub Player.drink() to return false when called in doSomething
	//Assert that doSomething returns -1 when I is entered
	@Test
	public void testSmallDReturnLose() {
		Mockito.doReturn(false).when(mockPlay).drink();
		assertEquals(-1,game.doSomething("d"));
		 
	}
	//The game should be case-insensitive and call drink() when "d" is passed
	//Create A Game object with mocked Player and House objects
	//verify that doSomething() calls Player.drink when lower-case d is entered
	@Test
	public void testSmallDCall(){
		Mockito.doReturn(true).when(mockPlay).drink();
		game.doSomething("d");
		Mockito.verify(mockPlay).drink();		
	}
	//The game should be case-insensitive and call drink() when "D" is passed
	//Create A Game object with mocked Player and House objects
	//verify that doSomething() calls Player.drink when capital D is entered
	@Test
	public void testCapDCall(){
		Mockito.doReturn(true).when(mockPlay).drink();
		game.doSomething("D");
		Mockito.verify(mockPlay).drink();				
	}

}
