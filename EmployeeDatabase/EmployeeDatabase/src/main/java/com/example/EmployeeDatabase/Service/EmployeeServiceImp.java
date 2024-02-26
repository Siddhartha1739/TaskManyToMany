package com.example.EmployeeDatabase.Service;

import com.example.EmployeeDatabase.Entity.Employee;
import com.example.EmployeeDatabase.Entity.Project;
import com.example.EmployeeDatabase.Model.EmployeeModel;
import com.example.EmployeeDatabase.Model.ProjectModel;
import com.example.EmployeeDatabase.Repository.EmployeeRepository;
import com.example.EmployeeDatabase.Repository.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImp {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public void addEmployee(EmployeeModel employeeModel) {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeModel,employee);
        employeeRepository.save(employee);
    }

    public void remove(int prjctid, int empId) {
        Employee employee=employeeRepository.getReferenceById(empId);
        Project project=projectRepository.getReferenceById(prjctid);

        List<Project> projectList = employee.getProjects();
        List<Employee> employeeList=project.getEmployees();

        projectList.remove(project);
        employeeList.remove(employee);

        employee.setProjects(projectList);
        project.setEmployees(employeeList);

        employeeRepository.save(employee);
        projectRepository.save(project);
    }
    public void delProject(int prjctid) {
        Project project=projectRepository.getReferenceById(prjctid);
        List<Employee> employeeList=project.getEmployees();

        for(Employee employee: employeeList){
            List<Project> projectList=employee.getProjects();
            if(projectList.contains(project)){
                projectList.remove(project);
                employee.setProjects(projectList);
                employeeRepository.save(employee);
            }
        }

        project.setEmployees(new ArrayList<>());
        projectRepository.delete(project);
    }

    public void delEmployee(int empId) {
        Employee employee=employeeRepository.getReferenceById(empId);
        List<Project> projectList=employee.getProjects();

        for(Project project: projectList){
            List<Employee> employeeList=project.getEmployees();
            if(employeeList.contains(employee)){
                employeeList.remove(employee);
                project.setEmployees(employeeList);
                projectRepository.save(project);
            }
        }
        employee.setProjects(new ArrayList<>());
        employeeRepository.delete(employee);
    }

    public Employee getEmployeeById(int empId) {
        return employeeRepository.getReferenceById(empId);
    }

    public List<EmployeeModel> viewEmployees() {
        List<Employee> employeList= (List<Employee>) employeeRepository.findAll();
        List<EmployeeModel> employeeModelList=new ArrayList<>();

        employeList.forEach(emp -> {
            EmployeeModel employeeModel=new EmployeeModel();
            BeanUtils.copyProperties(emp,employeeModel);
            employeeModelList.add(employeeModel);
        });
        return employeeModelList;
    }


    public void addProjects(ProjectModel projectModel){
        Project project=new Project();
        BeanUtils.copyProperties(projectModel,project);
        projectRepository.save(project);

    }

    public void assignPrjct(int empId,int prjctid){
        Employee employee = employeeRepository.getReferenceById(empId);
        Project project = projectRepository.getReferenceById(prjctid);

        List<Employee> employeeList = project.getEmployees();
        List<Project> projectList = employee.getProjects();
        if (!employeeList.contains(employee) && !projectList.contains(project) ) {
            employeeList.add(employee);
            projectList.add(project);
        }


        employee.setProjects(projectList);
        project.setEmployees(employeeList);

        employeeRepository.save(employee);
        projectRepository.save(project);

    }

    public List<ProjectModel> viewProjects() {
        List<Project> projectList= (List<Project>) projectRepository.findAll();
        List<ProjectModel> projectModelList=new ArrayList<>();

        projectList.forEach(lib -> {
            ProjectModel projectModel=new ProjectModel();
            BeanUtils.copyProperties(lib,projectModel);
            projectModelList.add(projectModel);
        });
        return projectModelList;
    }
    public List<ProjectModel> getprojectsByEmployee(int empId){
        Employee employee=employeeRepository.getReferenceById(empId);
        List<Project> projectList=employee.getProjects();
        List<ProjectModel> projectModelList=new ArrayList<>();
        projectList.forEach(project -> {
            ProjectModel projectModel=new ProjectModel();
            BeanUtils.copyProperties(project,projectModel);
            projectModelList.add(projectModel);
        });
        return projectModelList;
    }
    public List<EmployeeModel> getEmployeeByProject(int prjctid){
        Project project=projectRepository.getReferenceById(prjctid);
        List<Employee> employeeList=project.getEmployees();
        List<EmployeeModel> employeeModelList=new ArrayList<>();
        employeeList.forEach(employee -> {
            EmployeeModel employeeModel=new EmployeeModel();
            BeanUtils.copyProperties(employee,employeeModel);
            employeeModelList.add(employeeModel);
        });
        return employeeModelList;
    }

    public boolean existPrjct(int prjctid){
        return projectRepository.existsById(prjctid);
    }



    public boolean existEmp(int empId){
        return employeeRepository.existsById(empId);
    }

    public Project getProjectById(int prjctid) {
        return projectRepository.getReferenceById(prjctid);
    }

    public void updateEmployee(int empId,String firstName,String lastName,String role,int sal){
        Employee employee=employeeRepository.getReferenceById(empId);
        String fName=employee.getFirstName();
        String lName=employee.getLastName();
        String emprole= employee.getRole();
        int salary=employee.getSalary();
        fName=firstName;
        lName=lastName;
        emprole=role;
        salary=sal;
        employee.setFirstName(fName);
        employee.setLastName(lName);
        employee.setSalary(salary);
        employee.setRole(emprole);
        employeeRepository.save(employee);
    }

    public void updateProject(int prjctid,String Name){
        Project project=projectRepository.getReferenceById(prjctid);
        String PName=project.getName();
        PName=Name;
        project.setName(PName);
        projectRepository.save(project);
    }

}
