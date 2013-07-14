package org.google.guava.test;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class OrderTest {

	@Test
	public void test1() {
		List<String> list = Lists.newArrayList("1zhangsan", "2lisi", "4wangwu",
				"3zhaoliu");
		assertNotNull(list);
		assertEquals(4, list.size());
		assertEquals("1zhangsan", list.get(0));
		assertEquals("2lisi", list.get(1));
		assertEquals("4wangwu", list.get(2));
		assertEquals("3zhaoliu", list.get(3));
		List<String> sortList = Ordering.natural().sortedCopy(list);

		assertNotNull(list);
		assertEquals(4, list.size());
		assertEquals("1zhangsan", list.get(0));
		assertEquals("2lisi", list.get(1));
		assertEquals("4wangwu", list.get(2));
		assertEquals("3zhaoliu", list.get(3));

		assertNotNull(sortList);
		assertEquals(4, sortList.size());
		assertEquals("1zhangsan", sortList.get(0));
		assertEquals("2lisi", sortList.get(1));
		assertEquals("3zhaoliu", sortList.get(2));
		assertEquals("4wangwu", sortList.get(3));

		sortList = Ordering.natural().reverse().sortedCopy(list);

		assertNotNull(list);
		assertEquals(4, list.size());
		assertEquals("1zhangsan", list.get(0));
		assertEquals("2lisi", list.get(1));
		assertEquals("4wangwu", list.get(2));
		assertEquals("3zhaoliu", list.get(3));

		assertNotNull(sortList);
		assertEquals(4, sortList.size());
		assertEquals("1zhangsan", sortList.get(3));
		assertEquals("2lisi", sortList.get(2));
		assertEquals("3zhaoliu", sortList.get(1));
		assertEquals("4wangwu", sortList.get(0));

		sortList = (List<String>) Ordering.natural()
				.onResultOf(Functions.toStringFunction()).sortedCopy(list);

		assertNotNull(list);
		assertEquals(4, list.size());
		assertEquals("1zhangsan", list.get(0));
		assertEquals("2lisi", list.get(1));
		assertEquals("4wangwu", list.get(2));
		assertEquals("3zhaoliu", list.get(3));

		assertNotNull(sortList);
		assertEquals(4, sortList.size());
		assertEquals("1zhangsan", sortList.get(0));
		assertEquals("2lisi", sortList.get(1));
		assertEquals("3zhaoliu", sortList.get(2));
		assertEquals("4wangwu", sortList.get(3));

		sortList = (List<String>) Ordering.natural()
				.onResultOf(new Function<String, String>() {
					@Override
					public String apply(String input) {
						if (!Strings.isNullOrEmpty(input)) {
							return input.substring(1);
						}
						return null;
					}
				}).sortedCopy(list);

		assertNotNull(list);
		assertEquals(4, list.size());
		assertEquals("1zhangsan", list.get(0));
		assertEquals("2lisi", list.get(1));
		assertEquals("4wangwu", list.get(2));
		assertEquals("3zhaoliu", list.get(3));

		assertNotNull(sortList);
		assertEquals(4, sortList.size());
		assertEquals("2lisi", sortList.get(0));
		assertEquals("4wangwu", sortList.get(1));
		assertEquals("1zhangsan", sortList.get(2));
		assertEquals("3zhaoliu", sortList.get(3));

		sortList = (List<String>) Ordering.natural()
				.onResultOf(new Function<String, String>() {
					@Override
					public String apply(String input) {
						if (!Strings.isNullOrEmpty(input)) {
							return input.substring(1);
						}
						return null;
					}
				}).onResultOf(new Function<String, String>() {
					@Override
					public String apply(String input) {
						if (!Strings.isNullOrEmpty(input)) {
							return input.substring(2);
						}
						return null;
					}
				}).sortedCopy(list);

		assertNotNull(list);
		assertEquals(4, list.size());
		assertEquals("1zhangsan", list.get(0));
		assertEquals("2lisi", list.get(1));
		assertEquals("4wangwu", list.get(2));
		assertEquals("3zhaoliu", list.get(3));

		assertNotNull(sortList);
		System.out.println(sortList);
		assertEquals(4, sortList.size());
		// from this we can see the onResultOf method will be combine together
		assertEquals("1zhangsan", sortList.get(0));
		assertEquals("3zhaoliu", sortList.get(1));
		assertEquals("4wangwu", sortList.get(2));
		assertEquals("2lisi", sortList.get(3));

		sortList = (List<String>) Ordering.natural()
				.onResultOf(new Function<String, String>() {
					@Override
					public String apply(String input) {
						if (!Strings.isNullOrEmpty(input)) {
							return input.substring(2);
						}
						return null;
					}
				}).onResultOf(new Function<String, String>() {
					@Override
					public String apply(String input) {
						if (!Strings.isNullOrEmpty(input)) {
							return input.substring(1);
						}
						return null;
					}
				}).sortedCopy(list);

		assertNotNull(list);
		assertEquals(4, list.size());
		assertEquals("1zhangsan", list.get(0));
		assertEquals("2lisi", list.get(1));
		assertEquals("4wangwu", list.get(2));
		assertEquals("3zhaoliu", list.get(3));

		assertNotNull(sortList);
		System.out.println(sortList);
		assertEquals(4, sortList.size());
		// from this we can see the onResultOf method will be combine together
		assertEquals("1zhangsan", sortList.get(0));
		assertEquals("3zhaoliu", sortList.get(1));
		assertEquals("4wangwu", sortList.get(2));
		assertEquals("2lisi", sortList.get(3));

	}
}
