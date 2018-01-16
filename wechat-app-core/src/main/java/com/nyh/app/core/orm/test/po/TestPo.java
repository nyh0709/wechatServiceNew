package com.nyh.app.core.orm.test.po;

import com.nyh.app.core.orm.AbstractPo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User实体映射类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=true)
public class TestPo extends AbstractPo {

    private String name;
    private String age;
    private String sex;

}