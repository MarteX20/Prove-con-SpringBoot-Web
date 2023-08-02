package SpringBlack.black.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return  args -> {
            Student sve = new Student("Sveta", "sve@gmail.com", LocalDate.of(2000, APRIL, 1), 23);

            Student max = new Student("Maksym", "maksym@gmail.com", LocalDate.of(2000, APRIL, 15), 23);

            repository.saveAll(List.of(sve, max));
        };
    }
}
