package com.dan.web.controller;

import com.dan.dto.User;
import com.dan.dto.UserQueryCondition;
import com.dan.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by dangao on 3/5/2019.
 */

@RestController
@RequestMapping("/user")
public class UserController
{

	@PostMapping
	@ApiOperation(value = "创建用户服务")
	public User create(@Valid @RequestBody User user, BindingResult errors)
	{
		if(errors.hasErrors())
		{
			errors.getAllErrors().stream().forEach(e -> System.out.println(e.getDefaultMessage()));
		}
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthDay());
		user.setId("1");
		return user;
	}

	@DeleteMapping("/{id:\\d+}")
	public void delete(@ApiParam("用户Id") @PathVariable String id)
	{
		System.out.println(id);
	}

	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user, BindingResult errors)
	{
		if(errors.hasErrors())
		{
			errors.getAllErrors().stream().forEach(e -> System.out.println(e.getDefaultMessage()));
		}
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthDay());
		user.setId("1");
		return user;
	}

	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQueryCondition condition, @PageableDefault(size = 12, page = 2, sort={"age","desc"}) Pageable pageable)
	{
		List<User> users = new ArrayList<>();
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}

	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable String id){
//		throw new UserNotExistException("1");
		User user = new User();
		user.setName("tom");
		return user;
	}
}
