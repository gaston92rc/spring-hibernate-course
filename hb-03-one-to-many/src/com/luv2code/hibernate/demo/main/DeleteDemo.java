package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class,1);

            if(instructor != null){
                System.out.println("Deleting instructor: "+instructor.getFirstName() + " " + instructor.getLastName());

                session.delete(instructor);
            }else {
                System.out.println("Instructor not found");
            }



            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}
