package com.example.springboot.demo.mapper.ext;

import com.example.springboot.demo.mapper.StudentMapper;
import com.example.springboot.demo.model.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface StudentMapperExt extends StudentMapper {

    @Select("select * from student")
    List<Student> selectAll();

    Student findByName(@Param("name")String name);

    void updateByName(@Param("name")String name, @Param("age")Integer age);

    void deleteByName(@Param("name")String name);
}
