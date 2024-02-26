package com.example.EmployeeDatabase.Controller;

import com.example.EmployeeDatabase.Entity.Employee;

import com.example.EmployeeDatabase.Entity.Project;
import com.example.EmployeeDatabase.Model.EmployeeModel;
import com.example.EmployeeDatabase.Model.ProjectModel;
import com.example.EmployeeDatabase.Service.EmployeeServiceImp;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeService;

    @RequestMapping("/first")
    public String firstpage(){
        System.out.println("THIS IS MY FIRST PAGE");
        return "first";
    }
    @RequestMapping("/addEmp")
    public String  addEmploye(){
        System.out.println("Employee Details:");
        return "addEmp";
    }

    @RequestMapping("/addedEmployee")
    public String addedEmployee(EmployeeModel employeeModel, ModelMap map, int empId){
        employeeService.addEmployee(employeeModel);
        map.addAttribute("employee",employeeModel);
        String name=employeeModel.getFirstName()+" "+employeeModel.getLastName();
        map.put("name",name);
        return "emp";
    }

    @RequestMapping("/delete")
    public String  delete(){
        System.out.println("Employee Details deleting:");
        return "delEmp";
    }
    @RequestMapping("/deleteEmployee")

    public String deleteEmployee(int empId,ModelMap model){
       //Employee employee = employeeService.getEmployeeById(empId);
     if(!employeeService.existEmp(empId)){ return "DataNotFound";}
        employeeService.delEmployee(empId);
        List< EmployeeModel> employeeList=employeeService.viewEmployees();
        model.addAttribute("EmployeeList",employeeList);
        return "viewEmp";
    }

    @RequestMapping("/viewEmp")
    public String viewEmploys(ModelMap model){
        List< EmployeeModel> employeeList=employeeService.viewEmployees();
        model.addAttribute("EmployeeList",employeeList);
        return "viewEmp";
    }


    @RequestMapping("/addPrjct")
    public String  addPrjct(){
        return "addPrjct";
    }

    @RequestMapping("/addedProject")
    public String addedProject(ProjectModel projectModel, ModelMap map){
        employeeService.addProjects(projectModel);
        map.addAttribute("project",projectModel);
        String name=projectModel.getName();
        map.put("name",name);
        return "prjct";
    }

    @RequestMapping("/assigningPrjct")
    public String assigningPrjct(ModelMap model,int empId){
        model.put("empId",empId);
        return "assigningPrjct";
    }

    @RequestMapping("/assignPrjct")
    public String assignPrjct(ModelMap model,int empId,int prjctid){
        employeeService.assignPrjct(empId,prjctid);
        List<ProjectModel> projectList= employeeService.getprojectsByEmployee(empId);
        model.addAttribute("projectList",projectList);
        return "viewEmpPrjct";
    }

    @RequestMapping("/RemoveProject")
    public String RemoveProject(int empId,int prjctid,ModelMap model){
        employeeService.remove(prjctid,empId);
        List<ProjectModel> projectList= employeeService.getprojectsByEmployee(empId);
        model.addAttribute("projectList",projectList);
        model.put("empId",empId);
        return "viewEmpPrjct";
    }
    @RequestMapping("/RemoveEmployee")
    public String RemoveEmployee(int empId,int prjctid,ModelMap model){
        employeeService.remove(prjctid,empId);
        List<EmployeeModel> EmployeeList= employeeService.getEmployeeByProject(prjctid);
        model.addAttribute("EmployeeList",EmployeeList);
        model.put("prjctid",prjctid);
        return "viewPrjctEmp";
    }

    @RequestMapping("/assigningEmployee")
    public String assigningEmployee(ModelMap model,int prjctid){
        model.put("prjctid",prjctid);
        return "assigningEmployee";
    }

    @RequestMapping("/assignEmployee")
    public String assignEmployee(ModelMap model,int empId,int prjctid){
        employeeService.assignPrjct(empId,prjctid);
        List<EmployeeModel> EmployeeList= employeeService.getEmployeeByProject(prjctid);
        model.addAttribute("EmployeeList",EmployeeList);
        model.put("prjctid",prjctid);
        return "viewPrjctEmp";
    }

    @RequestMapping("/viewEmpPrjct")
    public String viewEmpPrjct(int empId,ModelMap model){
        System.out.println("siddartha");
        List<ProjectModel> projectList= employeeService.getprojectsByEmployee(empId);
        model.addAttribute("projectList",projectList);
        model.put("empId",empId);
        return "viewEmpPrjct";
    }

    @RequestMapping("/viewPrjctEmp")
    public String viewPrjctEmp(ModelMap model,int prjctid){
        List<EmployeeModel> EmployeeList= employeeService.getEmployeeByProject(prjctid);
        model.addAttribute("EmployeeList",EmployeeList);
        model.put("prjctid",prjctid);
        return "viewPrjctEmp";
    }


    @RequestMapping("/viewPrjct")
    public String viewPrjct(ModelMap model){
        List<ProjectModel> projectList=employeeService.viewProjects();
        model.addAttribute("projectList",projectList);
        return "viewPrjct";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(int empId,ModelMap model){
        Employee employee = employeeService.getEmployeeById(empId);
       // if(!employeeService.existEmp(empId)){ return "DataNotFound";}*/
        System.out.println("Employee Details updated!!!!!"+empId);
        String firstName=employee.getFirstName();
        String lastName=employee.getLastName();
        String role=employee.getRole();
        int salary=employee.getSalary();
        model.addAttribute("empId",empId);
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("empId",empId);
        model.addAttribute("role",role);
        model.addAttribute("salary",salary);
        return "updating";
    }
    @RequestMapping("/updated")
    public String updated(int empId,String firstName,String lastName,String role,int sal,ModelMap model){
        employeeService.updateEmployee(empId,firstName, lastName, role,sal);
        List< EmployeeModel> employeeList=employeeService.viewEmployees();
        model.addAttribute("EmployeeList",employeeList);
        return "viewEmp";
    }


    @RequestMapping("/updateProject")
    public String updateProject(int prjctid,ModelMap model){
        Project project = employeeService.getProjectById(prjctid);
        String Name=project.getName();
        model.addAttribute("Name",Name);
        model.addAttribute("prjctid",prjctid);
        return "updatingp";
    }
    @RequestMapping("/updatedP")
    public String updated(int prjctid,String Name,ModelMap model){
        employeeService.updateProject(prjctid,Name);
        List<ProjectModel> projectList=employeeService.viewProjects();
        model.addAttribute("projectList",projectList);
        return "viewPrjct";
    }

    @RequestMapping("/deleteProject")

    public String deleteProject(int prjctid,ModelMap model){
        Project project = employeeService.getProjectById(prjctid);
        employeeService.delProject(prjctid);
        List<ProjectModel> projectList=employeeService.viewProjects();
        model.addAttribute("projectList",projectList);
        return "viewPrjct";
    }

    @RequestMapping("/DataNotFound")
    public String DataNotFound(){
        return "DataNotFound";
    }

    @RequestMapping("/search")
    public String  search(){
        System.out.println("Employee Details searching:");
        return "searchEmp";
    }

    @RequestMapping("/searchEmployee")
    public String searchEmployee(int employeeId,ModelMap model){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(!employeeService.existEmp(employeeId)){ return "DataNotFound";}
        System.out.println("Employee Details searched!!!!!" + employeeId);
        String name = employee.getFirstName() + " " + employee.getLastName();
        int empId = employee.getEmpId();
        String role = employee.getRole();
        int salary=employee.getSalary();
        model.addAttribute("name", name);
        model.addAttribute("empId", empId);
        model.addAttribute("role", role);
        model.addAttribute("salary", salary);
        return "searchedEmp";
    }


}
