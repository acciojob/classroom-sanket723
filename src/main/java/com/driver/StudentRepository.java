package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository

public class StudentRepository {
    HashMap<String,Student> studentHashMap;
    HashMap<String,Teacher> teacherHashMap;
    HashMap<String, List<String>> studentTeacherHashMap;

    public StudentRepository() {
        this.studentHashMap = new HashMap<>();
        this.teacherHashMap = new HashMap<>();
        this.studentTeacherHashMap = new HashMap<>();
    }

    public void addStudent(Student student){
        studentHashMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String studentName,String teacherName){
        if(!studentTeacherHashMap.containsKey(teacherName)){
            List<String> list = new ArrayList<>();
            list.add(studentName);
            studentTeacherHashMap.put(teacherName,list);
        }
        else
             studentTeacherHashMap.get(teacherName).add(studentName);
    }

    public Student getStudentByName(String name){
        return studentHashMap.get(name);
    }

    public Teacher getTeacherByName(String name){
        return teacherHashMap.get(name);
    }

    public List<String> getStudentByTeacherName(String name){
        return studentTeacherHashMap.get(name);
    }

    public List<String> getAllStudents(){
        List<String> list = new ArrayList<>();
        for(String name : studentHashMap.keySet()){
            list.add(name);
        }
        return list;
    }

    public void deleteTeacherByName(String teacherName){
        List<String> list = studentTeacherHashMap.get(teacherName);
        for(String s : list){
            studentHashMap.remove(s);
        }
        teacherHashMap.remove(teacherName);
        studentTeacherHashMap.remove(teacherName);
    }

    public void deleteAllTeachers(){
        for(String name : teacherHashMap.keySet()){
            deleteTeacherByName(name);
        }
    }

}
