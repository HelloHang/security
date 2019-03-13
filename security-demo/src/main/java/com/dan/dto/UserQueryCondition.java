package com.dan.dto;

/**
 * Created by dangao on 3/5/2019.
 */
public class UserQueryCondition
{
	private String name;

	private int age;

	private int ageTo;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getAgeTo()
	{
		return ageTo;
	}

	public void setAgeTo(int ageTo)
	{
		this.ageTo = ageTo;
	}
}
