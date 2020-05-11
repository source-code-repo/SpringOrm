package pkg.output;

import org.springframework.stereotype.Component;

import pkg.entity.People;

/**
 * Output list of employees to the console
 *
 */
@Component
public class EmployeesConsoleOutput implements EmployeesOutput {

    /**
     * @see EmployeesOutput#begin()
     */
    @Override
    public void begin() {
        System.out.println("Employees: \n");
    }

    /**
     * @see EmployeesOutput#output()
     */
    @Override
    public void output(People employee) {
        System.out.println(employee.getFullName());
    }

}