package com.sea.web.uac.dao;

import com.sea.web.uac.modal.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Service for Users' CRUD.
 *
 * Created by chris on 17-4-9.
 */
//@Repository
@Mapper
public interface UserDAO {

  @Results(id = "userResult", value = {
      @Result(property = "id", column = "id"),
      @Result(property = "loginName", column = "login_name"),
      @Result(property = "userName", column = "user_name"),
      @Result(property = "password", column = "password"),
      @Result(property = "status", column = "status")
  })

  /**
   * Create a user.
   *
   * @param user target user's info.
   */
  @Insert("INSERT INTO user " +
      "(id, login_name, user_name, password, status) " +
      "VALUES " +
      "(#{id}, #{loginName}, #{userName}, #{password}, #{status}")
  public void create(User user);

  /**
   * Delete a user from database;
   *
   * @param user target user's info
   */
  @Delete("DELETE FROM user WEHRE id = #{id}")
  public void delete(User user);

  /**
   * Update a user.
   *
   * @param user target user's info
   */
  @Update("UPDATE user " +
      "SET " +
      "userName = #{userName}, " +
      "password = #{password}, " +
      "status = #{status} " +
      "WHERE id = #{id}")
  public void update(User user);

  /**
   * Get a user's info by userId.
   *
   * @param userId target user's id
   * @return User object
   */
  @Select("SELECT * FROM user WHERE id = #{userId}")
  public User getById(long userId);

  /**
   * Get user info by login name.
   *
   * @param loginName login name
   */
  @Select("SELECT * FROM user WHERE login_name = #{loginName}")
  public User getByLoginName(String loginName);
}
