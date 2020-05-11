package pkg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.output.EmployeesOutput;
import pkg.parameters.DeptEduPayParameters;
import pkg.repository.PeopleRepository;

/**
 * Command line service for reporting
 */
@Service
public class CommandLineReportService implements ReportService {
    
    private static Logger log = LoggerFactory.getLogger(CommandLineReportService.class);
    
    @Autowired
    private PeopleRepository employeeRepository;
    
    @Autowired
    private EmployeesOutput employeesOutput;

    /**
     * Call the repository to retrieve data
     * and print the output using the injected outputter
     * 
     * @param params Parameters to filter data by
     */
    public void employeesByDeptEduPay(DeptEduPayParameters params) {        
        log.debug("Reporting on employees by dept, pay edu, paramaters: {}", params);
        
        employeesOutput.begin();
        
        employeeRepository.findByDeptEduPay(params.getDepartment(), params.getPayType(), params.getEduLevel())
            .stream()
            .peek(e -> log.debug("Matching employee {}", e))
            .forEach(employeesOutput::output);
        
        log.debug("Finished reporting on employees");
    }
}