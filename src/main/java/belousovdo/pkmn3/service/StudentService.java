package belousovdo.pkmn3.service;

import belousovdo.pkmn3.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentByFullName(String firstName, String surName, String familyName);

    List<Student> getStudentsByGroup(String group);

    Student saveStudent(Student student);
}
