package es.upm.miw.iwvg_devops.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchesTest {

    @Test
    public void testFindFirstDecimalFractionByUserName() {
        Assertions.assertEquals(2.0, Searches.findFirstDecimalFractionByUserName("Ana"), 10e-5);
    }

    @Test
    public void testFindFractionDivisionByUserId() {
        Assertions.assertEquals(new Fraction(-48, 60), Searches.findFractionDivisionByUserId("3"));
    }

    @Test
    public void testFindUserIdByAllProperFraction() {
        ArrayList<String> userIds = new ArrayList<String>();
        userIds.add("1");
        Assertions.assertEquals(userIds, Searches.findUserIdByAllProperFraction().collect(Collectors.toList()));
    }

    @Test
    public void testFindUserIdBySomeProperFraction() {
        ArrayList<String> userIds = new ArrayList<String>();
        userIds.add("1");
        userIds.add("2");
        userIds.add("3");
        userIds.add("5");
        Assertions.assertEquals(userIds, Searches.findUserIdBySomeProperFraction().collect(Collectors.toList()));
    }
}
