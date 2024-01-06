package Employees;

public class EmployeeManager implements EmployeeManagement {
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
    public void updateEmployee(Employee employee) {
        // Implementation to update employee details
        // Placeholder, actual implementation needed
        System.out.println("Employee updated: " + employee.getName());
    }

    @Override
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        // Additional logic for employee removal
    }
}