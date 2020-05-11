package pkg.output;

import pkg.entity.People;

/**
 * An interface for outputting lists of employees
 *
 */
public interface EmployeesOutput {
    
    /**
     * Called when a list of employee data starts to output
     */
    public void begin();
    
    /**
     * Called each time an employee's data is to be output
     * @param employee
     */
    public void output(People employee);
}