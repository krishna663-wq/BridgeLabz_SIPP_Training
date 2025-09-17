class EmployeeRecordSystem {
    public int employeeID;
    protected String department;
    private double salary;

    public EmployeeRecordSystem(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void updateSalary(double newSalary) {
        salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends EmployeeRecordSystem {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerInfo() {
        System.out.println("Manager ID: " + employeeID + ", Department: " + department);
    }
}