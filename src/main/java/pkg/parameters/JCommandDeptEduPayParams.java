package pkg.parameters;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

/**
 * Arguments for a department, pay and education
 * 
 * Parsed by JCommander
 *
 */
public class JCommandDeptEduPayParams implements DeptEduPayParameters {
    
    @Parameter(names = { "--department" }, required = true, validateWith=LetterNumberSpaceValidator.class)
    private String department = null;

    @Parameter(names = "--pay-type", required = true, validateWith=LetterNumberSpaceValidator.class)
    private String payType = null;
    
    @Parameter(names = "--education-level", required = true, validateWith=LetterNumberSpaceValidator.class)
    private String educationLevel = null;
    
    /**
     * If a non -- parameter is present, required parameters aren't requested without this
     */
    @Parameter(description = "Main")
    private List<String> files = new ArrayList<>();

    /* (non-Javadoc)
     * @see pkg.parameters.DeptEduPayParameters#getDepartment()
     */
    @Override
    public String getDepartment() {
        return department;
    }

    /* (non-Javadoc)
     * @see pkg.parameters.DeptEduPayParameters#getPayType()
     */
    @Override
    public String getPayType() {
        return payType;
    }

    /* (non-Javadoc)
     * @see pkg.parameters.DeptEduPayParameters#getEduLevel()
     */
    @Override
    public String getEduLevel() {
        return educationLevel;
    }

    @Override
    public String toString() {
        return "Arguments [department=" + department + ", payType=" + payType + ", educationLevel=" + educationLevel
                + "]";
    }
}