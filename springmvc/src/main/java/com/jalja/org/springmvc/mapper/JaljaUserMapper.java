package com.jalja.org.springmvc.mapper;

import com.jalja.org.springmvc.model.JaljaUser;
import com.jalja.org.springmvc.model.JaljaUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JaljaUserMapper {
    int countByExample(JaljaUserExample example);

    int deleteByExample(JaljaUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JaljaUser record);

    int insertSelective(JaljaUser record);

    List<JaljaUser> selectByExample(JaljaUserExample example);

    JaljaUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JaljaUser record, @Param("example") JaljaUserExample example);

    int updateByExample(@Param("record") JaljaUser record, @Param("example") JaljaUserExample example);

    int updateByPrimaryKeySelective(JaljaUser record);

    int updateByPrimaryKey(JaljaUser record);
}