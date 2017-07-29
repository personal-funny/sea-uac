package com.sea.web.uac.dao;

import com.sea.web.uac.modal.Role;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Service for Role's CURD
 *
 * Created by chris on 17-7-15.
 */
//@Repository
@Mapper
public interface RoleDAO {

  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "roleName", column = "role_name")
  })

  /**
   * Create a role.
   *
   * @param role target role's info.
   */
  @Insert("INSERT INTO role (role_name) VALUES (#{roleName})")
  public void create(Role role);

  /**
   * Delete a role from database;
   *
   * @param role target role's info
   */
  @Delete("DELETE FROM role WEHRE id = #{id}")
  public void delete(Role role);

  /**
   * Update a role.
   *
   * @param role target role's info
   */
  @Update("UPDATE role SET role_name = #{roleName} WHERE id = #{id}")
  public void update(Role role);

  /**
   * Get a role's info by roleId.
   *
   * @param roleId target role's id
   * @return Role object
   */
  @Select("SELECT * FROM role WHERE id = #{roleId}")
  public Role get(long roleId);
}
