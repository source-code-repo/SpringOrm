package pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.beust.jcommander.JCommander;

import pkg.parameters.DeptEduPayParameters;
import pkg.parameters.JCommandDeptEduPayParams;
import pkg.service.ReportService;

/**
 * Spring boot command line application provide reporting
 * services from a relational database
 */
@SpringBootApplication
public class Main implements CommandLineRunner {
    
    @Autowired
    private ReportService reportService;

    public static void main(String[] args) {
        try {
            SpringApplication.run(Main.class, args);
        } catch(Exception e) {
            System.out.println("An unexpected error occured. Please see "
                    + "log for details.\n" + e.getMessage());
        }
    }

    /**
     * Spring calls this method when the ApplicationContext is ready
     * 
     * Parse command line arguments, pass to the report service
     */
    @Override
    public void run(String... unparsedArgs) throws Exception {
        DeptEduPayParameters params = new JCommandDeptEduPayParams();
        
        JCommander.newBuilder()
            .addObject(params)
            .build()
            .parse(unparsedArgs);
        
        reportService.employeesByDeptEduPay(params);
    }
}