package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student ").list();

            displayStudents(students);

            System.out.println("----------------------------------------------------------------------------------");
            students = session.createQuery("from Student s where s.lastName = 'Mancuso'").getResultList();
            displayStudents(students);

            System.out.println("----------------------------------------------------------------------------------");
            students = session.createQuery("from Student s where s.lastName = 'Mancuso' or s.firstName = 'Gaston'").getResultList();
            displayStudents(students);

            System.out.println("----------------------------------------------------------------------------------");
            students = session.createQuery("from Student s where s.email like '%cuesta@%'").getResultList();
            displayStudents(students);


            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
