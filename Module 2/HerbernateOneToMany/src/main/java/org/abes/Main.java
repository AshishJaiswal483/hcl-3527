package org.abes;

import org.hibernate.*;
import org.hibernate.cfg.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
//
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//
//
        Many to one side



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

        one to many side


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



 basic hql query



        // 1. Fetch all employees
//        Query<Employee> q1 = session.createQuery(
//                "FROM Employee", Employee.class
//        );
//
//        List<Employee> employees = q1.getResultList();
//
//        for (Employee e : employees) {
//            System.out.println(e.getId() + " " + e.getName());
//        }
//
//
//        // 2. Fetch employees by name
//        Query<Employee> q2 = session.createQuery(
//                "FROM Employee WHERE name = :n",
//                Employee.class
//        );
//
//        q2.setParameter("n", "Ashish");
//
//        List<Employee> byName = q2.getResultList();
//
//        for (Employee e : byName) {
//            System.out.println(e.getId() + " " + e.getName());
//        }
//
//
//        // 3. Fetch employees whose salary is greater than 40000
//        Query<Employee> q3 = session.createQuery(
//                "FROM Employee WHERE salary > :s",
//                Employee.class
//        );
//
//        q3.setParameter("s", 40000.0);
//
//        List<Employee> bySalary = q3.getResultList();
//
//        for (Employee e : bySalary) {
//            System.out.println(e.getName() + " " + e.getSalary());
//        }
//
//
//        // 4. Sort employees by salary (highest to lowest)
//        Query<Employee> q4 = session.createQuery(
//                "FROM Employee ORDER BY salary DESC",
//                Employee.class
//        );
//
//        List<Employee> sortedEmployees = q4.getResultList();
//
//        for (Employee e : sortedEmployees) {
//            System.out.println(e.getName() + " " + e.getSalary());
//        }
//
//
//        // 5. Fetch one employee by ID
//        Query<Employee> q5 = session.createQuery(
//                "FROM Employee WHERE id = :id",
//                Employee.class
//        );
//
//        q5.setParameter("id", 101);
//
//        Employee e = q5.uniqueResult();
//
//        if (e != null) {
//            System.out.println(e.getId() + " " + e.getName());
//        }
//
//
//        // 6. Fetch employees belonging to the IT department
//        Query<Employee> q6 = session.createQuery(
//                "FROM Employee e WHERE e.department.name = :dept",
//                Employee.class
//        );
//
//        q6.setParameter("dept", "IT");
//
//        List<Employee> itEmployees = q6.getResultList();
//
//        for (Employee emp : itEmployees) {
//            System.out.println(
//                    emp.getName() + " " +
//                            emp.getDepartment().getName()
//            );
//        }

        hebernate theory



//        1. First-level cache
//
//        Definition: Cache maintained per Hibernate session.
//
//                Example:
//        Session session = factory.openSession();
//
//        Employee e1 = session.get(Employee.class, 1);
//        Employee e2 = session.get(Employee.class, 1);
//
//
//        Explanation: Hibernate loads employee 1 the first time. The second get() returns the same managed object from the session's first-level cache, so another database query is normally unnecessary.
//
//
//        2. Dirty checking
//
//        Definition: Automatically detects changes to managed entities.
//
//        Example:
//        Transaction tx = session.beginTransaction();
//
//        Employee e1 = session.get(Employee.class, 1);
//        e1.setSalary(60000);
//
//        tx.commit();
//
//
//        Explanation: We changed the salary but didn't write an UPDATE query. Hibernate detects the change and updates the database when the session flushes, normally during commit().
//
//
//        3. Managed entity
//        Definition: An entity currently tracked by a Hibernate session.
//
//        Example:
//        Employee e1 = session.get(Employee.class, 1);
//        e1.setSalary(60000);
//
//
//        Explanation: e1 is managed because it was loaded through the open session. Hibernate tracks its changes and can save them automatically at flush time.
//
//
//        4. Detached entity
//        Definition: An entity no longer tracked by its original session.
//
//                Example:
//        Employee e1 = session.get(Employee.class, 1);
//
//        session.close();
//
//        e1.setSalary(70000);
//
//
//        Explanation: After session.close(), e1 becomes detached. Changing its salary does not automatically update the database.
//
//
//        5. Lazy loading
//        Definition: Fetch related data when needed.
//
//                Example:
//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "department_id")
//        private Department department;
//
//
//        Usage:
//        Employee e1 = session.get(Employee.class, 1);
//
//// Access the related department when needed
//        Department d1 = e1.getDepartment();
//        System.out.println(d1.getName());
//
//
//        Explanation: Hibernate can delay fetching the related department until it is accessed. The session should remain open when the lazy relationship is accessed.
//
//
//        6. Eager loading
//        Definition: Fetch related data eagerly.
//
//        Example:
//        @ManyToOne(fetch = FetchType.EAGER)
//        @JoinColumn(name = "department_id")
//        private Department department;
//
//
//        Usage:
//        Employee e1 = session.get(Employee.class, 1);
//
//        System.out.println(e1.getDepartment().getName());
//
//
//        Explanation: Hibernate fetches the department as part of eagerly loading the employee, although the exact SQL and number of queries depend on the fetch plan.



    }
}
