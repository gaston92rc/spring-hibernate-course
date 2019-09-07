package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateCourseAndStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Student student1 = new Student("Angelina", "Mancuso", "angelinamancuso@gmail.com");
            Student student2 = new Student("Rosa", "Mancuso", "rosamancuso@gmail.com");

            Course course = new Course("Como cocinar una papa");

            System.out.println("Saving the student");

            session.save(student1);
            session.save(student2);
            System.out.println("Saving courses");
            session.save(course);


            student1.addCourse(course);
            student2.addCourse(course);



            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            session.close();
            factory.close();
        }

    }
}
