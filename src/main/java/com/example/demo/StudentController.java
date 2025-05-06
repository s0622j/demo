package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @RequestMapping("/students")
    public String insert(@RequestBody Student student){
        //String sql = "INSERT INTO student(id, name) VALUES (3, 'John')";
        String sql = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());
        namedParameterJdbcTemplate.update(sql, map);
        return "执行 insert 成功";
    }

    @RequestMapping("/getStudents")
    public List<Student> query() {

        String sql = "SELECT id, name FROM student";

        Map<String, Object> map = new HashMap<>();

        StudentRowMapper rowMapper = new StudentRowMapper();

        List<Student> list = namedParameterJdbcTemplate.query(sql, map,
                rowMapper);

        return list;
    }


//    @PostMapping("/students")
//    public String create(@RequestBody Student student) {
//        return "執行資料庫的 Create 操作";
//    }
//
//    @GetMapping("/students/{studentId}")
//    public String read(@PathVariable Integer studentId) {
//        return "執行資料庫的 Read 操作";
//    }
//
//    @PutMapping("/students/{studentId}")
//    public String update(@PathVariable Integer studentId,
//                         @RequestBody Student student) {
//        return "執行資料庫的 Update 操作";
//    }
//
//    @DeleteMapping("/students/{studentId}")
//    public String delete(@PathVariable Integer studentId) {
//        return "執行資料庫的 Delete 操作";
//    }
}