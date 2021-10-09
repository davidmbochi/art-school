package com.company.schoolart;

import com.company.schoolart.model.Group;
import com.company.schoolart.model.Student;
import com.company.schoolart.model.StudentStatus;
import com.company.schoolart.repository.GroupRepository;
import com.company.schoolart.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SchoolArtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolArtApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentRepository studentRepository,
											   GroupRepository groupRepository){
		return args -> {
			List<Group> groups = List.of(
					new Group("painting"),
					new Group("sculpture"),
					new Group("literature"),
					new Group("architecture"),
					new Group("cinema")
			);

			groupRepository.saveAll(groups);

			List<Student> students = List.of(
					new Student("john",
							"doe",
							"john@gmail.com",
							LocalDate.of(1996,03,23),
							StudentStatus.ACTIVE),
					new Student("mary",
							"public",
							"mary@gmail.com",
							LocalDate.of(1997,10,27),
							null),
					new Student("peter",
							"parker",
							"peter@gmail.com",
							LocalDate.of(1987,7,13),
							StudentStatus.INACTIVE)
			);

			studentRepository.saveAll(students);


			Student john = studentRepository.findStudentByStudentName("john");
			Group painting = groupRepository.findGroupByGroupName("painting");
			if (john != null && painting != null){
				john.setGroup(painting);
				studentRepository.save(john);
			}

			Student mary = studentRepository.findStudentByStudentName("mary");
			Group sculpture = groupRepository.findGroupByGroupName("sculpture");
			if (mary != null && sculpture != null){
				mary.setGroup(sculpture);
				studentRepository.save(mary);
			}

			Student peter = studentRepository.findStudentByStudentName("peter");
			Group literature = groupRepository.findGroupByGroupName("literature");
			if (peter != null && literature != null){
				peter.setGroup(literature);
				studentRepository.save(peter);
			}
		};
	}

}
