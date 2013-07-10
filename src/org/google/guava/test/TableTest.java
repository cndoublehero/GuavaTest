package org.google.guava.test;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableTest {

	@Test
	public void testTable() {
		Table<String, String, String> table = HashBasedTable.create();
		table.put("cib", "1004", "2");
		table.put("cib", "1005", "3");
		table.put("cib", "1006", "1");
		table.put("cib", "1007", "5");

		table.put("icbc", "1004", "2");
		table.put("icbc", "1005", "3");
		table.put("icbc", "1006", "1");
		table.put("icbc", "1007", "5");

		assertEquals(8, table.size());
		assertTrue(table.containsRow("cib"));
		Set<String> set = table.rowKeySet();
		assertNotNull(set);
		assertEquals(2, set.size());
		assertTrue(set.contains("cib"));
		assertTrue(set.contains("icbc"));
		assertTrue(!set.contains("1cib"));
		System.out.println(table);
		System.out.println(table.row("cib"));
		Map<String, Map<String, String>> map = table.rowMap();
		System.out.println(map);
	}
}
