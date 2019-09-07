package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student...");

            Student student1 = new Student("Lucas","Cuesta","lucascuesta@gmail.com");
            Student student2 = new Student("Rosa","Mancuso","rosamancuso@gmail.com");
            Student student3 = new Student("Angelina","Mancuso","angelinamancuso@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the Student...");

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }
}
