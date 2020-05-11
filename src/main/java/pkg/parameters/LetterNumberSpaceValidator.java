package pkg.parameters;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * Validates parameters consist of only letters and numbers
 *
 */
public class LetterNumberSpaceValidator implements IParameterValidator {
    private static final String LETTERS_NUMBER_SPACES = "[0-9a-zA-Z ]+";

    /**
     * Check value only for presence of non letters / numbers
     */
    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches(LETTERS_NUMBER_SPACES)) {
            throw new ParameterException("Invalid value for parameter " + name);
        }
    }
}