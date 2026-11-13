package com.abes.employeeapi.Service;

import com.abes.employeeapi.DTO.DepartmentRequestDto;
import com.abes.employeeapi.DTO.EmployeeRequestDto;
import com.abes.employeeapi.DTO.EmployeeResponseDto;
import com.abes.employeeapi.Entity.Department;
import com.abes.employeeapi.Entity.Employee;
import com.abes.employeeapi.Repository.DepartmentRepo;
import com.abes.employeeapi.Repository.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;


    public EmployeeService(EmployeeRepo e, DepartmentRepo d){
        this.employeeRepo=e;
        this.departmentRepo=d;
    }

    // add employee when client fill department entity
    public void add(DepartmentRequestDto d){
        Optional<Department>deptList=departmentRepo.findByDeptName(d.getDepartmentName());
     if(deptList.isEmpty()){
         Department newDepartment=new Department();
         newDepartment.setDeptName(d.getDepartmentName());
         departmentRepo.save(newDepartment);
         for(EmployeeRequestDto empDto:d.getEmpList()){
             Employee newEmp=new Employee();
             newEmp.setEmployeeName(empDto.getEmployeeName());
             newDepartment.addEmployees(newEmp);
             newEmp.setDepartment(newDepartment);
             employeeRepo.save(newEmp);
         }

     }

     else{
         Department oldDepartment=deptList.get();
         for(EmployeeRequestDto empDto:d.getEmpList()){
             Employee newEmp=new Employee();
             newEmp.setEmployeeName(empDto.getEmployeeName());
             oldDepartment.addEmployees(newEmp);
             newEmp.setDepartment(oldDepartment);
             employeeRepo.save(newEmp);
         }
     }

    }

    //get all employee
    public List<EmployeeResponseDto>GetAll(){
        List<Employee>getAll=employeeRepo.findAll(Sort.by("employeeId").ascending());
        if(getAll.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO EMPLOYEE EXITS");
        }

        return getAll.stream()
                .map(e->new EmployeeResponseDto(
               e.getEmployeeId(),
               e.getEmployeeName(),
               e.getDepartment().getDeptName()

        )).toList();
    }

    // find by employee id
    public EmployeeResponseDto getById(int id){
        Optional<Employee>empList =employeeRepo.findById(id);
        if(empList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO EMPLOYEE WITH THIS ID");
        }
        Employee emp=empList.get();
        EmployeeResponseDto newEmpDto=new EmployeeResponseDto(emp.getEmployeeId(),emp.getEmployeeName(),emp.getDepartment().getDeptName());
        return newEmpDto;
    }

    // find by department all employee
    public List<EmployeeResponseDto>getAllEmployee(String name){
        List<Employee>empList=employeeRepo.findByDepartment_DeptName(name);
        if(empList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NO SUCH DEPARTMENT EXIT");
        }
        return empList.stream()
                .map(employee -> new EmployeeResponseDto(
                        employee.getEmployeeId(),
                        employee.getEmployeeName(),
                        employee.getDepartment().getDeptName()
                )).toList();
    }

    //delete emp emp id
    public void deleteByEmpId(int id){//
        Optional<Employee> empList = employeeRepo.findById(id);
        if (empList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EMPLOYEE NOT FOUND");
        }

        Employee employee = empList.get();

        Department department = employee.getDepartment();

        if (department != null) {
            department.getEmployees().remove(employee);
        }
        employeeRepo.delete(employee);
}

//total count of emplyee
    public long totalCountEmp(){
        long count=employeeRepo.count();
        return count;
    }

    //total count of Department
    public long totalCountDept(){
        long count=departmentRepo.count();
        return count;
    }
}






