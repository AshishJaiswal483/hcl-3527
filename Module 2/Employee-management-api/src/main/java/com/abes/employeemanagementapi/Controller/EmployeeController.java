package com.abes.employeemanagementapi.Controller;

import com.abes.employeemanagementapi.Entity.Card;
import com.abes.employeemanagementapi.Service.EmployeeService;
import com.abes.employeemanagementapi.Entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add Employee
//    @PostMapping("/add")
//    ResponseEntity<Employee>addEmployee(@RequestBody Employee emp){
//        Employee added=employeeService.addEmployee(emp);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(added);
//    }
//    //find all employee
//    @GetMapping("/all")
//    ResponseEntity<?>allEmployee(){
//        List<Employee> all_emp=employeeService.GetAllEmployee();
//
//        if(all_emp.isEmpty()){
//           return ResponseEntity.status(HttpStatus.OK).body("Emplyee is empty");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(all_emp);
//    }
//
//   // find by id
//   @GetMapping("/{id}")
//    ResponseEntity<?>findById(@PathVariable int id){
//       Optional<Employee>emp = employeeService.SerachById(id);
//
//       if(emp.isEmpty()){
//          return ResponseEntity.status(HttpStatus.OK).body("Id not found");
//       }
//       Employee e=emp.get();
//        return ResponseEntity.status(HttpStatus.OK).body(e);
//   }
//
//   //delete by id
//    @DeleteMapping("/{id}")
//    ResponseEntity<String>Delete(@PathVariable int id){
//        employeeService.DeleteByid(id);
//
//       return ResponseEntity.status(HttpStatus.OK).body("employee deleted");
//
//    }
//
//    // 4. Update Employee
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> updateEmployee(
//            @PathVariable int id,
//            @RequestBody Employee emp) {
//
//        Employee updatedEmployee = employeeService.Update(id, emp);
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(updatedEmployee);
//    }
//
//
//
//    @GetMapping("/get-by-name/{name}")
//    ResponseEntity<List<Employee>>Getbyname(@PathVariable String name){
//        List<Employee>emp_list=employeeService.FindByName(name);
//        return ResponseEntity.status(HttpStatus.OK).body(emp_list);
//    }
//
//   @GetMapping("/get-by-department/{dept}")
//    ResponseEntity<List<Employee>>Getbydept(@PathVariable String dept){
//        List<Employee>Dept_list=employeeService.FindByDepartment(dept);
//        return ResponseEntity.status(HttpStatus.OK).body(Dept_list);
//   }
//   @GetMapping("/get-by-name-dept/{name}")
//    ResponseEntity<List<Employee>>GetByNameAndDept(@PathVariable String name,@RequestParam String dept){
//
//        List<Employee>List=employeeService.FindByNameAndDepartment(name,dept);
//        return ResponseEntity.status(HttpStatus.OK).body(List);
//
//   }
//   @GetMapping("/search-by-key/{name}")
//    ResponseEntity<List<Employee>>SearchByKey(@PathVariable String name){
//        List<Employee>emp=employeeService.NameKeyword(name);
//        return ResponseEntity.status(HttpStatus.OK).body(emp);
//   }
 @PostMapping("/add")
 ResponseEntity<Employee>add(@RequestBody Employee emp){
        Employee add =employeeService.AddEmployeeWithCard(emp);

       return ResponseEntity.status(HttpStatus.CREATED).body(add);
 }

 @GetMapping("/get-employee/{id}")
    ResponseEntity<Employee>GetEmployeeById(@PathVariable int id){
        Employee emp=employeeService.EmployeeDetailWIthCard(id);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
 }

 @GetMapping("/get-card-by-Emp-id/{id}")
    ResponseEntity<Card>GetCardByEmpId(@PathVariable int id){
        Card c= employeeService.GetCardByEmployeeId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(c);
 }

 @GetMapping("/get-emp-by-card-id/{id}")
    ResponseEntity<Employee>GetEmployeeByCardId(@PathVariable int id){
        Employee emp=employeeService.GetEmployeeByCardId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(emp);
 }

 @PatchMapping("/update-card-by-emp-id/{id}")
    ResponseEntity<Card>UpdateCardByEmpId(@PathVariable int id,@RequestBody Card card){
     Card c=employeeService.UpdateCardByEmpId(id,card.getCardNumber());
     return ResponseEntity.status(HttpStatus.OK).body(c);
 }

 @DeleteMapping("/delete-card-by-empId/{id}")
 ResponseEntity<String>DeleteCardByEmpId(@PathVariable  int id){
        employeeService.DeleteCardByempId(id);

        return ResponseEntity.status(HttpStatus.OK).body("Card deleted");
 }
}
