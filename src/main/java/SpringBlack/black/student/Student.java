package SpringBlack.black.student;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;

    private LocalDate dob;
    private Integer age;

    //No id constructor
    public Student(String name, String email, LocalDate dob, Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
}
