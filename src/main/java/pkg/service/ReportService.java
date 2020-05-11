package pkg.service;

import pkg.parameters.DeptEduPayParameters;

/**
 * Service to report data
 */
public interface ReportService {
    
    /**
     * Report on employees filtered by department, pay and education
     * 
     * @param params Parameters to filter by
     */
    public void employeesByDeptEduPay(DeptEduPayParameters params);
}