    import java.util.ArrayList;

    abstract class Employee {
        private String name;

        private int id;

        public Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName(){
            return name;
        }
        public int getId(){
            return id;
        }
        public abstract double calculateSalary();

        @Override
        public String toString(){
            return "Employee[name=" +name+", id = "+id+", salary = "+calculateSalary()+"]";
        }
    }

    class fullTimeEmployee extends Employee {

        private double monthlySalary;
        public fullTimeEmployee(String name, int id, double monthlySalary) {
            super(name, id);
            this.monthlySalary = monthlySalary;
        }
        @Override
        public double calculateSalary() {
            return monthlySalary;
        }
    }

    class partTimeEmployee extends Employee {
        private int hoursWorked;
        private double hourlyRateySalary;

        public partTimeEmployee(String name, int id, double hourlyRateySalary, int hoursWorked) {
            super(name, id);
            this.hourlyRateySalary = hourlyRateySalary;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public double calculateSalary() {
            return hourlyRateySalary * hoursWorked;
        }

        }

        class PayrollSystem{

        private ArrayList<Employee> employeeList;

        public PayrollSystem(){
            employeeList = new ArrayList<>();
        }
        public void addEmployee(Employee employee){
            employeeList.add(employee);
        }

        public void removeEmployee(int id){
            Employee employeeToRemove = null;
            for(Employee employee: employeeList) {
                if (employee.getId() == id) {
                    employeeToRemove = employee;
                    break;
                }
            }
            if(employeeToRemove != null){
                        employeeList.remove(employeeToRemove);
            }
        }
        public void displayEmployees(){
            for(Employee employee: employeeList){
                System.out.println(employee);
            }
        }

        }

    public class Main {
        public static void main(String[] args) {
            PayrollSystem payrollSystem = new PayrollSystem();
            fullTimeEmployee emp1 = new fullTimeEmployee("Vikash", 1, 10000);
            fullTimeEmployee emp2 = new fullTimeEmployee("Himanshu", 2, 70000);
            partTimeEmployee emp3 = new partTimeEmployee("Manish",3,100,40);

            payrollSystem.addEmployee(emp1);
            payrollSystem.addEmployee(emp2);
            payrollSystem.addEmployee(emp3);
            System.out.println("Initial Employee Details:");
            payrollSystem.displayEmployees();
            System.out.println("Removing Employee");
            payrollSystem.removeEmployee(2);
            payrollSystem.displayEmployees();



        }
    }