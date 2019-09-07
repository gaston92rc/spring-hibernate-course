package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseForGastonDemo {

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

            Student student = (Student) session.createQuery("from Student s where s.firstName like '%Gaston%'").getSingleResult();

            System.out.println(student);
            System.out.println("Courses: "+student.getCourses());
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            session.close();
            factory.close();
        }

    }
}
