package com.example.jpamybatis.dao;

import com.example.jpamybatis.dto.UserRecord;
import com.example.jpamybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("SELECT name, age FROM TB_USER WHERE id = #{id}")
    public UserRecord findByIdMybatis(Long id);

    @Insert("INSERT INTO TB_USER (name, age) VALUES (#{name}, #{age})")
    void insertMybatis(UserEntity userEntity);
}
