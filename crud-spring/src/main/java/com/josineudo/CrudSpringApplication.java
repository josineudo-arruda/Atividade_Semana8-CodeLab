package com.josineudo;

import com.josineudo.Enums.Category;
import com.josineudo.Model.Course;
import com.josineudo.Model.Lesson;
import com.josineudo.Repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("1989");
			c.setCategory(Category.POP);

			Lesson l = new Lesson();
			l.setName("New Romantics");
			l.setYoutubeUrl("https://www.youtube.com/watch?v=wyK7YuwUWsU");
			l.setCourse(c);
			c.getLessons().add(l);

			courseRepository.save(c);
		};
	}
}
