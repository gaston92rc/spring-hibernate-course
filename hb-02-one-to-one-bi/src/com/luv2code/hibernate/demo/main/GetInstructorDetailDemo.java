package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class,3);

            if(instructorDetail != null){
                System.out.println("Instructor Detail found: ");
                System.out.println(instructorDetail);
                System.out.println("Associated Instructor: "+instructorDetail.getInstructor());
            }else{
                System.out.println("Instructor detail not found");
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
