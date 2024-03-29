package com.luv2code.hibernate.demo.main;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "where i.id =:id",Instructor.class);

            query.setParameter("id",1);

            Instructor instructor = query.getSingleResult();
            System.out.println("Instructor: "+instructor);

            session.getTransaction().commit();
            session.close();

            System.out.println("\nThe session is closed\n");

            System.out.println("Courses: "+instructor.getCourses());
            System.out.println("Done!");

        }finally {
            session.close();
            factory.close();
        }

    }
}
