package com.lj.toyrobot.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lj.toyrobot.model.Table;

public class TableTest {
	
	private Table table;
	
	@Before
	public void setup() {
		table = new Table(5,5);
	}
	
	@Test
	public void isWithinBounds_with_correct_values() {
		assertEquals(true, table.isWithinBounds(0, 0));
		assertEquals(true, table.isWithinBounds(4, 4));
	}
	
	@Test
	public void isWithinBounds_with_lessthan_min_x() {
		assertEquals(false, table.isWithinBounds(-1, 0));
	}
	
	@Test
	public void isWithinBounds_with_greaterthan_max_x() {
		assertEquals(false, table.isWithinBounds(5, 0));
	}
	
	@Test
	public void isWithinBounds_with_lessthan_min_y() {
		assertEquals(false, table.isWithinBounds(0, -1));
	}
	
	@Test
	public void isWithinBounds_with_greaterthan_max_y() {
		assertEquals(false, table.isWithinBounds(0, 5));
	}

}
