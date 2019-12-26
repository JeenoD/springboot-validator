package com.jeeno.springbootvalidator.pojo;

import com.jeeno.springbootvalidator.group.AddUserGroup;
import com.jeeno.springbootvalidator.group.DefaultGroup;
import com.jeeno.springbootvalidator.group.UpdateUserGroup;
import com.jeeno.springbootvalidator.validator.AddUserValidator;
import com.jeeno.springbootvalidator.validator.UpdateUserValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 15:45
 */
@Entity
@Data
@Builder
@ToString
@Table(name = "user_info")
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UpdateUserValidator(message = "该用户不存在", groups = UpdateUserGroup.class)
    private Long id;
    /**
     * username
     * TODO
     * 遗留问题： 根据id编辑用户信息时，校验不到新用户名是否与其它id的用户名一致
     * 考虑思路： 现在用的都是Field 级别的自定义校验类（无法同时拿到id和username）， 可以试一下类级别的校验类
     */
    @AddUserValidator(message = "用户名已存在", groups = AddUserGroup.class)
    @NotBlank(message = "用户名不为空", groups = DefaultGroup.class)
    private String username;
    /**
     * password (len: 6-10)
     */
    @NotBlank(message = "密码不能为空", groups = DefaultGroup.class)
    @Length(min = 6, max = 10, message = "确保密码长度（6-10）", groups = DefaultGroup.class)
    private String password;
    /**
     * age (between 0-200)
     */
    @NotNull(message = "年龄不能为空", groups = DefaultGroup.class)
    @Range(min = 0, max = 200, message = "确保年龄(0-200)", groups = DefaultGroup.class)
    private Integer age;
    /**
     * address
     */
    private String address;
}
