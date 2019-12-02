package com.funstar.feign.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author fangsida
 * @date 2019/11/22
 */
@Data
@Accessors(chain = true)
public class User {

    private String name;

    private String role;

}
