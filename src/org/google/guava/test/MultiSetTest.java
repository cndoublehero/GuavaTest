package org.google.guava.test;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

public class MultiSetTest {
	@Test
	public void testSet() {
		Multiset<String> set = HashMultiset.create();
		assertEquals(0, set.size());
		set.add("appale");
		set.add("orange");
		set.add("banana");
		set.add("appale");
		assertEquals(4, set.size());
		assertTrue(set.contains("appale"));
		assertTrue(!set.contains("appales"));
		assertEquals(2, set.count("appale"));
		assertEquals(1, set.count("orange"));
		assertEquals(0, set.count("nothing"));
		set.add(null);
		assertEquals(5, set.size());
		set.add(null);
		assertEquals(6, set.size());
		set.clear();
		assertTrue(set.isEmpty());
		set.addAll(Lists.newArrayList("zhangsan", "lisi", "zhangsan", null));
		assertEquals(4, set.size());
		assertEquals(1, set.count(null));
		assertEquals(4, set.toArray().length);
		System.out.println(set);
		Set<String> keySet = set.elementSet();
		assertEquals(3, keySet.size());
		assertTrue(set.contains("zhangsan"));
		assertTrue(set.contains("lisi"));
		assertTrue(set.contains(null));
		for (String key : keySet) {
			System.out.println("key = " + key + ",count=" + set.count(key));
		}
		int count = 0;
		for (String value : set) {
			count++;
			System.out.println(value);
		}
		assertEquals(4, count);
		set.remove("zhangsan");
		assertEquals(3, set.size());
		assertEquals(1, set.count("zhangsan"));
		set.remove("zhangsan");
		assertEquals(2, set.size());
		assertEquals(0, set.count("zhangsan"));
		try {
			set.toArray(new Integer[10]);
			fail("cannot be executed here");
		} catch (Exception e) {
		}
	}
}
