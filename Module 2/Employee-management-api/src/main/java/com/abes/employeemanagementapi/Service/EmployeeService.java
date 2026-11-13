package com.abes.employeemanagementapi.Service;

import com.abes.employeemanagementapi.Entity.Card;
import com.abes.employeemanagementapi.Repository.CardRepo;
import com.abes.employeemanagementapi.Repository.EmployeeRepo;
import com.abes.employeemanagementapi.Entity.Employee;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class EmployeeService {
    private final EmployeeRepo employee_repo;
    private final CardRepo cardrepo;

    public EmployeeService(EmployeeRepo employeeRepo, CardRepo cardRepo) {
        this.employee_repo = employeeRepo;
        this.cardrepo=cardRepo;
    }

//    //add employee
//    public Employee addEmployee(Employee emp){
//        return employee_repo.save(emp);
//    }
//
//    //find all employee
//   public List<Employee>GetAllEmployee(){
//       return employee_repo.findAll();
//    }
//
//    //find by id
//    public Optional<Employee>SerachById(int id){
//        return employee_repo.findById(id);
//    }
//
//    //delete by id
//    public void DeleteByid(int id){
//
//        Optional<Employee>emp=employee_repo.findById(id);
//        if(emp.isEmpty()){
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND,
//                    "No employee exists with ID: " + id
//            );
//
//        }
//        employee_repo.deleteById(id);
//    }
//
//    //exit by id
//    public boolean ExitById(int id){
//        return employee_repo.existsById(id);
//    }
//
//    //count number of emplyee
//    public long Count(){
//        return employee_repo.count();
//    }
//
//    //update employee
//    public Employee Update(int id, Employee emp) {
//
//        Optional<Employee> old_emp=employee_repo.findById(id);
//        if(old_emp.isEmpty()){
//
//                throw new ResponseStatusException(
//                        HttpStatus.NOT_FOUND,
//                        "No employee exists with this ID"
//                );
//
//        }
//
//        Employee e = old_emp.get();
//        e.setDepartment(emp.getDepartment());
//        e.setName(emp.getName());
//
//        return employee_repo.save(e);
//    }
//
//
//
//    //find by name
//   public List<Employee>FindByName(String name){
//        List<Employee>emp_list= employee_repo.findByName(name);
//        if(emp_list.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO emplyee exit by this name");
//        }
//        return emp_list;
//    }
//
//    //find by department
//    public List<Employee>FindByDepartment(String name){
////        return employee_repo.findByDepartment(name);
//        List<Employee>emp_List=employee_repo.findByDepartment(name);
//        if(emp_List.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO EMPLOYEE FOUND BY THIS DEPARTMENT");
//        }
//        return emp_List;
//    }
//
////    find by name and department
//    public List<Employee>FindByNameAndDepartment(String name,String dept){
//        List<Employee>emp=employee_repo.findByNameAndDepartment(name,dept);
//
////
//        if(emp.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NOT EXIT with name and department");
//        }
//       return emp;
//
//    }
//
//    //find by name containg keyword
//    public List<Employee>NameKeyword(String keyword){
//        List<Employee>List = employee_repo.findByNameContaining(keyword);
//        if(List.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO SUCH NAME EXIT");
//        }
//        return List;
//    }
//
//    //find by depatment order name by asscending way
//    public List<Employee>FindByDepartmentOrderAcc(String dept){
//        return employee_repo.findByDepartmentOrderByNameAsc(dept);
//    }

    //add employee with card

        public Employee AddEmployeeWithCard(Employee emp) {

            // Step 1: Create Card
            Card card = new Card();
            long cardNumber = 100000000L +
                    new java.util.Random().nextInt(900000000);

            card.setCardNumber(cardNumber);

            // Step 2: Employee must not reference an unsaved Card
            emp.setCard(null);

            // Step 3: Save Employee first
            Employee savedEmployee = employee_repo.save(emp);

            // Step 4: Set the saved Employee in Card
            card.setEmployee(savedEmployee);

            // Step 5: Save Card
            cardrepo.save(card);

            // Step 6: Set Card reference for the response
            savedEmployee.setCard(card);

            return savedEmployee;
        }

        //get employee deatil with card
      public Employee EmployeeDetailWIthCard(int id){
            Optional<Employee>emp=employee_repo.findById(id);
            if(emp.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not id with employee found");
            }
          return emp.get();
      }

      //get card  by employee id
    public Card GetCardByEmployeeId(int id){
             Optional<Card>card=cardrepo.findByEmployee_Id(id);
             if(card.isEmpty()){
                 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO EMPLOYEE EXIT WITH THIS ID");
             }
        return card.get();
    }

    //get employee by card id
   public Employee GetEmployeeByCardId(int id){
            Optional<Employee>emp=employee_repo.findByCard_cardId(id);
            if(emp.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO CARD EXIT WITH THIS ID");
            }
       return emp.get();
   }

   //update card by taking employee id
    public Card UpdateCardByEmpId(int id,long newNumber){
            Optional<Card>c=cardrepo.findByEmployee_Id(id);
            if(c.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO CARD FOUND");
            }
            Card card=c.get();
            card.setCardNumber(newNumber);
            return card;
    }

 //delete card by employee id
    public void DeleteCardByempId(int id){
            Optional<Card>card =cardrepo.findByEmployee_Id(id);
            if(card.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"EMPLOYEE ID NOT FOUND:"+id);
            }
            Optional<Employee>emp =employee_repo.findById(id);
            Employee e=emp.get();
            e.setCard(null);
            Card c=card.get();
            cardrepo.deleteById(c.getCardId());
    }
    }


