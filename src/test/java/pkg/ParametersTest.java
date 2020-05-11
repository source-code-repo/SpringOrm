package pkg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import pkg.parameters.DeptEduPayParameters;
import pkg.parameters.JCommandDeptEduPayParams;

/**
 * Tests command line parameter parsing and validation
 */
public class ParametersTest {
    private static final String DEPARTMENT = "--department";
    private static final String EDUCATION_LEVEL = "--education-level";
    private static final String PAY_TYPE = "--pay-type";
    
    private static final String PERMANENT_CHECKERS = "Permanent Checkers";
    private static final String BACHELORS_DEGREE = "Bachelors Degree";
    private static final String MONTHLY = "Monthly";
    private static final String INVALID_PARAM = "!^&&**&^";

    @Test
    public void valid() {
        DeptEduPayParameters params = parse(new String[] { 
                DEPARTMENT, PERMANENT_CHECKERS, 
                EDUCATION_LEVEL, BACHELORS_DEGREE, 
                PAY_TYPE, MONTHLY });
        
        assertEquals(PERMANENT_CHECKERS, params.getDepartment());
        assertEquals(BACHELORS_DEGREE, params.getEduLevel());
        assertEquals(MONTHLY, params.getPayType());
    }
    
    @Test(expected=ParameterException.class)
    public void missingDept() {
        parse(new String[] { 
                EDUCATION_LEVEL, BACHELORS_DEGREE,
                PAY_TYPE, MONTHLY });
    }
    
    @Test(expected=ParameterException.class)
    public void missingEdu() {
        parse(new String[] { 
                DEPARTMENT, PERMANENT_CHECKERS, 
                PAY_TYPE, MONTHLY });
    }
    
    @Test(expected=ParameterException.class)
    public void missingPay() {
        parse(new String[] { 
                DEPARTMENT, PERMANENT_CHECKERS, 
                EDUCATION_LEVEL, BACHELORS_DEGREE});
    }
    
    @Test(expected=ParameterException.class)
    public void noParams() {
        parse(new String[] {});
    }
    
    @Test(expected=ParameterException.class)
    public void missingEduPay() {
        parse(new String[] { DEPARTMENT, PERMANENT_CHECKERS });
    }
    
    @Test(expected=ParameterException.class)
    public void invalidDept() {
        parse(new String[] { 
                DEPARTMENT, INVALID_PARAM,
                EDUCATION_LEVEL, BACHELORS_DEGREE,
                PAY_TYPE, MONTHLY });
    }
    
    @Test(expected=ParameterException.class)
    public void invalidEdu() {
        parse(new String[] { 
                DEPARTMENT, PERMANENT_CHECKERS,
                EDUCATION_LEVEL, INVALID_PARAM,
                PAY_TYPE, MONTHLY });
    }
    
    @Test(expected=ParameterException.class)
    public void invalidPay() {
        parse(new String[] { 
                DEPARTMENT, PERMANENT_CHECKERS,
                EDUCATION_LEVEL, BACHELORS_DEGREE,
                PAY_TYPE, INVALID_PARAM });
    }
    
    public DeptEduPayParameters parse(String[] unparsedArgs) {
        DeptEduPayParameters params = new JCommandDeptEduPayParams();
        
        JCommander.newBuilder()
            .addObject(params)
            .build()
            .parse(unparsedArgs);
        
        return params;
    }
}
