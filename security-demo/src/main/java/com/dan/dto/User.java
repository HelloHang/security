package com.dan.dto;

import com.dan.validator.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;


/**
 * Created by dangao on 3/5/2019.
 */
public class User
{
	public interface  UserSimpleView{}
	public interface  UserDetailView extends UserSimpleView{}

	private String id;

	@MyConstraint(message = "这是一个测试")
	private String name;
	@NotBlank(message = "密码不能为空")
	private String password;

	@Past(message = "生日不能是未来日期")
	@ApiModelProperty(value = "用户生日")
	private Date birthDay;

	@JsonView(UserSimpleView.class)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@JsonView(UserDetailView.class)
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@JsonView(UserSimpleView.class)
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@JsonView(UserSimpleView.class)
	public Date getBirthDay()
	{
		return birthDay;
	}

	public void setBirthDay(Date birthDay)
	{
		this.birthDay = birthDay;
	}

}
