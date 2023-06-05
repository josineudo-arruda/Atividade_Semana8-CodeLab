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

			Lesson l1 = new Lesson();
			l1.setName("New Romantics");
			l1.setYoutubeUrl("https://www.youtube.com/watch?v=wyK7YuwUWsU");
			// l1.setYoutubeUrl("watch?v=wyK7YuwUWsU");
			l1.setCourse(c);
			c.getLessons().add(l1);

			Lesson l2 = new Lesson();
			l2.setName("Blank Space");
			l2.setYoutubeUrl("https://www.youtube.com/watch?v=e-ORhEE9VVg");
			//l2.setYoutubeUrl("watch?v=e-ORhEE9VVg");
			l2.setCourse(c);
			c.getLessons().add(l2);

			courseRepository.save(c);
		};
	}
}
