package org.google.guava.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class MultiMapTest {

	@Test
	public void testMap() {
		Multimap<String, String> map = HashMultimap.create();
		assertEquals(0, map.size());
		Map<String, Collection<String>> reallyMap = map.asMap();
		assertNotNull(reallyMap);
		assertEquals(0, reallyMap.size());
		map.put("中国工商银行", "北京总行软开");
		map.put("中国工商银行", "北京国贸支行");
		map.put("中国工商银行", "北京安河桥支行");
		map.put("中国工商银行", "北京上地支行");
		map.put("兴业银行", "兴业银行北京总行");
		map.put("兴业银行", "山东济南历山支行");
		map.put("兴业银行", "山东济南历城支行");
		map.put("兴业银行", "山东青岛四方支行");
		map.put("中国建设银行", "建行行北京总行");
		map.put("中国建设银行", "湖北武昌支行");
		map.put("中国建设银行", "湖北汉口支行");
		map.put("中国建设银行", "湖北孝感支行");
		map.put("中国建设商行", "建行行北京商行");
		map.put("中国建设商行", "湖北武昌商行");
		map.put("中国建设商行", "湖北汉口商行");
		map.put("中国建设商行", "湖北孝感商行");
		assertNotNull(map);
		assertEquals(16, map.size());
		System.out.println(map);
		assertTrue(map.containsKey("中国建设银行"));
		assertTrue(map.containsKey("中国建设商行"));
		assertTrue(map.containsKey("兴业银行"));
		assertTrue(map.containsKey("中国工商银行"));
		assertTrue(map.containsValue("湖北汉口支行"));
		assertTrue(!map.containsKey("ABC"));
		assertTrue(!map.containsValue("abc"));
		assertTrue(map.containsEntry("中国建设商行", "湖北孝感商行"));
		assertTrue(!map.containsEntry("1中国建设商行", "湖北孝感商行"));
		assertTrue(!map.containsEntry("中国建设商行", "1湖北孝感商行"));
		Set<String> set = map.keySet();
		assertEquals(4, set.size());
		List<String> list = Lists.newArrayList();
		for (String key : set) {
			Collection<String> collection = map.get(key);
			list.addAll(collection);
			assertNotNull(collection);
			assertEquals(4, collection.size());
			System.out.println("key==" + key + ",value==" + collection);
		}
		Collection<String> collection = map.values();
		assertNotNull(collection);
		assertEquals(16, collection.size());
		for (String value : collection) {
			assertTrue(list.contains(value));
		}
		System.out.println(map.asMap().getClass());
		Collection<String> collectionFilter = Collections2.filter(collection,
				new Predicate<String>() {
					@Override
					public boolean apply(String str) {
						return str.contains("山东");
					}
				});
		Collection<String> c = map.get(null);
		assertNotNull(c);
		assertEquals(0, c.size());
		c = map.get("兴业银行");
		assertNotNull(c);
		assertEquals(4, c.size());
		System.out.println(c);
		c = map.get("兴业银行1");
		assertNotNull(c);
		assertEquals(0, c.size());
		assertTrue(collection.size() != collectionFilter.size());
		assertEquals(3, collectionFilter.size());
		map.clear();
		assertNotNull(map);
		assertEquals(0, map.size());
	}

	@Test
	public void testMap2() {
		// Multimap<String, Map<String, String>> map = HashMultimap.create();
		// assertNotNull(map);
		// assertEquals(0, map.size());
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		addToMap(map, "cib", "1004", "2");
		addToMap(map, "cib", "1005", "3");
		addToMap(map, "cib", "1006", "1");
		addToMap(map, "cib", "1007", "5");

		addToMap(map, "icbc", "1004", "2");
		addToMap(map, "icbc", "1005", "3");
		addToMap(map, "icbc", "1006", "1");
		addToMap(map, "icbc", "1007", "5");
		System.out.println(map);

	}

	private void addToMap(Map<String, Map<String, String>> map, String key,
			String name, String value) {
		if (map.containsKey(key)) {
			map.get(key).put(name, value);
		} else {
			Map<String, String> map1 = Maps.newHashMap();
			map1.put(name, value);
			map.put(key, map1);
		}
	}

}
