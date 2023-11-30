package com.folksdev.webflux;

import com.folksdev.webflux.model.Course;
import com.folksdev.webflux.model.Student;
import com.folksdev.webflux.model.metadata.CourseMetadata;
import com.folksdev.webflux.model.metadata.EnglishCourseMetadata;
import com.folksdev.webflux.model.metadata.SpringCourseMetadata;
import com.folksdev.webflux.repository.CourseRepository;
import com.folksdev.webflux.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class WebfluxApplication implements CommandLineRunner {

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    public WebfluxApplication(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Course course = Course.builder()
				.id(UUID.randomUUID())
                .name("Webflux")
                .description("Spring Webflux")
                .duration(10)
                .teacher("FolksDev")
                .courseMetadata(
                        SpringCourseMetadata.builder()
                                .type("spring")
                                .language("Java")
                                .github("https://github.com/folksdev")
                                .prerequisites(List.of("Java", "Spring"))
                                .build())
				.isUpdated(false)
                .build();

		//courseRepository.save(course).block();

		Student student = Student.builder()
				.id(UUID.randomUUID())
				.name("John")
				.email("j@j.com")
				.dateOfBirth(LocalDate.of(2000,1,1))
				.courses(Set.of(course.getId().toString()))
				.isUpdated(false)
				.build();

		//studentRepository.save(student).block();



        Course course2 = Course.builder()
                .id(UUID.randomUUID())
                .name("English")
                .description("English with FolksdevX")
                .duration(100)
                .teacher("FolksDev")
                .courseMetadata(
                        EnglishCourseMetadata.builder()
                                .type("spring")
                                .level("B1")
                                .books(List.of("B1","B2"))
                                .build())
                .isUpdated(false)
                .build();

        courseRepository.save(course2).block();

        Student student2 = Student.builder()
                .id(UUID.randomUUID())
                .name("FSK")
                .email("j@j.com")
                .dateOfBirth(LocalDate.of(2000,1,1))
                .courses(Set.of(course2.getId().toString()))
                .isUpdated(false)
                .build();

        studentRepository.save(student2).block();

    }
}
