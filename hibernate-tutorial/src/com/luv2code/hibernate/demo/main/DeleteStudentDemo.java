package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session;

        try {

            int studentId = 1;

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Getting student with id: "+studentId);

            Student student = session.get(Student.class,studentId);

            System.out.println("Deleting student: "+student);

            session.delete(student);

            System.out.println("Deleting student id = 2");

            session.createQuery("delete from student where id = 2").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
