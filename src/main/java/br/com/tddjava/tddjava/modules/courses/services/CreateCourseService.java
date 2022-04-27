package br.com.tddjava.tddjava.modules.courses.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.CourseJPARepository;
import br.com.tddjava.tddjava.modules.courses.repositories.ICourseRepository;

@Service
public class CreateCourseService {

  private ICourseRepository repository;

  public CreateCourseService(ICourseRepository repository) {
    this.repository = repository;
  }

  public Course execute(Course course) {

    // Validar se o curso existe pelo nome
    Course existedCourse = this.repository.findByName(course.getName());

    // Se sim - retorna erro

    if (existedCourse != null) {
      throw new Error("Curso já existe!");
    }

    // Se não - Salvar e retorna novo curso
    return this.repository.save(course);

  }

}
