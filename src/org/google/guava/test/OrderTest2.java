package org.google.guava.test;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class OrderTest2 {
	@Test
	public void testOrder() {
		People pZhangsan = new People(1, "zhangsan", 30, "M", "湖北武汉");
		People pLisi = new People(2, "lisi", 20, "M", "湖北天门");
		People pLiying = new People(3, "liying", 29, "F", "首都北京");
		People pLaoMao = new People(4, "laomao", 27, "C", "湖北黄冈");
		List<People> list = Lists.newArrayList(pZhangsan, pLisi, pLiying,
				pLaoMao);
		assertNotNull(list);
		assertEquals(4, list.size());
		List<People> sortList = Ordering.natural().sortedCopy(list);
		assertNotNull(sortList);
		assertEquals(4, sortList.size());
		System.out.println(sortList);
		sortList = Ordering.natural()
				.onResultOf(new Function<People, String>() {
					@Override
					public String apply(People input) {
						return input.getName();
					}

				}).sortedCopy(list);
		assertNotNull(sortList);
		assertEquals(4, sortList.size());
		System.out.println(sortList);

		sortList = Ordering.natural()
				.onResultOf(new Function<People, Integer>() {
					@Override
					public Integer apply(People input) {
						return input.getAge();
					}

				}).sortedCopy(list);
		assertNotNull(sortList);
		assertEquals(4, sortList.size());
		System.out.println(sortList);
		sortList = Ordering.natural()
				.onResultOf(new Function<People, Integer>() {
					@Override
					public Integer apply(People input) {
						return input.getAge();
					}

				}).greatestOf(list, 2);
		assertNotNull(sortList);
		assertEquals(2, sortList.size());
		System.out.println(sortList);
		sortList = Ordering.natural()
				.onResultOf(new Function<People, Integer>() {
					@Override
					public Integer apply(People input) {
						return input.getAge();
					}

				}).leastOf(list, 2);
		assertNotNull(sortList);
		assertEquals(2, sortList.size());
		System.out.println(sortList);
		list.add(new People(5, "laoxu", 30, "M", "湖北黄冈"));
		list.add(new People(6, "laoli", 29, "M", "湖北黄冈"));
		sortList = Ordering
				.natural()
				.onResultOf(new Function<People, Integer>() {
					@Override
					public Integer apply(People input) {
						return input.getAge();
					}
				})
				.compound(
						Ordering.natural().onResultOf(
								new Function<People, String>() {
									@Override
									public String apply(People input) {
										return input.getName();
									}

								})).greatestOf(list, 20);
		assertNotNull(sortList);
		assertEquals(6, sortList.size());
		System.out.println(sortList);
		sortList = Ordering
				.natural()
				.reverse()
				.onResultOf(new Function<People, Integer>() {
					@Override
					public Integer apply(People input) {
						return input.getAge();
					}
				})
				.compound(
						Ordering.natural().reverse()
								.onResultOf(new Function<People, String>() {
									@Override
									public String apply(People input) {
										return input.getName();
									}

								})).greatestOf(list, 20);
		assertNotNull(sortList);
		assertEquals(6, sortList.size());
		System.out.println(sortList);
	}
}
