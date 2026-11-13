package org.example.studentsystem;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student updateStudent(int id, Student updatedStudent) {
        Student current = getStudentById(id);

        current.setName(updatedStudent.getName());
        current.setAge(updatedStudent.getAge());
        current.setGender(updatedStudent.getGender();

        return studentRepository.save(current);
    }

    public String deleteAllStudent() {
        studentRepository.deleteAll();
        return "All students deleted";
    }

    public String deleteStudentById(int id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student not found");
        }
        studentRepository.deleteById(id);
        return "Student deleted";
    }
}