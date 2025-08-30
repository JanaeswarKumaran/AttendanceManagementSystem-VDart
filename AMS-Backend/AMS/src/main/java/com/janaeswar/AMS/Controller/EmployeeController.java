package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Modal.Employee;
import com.janaeswar.AMS.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addemployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/getemployeebyid/{agencyId}")
    public ResponseEntity<?> getEmployeeByAgencyId(@PathVariable String agencyId) {
        return employeeService.getEmployeeByAgencyId(agencyId);
    }

    @PutMapping("/updateemployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/getemployeebyphonenumber")
    public ResponseEntity<?> getEmployeeByPhoneNumber(@RequestParam long phoneNumber) {
        return employeeService.getEmployeeByPhoneNumber(phoneNumber);
    }
}
