package com.cy.pj.sys.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.cy.pj.sys.entity.SysUser;
@Mapper
public interface SysUserDao {
		@Select("select * from user where name=#{name}")
		SysUser findUserByUsername(String username);
		
		@Select("select * from user where id = #{id}")
		SysUser findObjectById(Integer id);

		int updateUser(SysUser user);
		
		
		@Select("select * from user where id=#{id}")
		SysUser  findUserById(Integer id);
		
		@Select("select * from user where name = #{name}")
		SysUser finduser(@Param("name")String name);
		
	}
