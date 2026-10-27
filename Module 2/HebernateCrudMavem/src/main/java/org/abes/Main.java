package org.abes;

import org.hibernate.*;
import org.hibernate.cfg.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class).buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();


        // CREATE: Insert student
        Students s1=new Students();
        s1.setName("ashish jaiswal");
        s1.setMarks(99);
        session.persist(s1);
        tx.commit();

        // READ: Fetch student
        session = factory.openSession();
        Students student = session.get(Students.class, 1);

        if (student != null) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getMarks());
            System.out.println("Student Email: " + student.getName());
        } else {
            System.out.println("Student not found");
        }

        // UPDATE: Update student
        tx = session.beginTransaction();

        if (student != null) {
            student.setName("Ashish Jaiswal");
            student.setMarks(100);
        }

        tx.commit();

        // DELETE: Delete student
        tx = session.beginTransaction();

        if (student != null) {
            session.remove(student);
        }

        tx.commit();

        //INsert
        tx= session.beginTransaction();
        Students s2=new Students();
        s2.setMarks(100);
        s2.setName("Ashish Jaiswal");
        session.persist(s2);
        tx.commit();

        System.out.println("crud  operation successfull");

        session.close();
        factory.close();
    }
}
