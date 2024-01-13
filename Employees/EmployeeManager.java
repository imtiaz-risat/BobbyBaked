package Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager implements EmployeeManagement {
    public static Scanner scanner = new Scanner(System.in);
    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        // Additional logic for employee addition
    }

    @Override
    public void updateEmployee() {
        System.out.println("Enter employee ID to update: ");
        int id = scanner.nextInt();

        Employee empToUpdate = getEmployeeById(id);
        displayEmployeeDetails(empToUpdate);
        if (empToUpdate != null) {
            System.out.println("Enter new name: ");
            String name = scanner.next();
            empToUpdate.setName(name);
            System.out.println("Employee details updated!");
        } else {
            System.out.println("No employee found with ID " + id);
        }
    }

    @Override
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    private void displayEmployeeDetails(Employee empToUpdate) {
        if (empToUpdate != null) {
            System.out.println("ID: " + empToUpdate.getId());
            System.out.println("Name: " + empToUpdate.getName());
        }
    }

    private Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        System.out.println("Employee not found!");
        return null;
    }
}