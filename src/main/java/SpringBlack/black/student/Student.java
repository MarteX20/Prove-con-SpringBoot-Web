package SpringBlack.black.student;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;

    private LocalDate dob;
    @Transient //@Transient fa in modo che la riga sotto non sia una colonna nel database e quindi significa che (in questo caso età) sarà calcolata da sola (sarà comunque presente in JSON quando si fa GET
    private Integer age;


    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    //No id constructor
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
}
