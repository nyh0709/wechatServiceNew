package com.nyh.app.core.orm.userInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.nyh.app.core.orm.userInfo.domain.UserInfo;
import com.nyh.app.core.orm.userInfo.po.UserInfoPo;

/**
 * TODO
 *
 * @author niuxudong[niu_xu_dong@163.com]
 * @date: 2017-12-26 22:03:18
 * @review: niuxudong[niu_xu_dong@163.com]/2017-12-26 22:03:18
 */
@Repository
public interface UserInfoMapper {

	@Insert("INSERT INTO USER_INFO(UUID, OPEN_ID, NICK_NAME, GENDER, AVATAR_URL, LANGUAGE, COUNTRY, PROVINCE, CITY, CREATE_DATE) "
			+ "VALUES(#{uuid,jdbcType=VARCHAR}, #{openId,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, #{avatarUrl,jdbcType=VARCHAR}, #{language,jdbcType=VARCHAR}, #{country,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, SYSDATE())")
	@SelectKey(statement = "select REPLACE(UUID(),'-','') uuid", keyProperty = "uuid", before = true, resultType = UserInfo.class, keyColumn = "UUID" )
    void insert(UserInfoPo po);

    @Select("SELECT * FROM USER_INFO")
	List<UserInfo> findAll();

    @Select("SELECT * FROM USER_INFO WHERE OPEN_ID = #{openId}")
	UserInfo findByOpenId(String openId);

    @Select("SELECT * FROM USER_INFO WHERE uuid = #{userId}")
	UserInfo findOne(String userId);

}