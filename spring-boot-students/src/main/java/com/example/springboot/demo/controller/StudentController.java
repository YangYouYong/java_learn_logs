package com.example.springboot.demo.controller;

import com.example.springboot.demo.model.Student;
import com.example.springboot.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "student API", tags="Student 所有接口")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "获取所有Students" ,  notes="students list")
    @GetMapping("/list")
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }


    @ApiOperation(value = "条件查询Student" ,  notes="get students")
    @GetMapping("/filterByName")
    public ResponseEntity<List<Student>> filterByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(studentService.filterByName(name));
    }

    @ApiOperation(value = "添加Student" ,  notes="添加Student API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "student name", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "student age", required = true, paramType = "query", dataType = "integer")
    })
    @PostMapping("/add")
    public ResponseEntity<List<Student>> addStudent(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return ResponseEntity.ok(studentService.addStudent(name, age));
    }

    @ApiOperation(value = "更新Student" ,  notes="update ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "student name", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "student age", required = true, paramType = "query", dataType = "Integer")
    })
    @PostMapping("/update")
    public ResponseEntity<List<Student>> updateStudent(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return ResponseEntity.ok(studentService.update(name, age));
    }

    @ApiOperation(value = "删除Student" ,  notes="delete ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "student name", required = true, paramType = "query", dataType = "String")
    })
    @PostMapping("/delete")
    public ResponseEntity<List<Student>> deleteStudent(@RequestParam("name") String name) {
        return ResponseEntity.ok(studentService.delete(name));
    }
}
