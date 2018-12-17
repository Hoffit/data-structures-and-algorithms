package multibracketvalidation;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

//TODO
public class MultiBracketValidationTest {

    @Test
    public void testMultiBracketValidationMethod() {
        assertTrue(MultiBracketValidation.multiBracketValidation("()"));
        assertTrue(MultiBracketValidation.multiBracketValidation("{}"));
        assertTrue(MultiBracketValidation.multiBracketValidation("{}(){}"));
        assertTrue(MultiBracketValidation.multiBracketValidation("()[[Extra Characters]]"));
        assertTrue(MultiBracketValidation.multiBracketValidation("(){}[[]]"));
        assertTrue(MultiBracketValidation.multiBracketValidation("{}{Code}[Fellows](())"));
        assertFalse(MultiBracketValidation.multiBracketValidation("[({}]"));
        assertFalse(MultiBracketValidation.multiBracketValidation("(]("));
        assertFalse(MultiBracketValidation.multiBracketValidation("{(})"));
    }
}
