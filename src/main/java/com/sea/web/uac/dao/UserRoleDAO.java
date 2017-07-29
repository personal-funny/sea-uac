package com.sea.web.uac.dao;

import com.sea.web.uac.modal.Role;
import com.sea.web.uac.modal.User;
import com.sea.web.uac.modal.UserRole;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Service for Role's CURD
 *
 * Created by chris on 17-7-15.
 */
//@Repository
@Mapper
public interface UserRoleDAO {

  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "uid", column = "uid"),
      @Result(property = "rid", column = "rid")
  })

  /**
   * Create a user_role.
   *
   * @param ur target user_role's info.
   */
  @Insert("INSERT INTO user_role (uid, rid) VALUES (#{uid}, #{rid})")
  public void create(UserRole ur);

  /**
   * Delete a user_role from database;
   *
   * @param ur target user_role's info
   */
  @Delete("DELETE FROM user_role WEHRE id = #{id}")
  public void delete(UserRole ur);

  /**
   * Get user_role list by userid.
   *
   * @param uid userid
   * @return list of user_role
   */
  @Select("SELECT * FROM user_role WHERE uid = #{uid}")
  public List<UserRole> getByUid(long uid);

  /**
   * Get user_role list by roleid.
   *
   * @param rid roleid
   * @return list of user_role
   */
  @Select("SELECT * FROM user_role WHERE rid = #{rid}")
  public List<UserRole> getByRid(long rid);
}
