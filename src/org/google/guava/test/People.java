package org.google.guava.test;

import com.google.common.base.Objects;

public class People implements Comparable<People> {
	@Override
	public int hashCode() {
		return Objects.hashCode(name, age, sex, address);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof People) {
			People pObject = (People) obj;
			return Objects.equal(this.userId, pObject.getUserId());
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper("people").add("name", name)
				.add("age", age).add("sex", sex).add("address", address)
				.toString();
	}

	private long userId;
	private String name;
	private int age;
	private String sex;
	private String address;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public People(long userId, String name, int age, String sex, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int compareTo(People o) {
		return (int) (this.userId - o.userId);
	}
}
