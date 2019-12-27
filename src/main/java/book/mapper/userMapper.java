package book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import book.domain.*;
public interface userMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
    
    @Select("select * from p_user where user_name=#{user_name}")
	user selectByName(user user);
    @Select("select * from p_user where user_name=#{user_name} and user_pwd=#{user_pwd}")
	user checkPass(user user);

    @Select("select * from p_user")
	List<user> findAll();
}