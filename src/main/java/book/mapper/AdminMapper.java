package book.mapper;

import org.apache.ibatis.annotations.Select;

import book.domain.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer admin_id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer admin_id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    @Select("select * from p_admin where admin_name=#{admin_name}")
	Admin selectByName(Admin admin);
    
    @Select("select * from p_admin where admin_name=#{admin_name} and admin_pwd=#{admin_pwd}")
	Admin checkPass(Admin admin);
}