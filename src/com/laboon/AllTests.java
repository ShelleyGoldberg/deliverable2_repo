package com.laboon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GameTest.class, HouseTest.class, PlayerTest.class,
		RoomTest.class, CoffeeMakerTest.class })
public class AllTests {

}
