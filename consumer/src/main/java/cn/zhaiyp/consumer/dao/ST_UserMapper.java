package cn.zhaiyp.consumer.dao;

import cn.zhaiyp.consumer.entity.ST_User;

public interface ST_UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(ST_User record);

    int insertSelective(ST_User record);

    ST_User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ST_User record);

    int updateByPrimaryKey(ST_User record);
}