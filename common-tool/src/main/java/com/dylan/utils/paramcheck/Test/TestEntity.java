package com.dylan.utils.paramcheck.Test;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/29 17:56
 */
@Data
@AllArgsConstructor
public class TestEntity {
	@Min(value = 1,message = "id最小为1")
	private int id;
	@NotNull(message = "用户名不能为空")
	private String name;
	@Email(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "邮箱格式不符合")
	private String email;
}
