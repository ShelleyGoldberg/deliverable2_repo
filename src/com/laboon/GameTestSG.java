package com.laboon;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
public class GameTestSG {

	@Mock
	//LinkedList<Integer> mockedLinkedList = Mockito.mock(LinkedList.class);
	Player mockPlay= Mockito.mock(Player.class);
	House mockHouse= Mockito.mock(House.class);
	Game game;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockPlay);
		MockitoAnnotations.initMocks(mockHouse);
		game= new Game(mockPlay, mockHouse);
		// If you use @Mock, you need to do this
		//MockitoAnnotations.initMocks(mockedLinkedList);
		
	}
	@Test
	public void testCapNReturn() {
		Mockito.doNothing().when(mockHouse).moveNorth();
		assertEquals(0,game.doSomething("N"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallNReturn() {
		Mockito.doNothing().when(mockHouse).moveNorth();
		assertEquals(0,game.doSomething("n"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallNCall(){
		Mockito.doNothing().when(mockHouse).moveNorth();
		game.doSomething("n");
		Mockito.verify(mockHouse).moveNorth();		
	}
	@Test
	public void testCapNCall(){
		Mockito.doNothing().when(mockHouse).moveNorth();
		game.doSomething("N");
		Mockito.verify(mockHouse).moveNorth();				
	}
	
	@Test
	public void testCapSReturn() {
		Mockito.doNothing().when(mockHouse).moveSouth();
		assertEquals(0,game.doSomething("S"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallSReturn() {
		Mockito.doNothing().when(mockHouse).moveSouth();
		assertEquals(0,game.doSomething("s"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallSCall(){
		Mockito.doNothing().when(mockHouse).moveSouth();
		game.doSomething("s");
		Mockito.verify(mockHouse).moveSouth();		
	}
	@Test
	public void testCapSCall(){
		Mockito.doNothing().when(mockHouse).moveSouth();
		game.doSomething("S");
		Mockito.verify(mockHouse).moveSouth();				
	}
	@Test
	public void testCapLReturn() {
		Mockito.doNothing().when(mockHouse).look(null,null);
		assertEquals(0,game.doSomething("L"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallLReturn() {
		Mockito.doNothing().when(mockHouse).look(null,null);
		assertEquals(0,game.doSomething("l"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallLCall(){
		Mockito.doNothing().when(mockHouse).look(mockPlay,null);
		game.doSomething("l");
		Mockito.verify(mockHouse).look(null,null);		
	}
	@Test
	public void testCapLCall(){
		Mockito.doNothing().when(mockHouse).look(null,null);
		game.doSomething("L");
		Mockito.verify(mockHouse).look(null,null);				
	}
	
	
	@Test
	public void testCapIReturn() {
		Mockito.doNothing().when(mockPlay).showInventory();
		assertEquals(0,game.doSomething("I"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallIReturn() {
		Mockito.doNothing().when(mockPlay).showInventory();
		assertEquals(0,game.doSomething("i"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallICall(){
		Mockito.doNothing().when(mockPlay).showInventory();
		game.doSomething("i");
		Mockito.verify(mockPlay).showInventory();		
	}
	@Test
	public void testCapICall(){
		Mockito.doNothing().when(mockPlay).showInventory();
		game.doSomething("I");
		Mockito.verify(mockPlay).showInventory();				
	}
	
	@Test
	public void testCapDReturnWin() {
		Mockito.doReturn(true).when(mockPlay).drink();
		assertEquals(1,game.doSomething("D"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallDReturnLose() {
		Mockito.doReturn(false).when(mockPlay).drink();
		assertEquals(-1,game.doSomething("d"));
		//fail("Not yet implemented");
	}
	@Test
	public void testSmallDCall(){
		Mockito.doReturn(true).when(mockPlay).drink();
		game.doSomething("d");
		Mockito.verify(mockPlay).drink();		
	}
	@Test
	public void testCapDCall(){
		Mockito.doReturn(true).when(mockPlay).drink();
		game.doSomething("D");
		Mockito.verify(mockPlay).drink();				
	}

}
