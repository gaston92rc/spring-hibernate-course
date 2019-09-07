package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student...");

            Student student = new Student("Lucas","Cuesta","lucascuesta@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the Student...");
            System.out.println(student);
            session.save(student);
            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: "+ student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting the Student with id: "+ student.getId());

            Student myStudent = session.get(Student.class,student.getId());

            System.out.println("Get complete: "+myStudent);

            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
