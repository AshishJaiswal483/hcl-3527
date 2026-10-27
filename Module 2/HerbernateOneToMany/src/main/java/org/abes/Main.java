package org.abes;

import org.hibernate.*;
import org.hibernate.cfg.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
//
//        Many to one side
//        Department d1=new Department();
//        d1.setDept_id(1);
//        d1.setDept_name("cse");
////        session.persist(d1);
//      tx.commit();
//
//         tx = session.beginTransaction();
//        Employee e1=new Employee();
//        e1.setEmp_id(1);
//        e1.setEmp_name("Ashish Jaiswal");
//        e1.setDepartment(d1);
////        session.persist(e1);
//        tx.commit();
//
//        tx = session.beginTransaction();
//        Employee e2=new Employee();
//        e2.setEmp_id(2);
//        e2.setEmp_name("Ashish Jaiswal");
//        e2.setDepartment(d1);
//        session.persist(e2);
//        tx.commit();
//
//        System.out.println("many to one save relationship successfully");

//        one to many side
//        Department d1 = new Department();
//        d1.setDept_id(4);
//        d1.setDept_name("CSE");
//
//        Department d2 = new Department();
//        d2.setDept_id(5);
//        d2.setDept_name("AIML");
//
//        Department d3 = new Department();
//        d3.setDept_id(6);
//        d3.setDept_name("IT");
//
//        Employee e1 = new Employee();
//        e1.setEmp_id(4);
//        e1.setEmp_name("Amit");
//
//        Employee e2 = new Employee();
//        e2.setEmp_id(5);
//        e2.setEmp_name("Rahul");
//
//        Employee e3 = new Employee();
//        e3.setEmp_id(6);
//        e3.setEmp_name("Sumit");
//
//// Establish relationships
//        d1.addEmployee(e1);
//        d1.addEmployee(e2);
//        d2.addEmployee(e3);
//
//// Save departments
//        session.persist(d1);
//        session.persist(d2);
//        session.persist(d3);
//
//// Save employees
//        session.persist(e1);
//        session.persist(e2);
//        session.persist(e3);
//
//        tx.commit();

//        System.out.println(d1.getEmployees().get(0).getEmp_name());
//
//        System.out.println(d1.getEmployees().get(1).getEmp_name());
//
//
//        System.out.println(d1.getEmployees().size());
//
//
//
//        session.close();
//        factory.close();





    }
}
