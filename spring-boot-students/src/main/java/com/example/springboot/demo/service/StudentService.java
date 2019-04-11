package com.example.springboot.demo.service;

import com.example.springboot.demo.mapper.ext.StudentMapperExt;
import com.example.springboot.demo.model.Student;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService implements InitializingBean {

    @Autowired
    private StudentMapperExt studentMapper;

    public List<Student> findAll() {

        return studentMapper.selectAll();
    }

    public List<Student> addStudent(String name, Integer age) {

        Student stu = new Student();
        stu.setAge(age);
        stu.setName(name);

        studentMapper.insert(stu);

        return studentMapper.selectAll();
    }

    public List<Student> filterByName(String name) {
        List<Student> students = new ArrayList<Student>();
        Student stu = studentMapper.findByName(name);
        if (null != stu) {
            students.add(stu);
        }
        return students;
    }

    public List<Student> update(String name, Integer age) {
        List<Student> students = new ArrayList<Student>();
        studentMapper.updateByName(name, age);
        Student stu = studentMapper.findByName(name);
        if (null != stu) {
            students.add(stu);
        }
        return students;
    }

    public List<Student> delete(String name) {

        studentMapper.deleteByName(name);

        return studentMapper.selectAll();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
