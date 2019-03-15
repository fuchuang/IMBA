package com.IMBA.dao;

import com.IMBA.entity.teacher;
import org.apache.ibatis.annotations.Param;

public interface teacherMapper {




    teacher selectByCourseId(Integer courseId);

    Integer selectIsLike(@Param("teacherId") Integer teacherId, @Param("stuId")Integer stuId);

    int updateGradeByTeacherId(teacher record);

    int deleteByPrimaryKey(Integer id);

    int insert(teacher record);

    int insertSelective(teacher record);

    teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(teacher record);

    int updateByPrimaryKey(teacher record);
}