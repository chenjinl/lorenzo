package com.aitutech.lorenzo.common.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "sys_user")
@Data
public class User implements Serializable {

    @Id
    @Column(name = "user_id", length = 36 )
    @GenericGenerator(name="idGenerator", strategy="guid")
    @GeneratedValue(generator="idGenerator")
    private String userId;

    @Column(name = "username", length = 20, nullable = false)
    @NotNull(message = "用户名不能为空")
    @Length(min = 2,max= 20, message = "用户名长度需要在2和20之间")
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    @NotNull(message = "密码不能为空")
    private String password;
}
