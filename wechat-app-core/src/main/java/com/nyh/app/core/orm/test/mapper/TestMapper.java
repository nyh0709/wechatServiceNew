package com.nyh.app.core.orm.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.nyh.app.common.vo.test.TestVo;
import com.nyh.app.core.orm.test.domain.Test;

/**
 * User映射类
 * Created by Administrator on 2017/11/24.
 */
@Repository
public interface TestMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    Test findUserByName(@Param("name") String name);

    @Insert("INSERT INTO USER(UUID, NAME, AGE, SEX) VALUES(REPLACE(UUID(),'-',''), #{name,jdbcType=VARCHAR}, #{age,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR})")
    void insert(TestVo testVo);

    @Select("SELECT * FROM USER")
	List<Test> findAll();

}