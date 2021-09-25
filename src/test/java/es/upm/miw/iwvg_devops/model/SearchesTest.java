package es.upm.miw.iwvg_devops.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchesTest {

    @Test
    public void testFindFirstDecimalFractionByUserName() {
        Assertions.assertEquals(2.0, Searches.findFirstDecimalFractionByUserName("Ana"), 10e-5);
    }

    @Test
    public void testFindFractionDivisionByUserId() {
        Assertions.assertEquals(new Fraction(-48, 60), Searches.findFractionDivisionByUserId("3"));
    }
}
