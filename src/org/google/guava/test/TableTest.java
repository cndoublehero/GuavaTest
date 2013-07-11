package org.google.guava.test;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Supplier;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

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
		Collections2.orderedPermutations(map.keySet());
		System.out.println(map);
	}

	@Test
	public void testTable2() {
		Table<String, String, String> table = Tables.newCustomTable(
				Maps.<String, Map<String, String>> newTreeMap(),
				new Supplier<Map<String, String>>() {
					@Override
					public Map<String, String> get() {
						return Maps.newHashMap();
					}
				});
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
		Collections2.orderedPermutations(map.keySet());
		System.out.println(map);
	}

}
