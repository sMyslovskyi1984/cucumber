package utils;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Assertions {

    @Step("{2}")
    public static void shouldBeEqual(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, "\n" + message + "\n");
    }

    @Step("{2}")
    public static void shouldBeNotEqual(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, "\n" + message + "\n");
    }

    /**
     * Asserts that {@code condition} is {@code true}. {@code message} will
     * appear in the report as a step, regardless of the status (PASSED, FAILED,
     * SKIPPED) of test. Thus, the best format for the message is to use SHOULD
     * verb, as in 'something should be true'.
     *
     * @param condition
     * @param message   in format 'something should be true'
     */
    @Step("{1}")
    public static void shouldBeTrue(boolean condition, String message) {
        Assert.assertTrue(condition, "\n" + message + "\n");
    }

    /**
     * Asserts that {@code condition} is {@code false}. {@code message} will
     * appear in the report as a step, regardless of the status (PASSED, FAILED,
     * SKIPPED) of test. Thus, the best format for the message is to use SHOULD
     * verb, as in 'something should be false'.
     *
     * @param condition
     * @param message   in format 'something should be false'
     */
    @Step("{1}")
    public static void shouldBeFalse(boolean condition, String message) {
        Assert.assertFalse(condition, "\n" + message + "\n");
    }

    private static void analyzeFields(Set<?> actualKeys, Set<?> expectedKeys) {
        SoftAssert soft = new SoftAssert();
        // verify that each key is expected
        for (Object actKey : actualKeys) {
            soft.assertTrue(expectedKeys.contains(actKey),
                    "\nField <" + actKey + "> is not expected, but is present in the actual result.\n");
        }

        for (Object expKey : expectedKeys) {
            soft.assertTrue(actualKeys.contains(expKey),
                    "\nField <" + expKey + "> is expected, but is not present in the actual result.\n");
        }
        soft.assertAll();
    }

    /**
     * Verifies that {@code actualList} equals to {@code expectedList}. Equality
     * means that each item from {@code actualList} is expected (i.e. is present
     * in {@code expectedList}), and each item from {@code expectedList} is
     * present in {@code actualList}. The order may be ignored.
     *
     * @param actualList
     * @param expectedList
     * @param message
     */
    @Step("{2}")
    public static <T> void listsShouldBeEqual(List<T> actualList, List<T> expectedList, String message) {
        analyzeLists(actualList, expectedList);
    }

    @Step("{2}")
    public static void listsShouldBeEqualIgnoringCase(List<String> actualList, List<String> expectedList, String message) {
        actualList = actualList.stream().map(String::toLowerCase).collect(Collectors.toList());
        expectedList = expectedList.stream().map(String::toLowerCase).collect(Collectors.toList());
        analyzeLists(actualList, expectedList);
    }

    private static <T> void analyzeLists(List<T> actualList, List<T> expectedList) {
        SoftAssert soft = new SoftAssert();

        for (Object actualElement : actualList) {
            soft.assertTrue(expectedList.contains(actualElement),
                    "\nElement <" + actualElement + "> is not expected, but is present in actual result. \n");
        }

        for (Object expectedElement : expectedList) {
            soft.assertTrue(actualList.contains(expectedElement),
                    "\nElement <" + expectedElement + "> is expected, but is not present in actual result. \n");
        }
        soft.assertAll();
    }

    @Step("{2}")
    public static <T> void listsShouldBeEqual(Collection<List<T>> actualList, Collection<List<T>> expectedList, String message) {
        analyzeLists(actualList, expectedList);
    }

    private static <T> void analyzeLists(Collection<List<T>> actualList, Collection<List<T>> expectedList) {
        SoftAssert soft = new SoftAssert();

        for (Object actualElement : actualList) {
            soft.assertTrue(expectedList.contains(actualElement),
                    "\nElement <" + actualElement + "> is not expected, but is present in actual result. \n");
        }

        for (Object expectedElement : expectedList) {
            soft.assertTrue(actualList.contains(expectedElement),
                    "\nElement <" + expectedElement + "> is expected, but is not present in actual result. \n");
        }
        soft.assertAll();
    }

    @Step("{2}")
    public static <T> void listsShouldContainEqualData(List<T> actualList, List<T> expectedList, String message) {
        SoftAssert soft = new SoftAssert();
        for (Object expectedElement : expectedList) {
            soft.assertTrue(actualList.contains(expectedElement),
                    "\nElement <" + expectedElement + "> is expected, but is not present in actual result. \n");
        }
        soft.assertEquals(actualList.size(), expectedList.size(), "Lists size are different");

        soft.assertAll();
    }

    @Step("{2}. Expected [{0}] to be in {1}")
    public static <T> void listShouldContain(T actualElem, List<T> expectedList, String message) {
        Assert.assertTrue(expectedList.contains(actualElem), message);
    }

    @Step("{2}")
    public static void listShouldContainIgnoringCase(String actualElem, List<String> expectedList, String message) {
        expectedList = expectedList.stream().map(String::toLowerCase).collect(Collectors.toList());
        Assert.assertTrue(expectedList.contains(actualElem.toLowerCase()), message);
    }

    @Step("{2}")
    public static void listShouldContainIgnoringCase(List<String> actualList, List<String> expectedList, String message) {
        expectedList = expectedList.stream().map(String::toLowerCase).collect(Collectors.toList());
        actualList = actualList.stream().map(String::toLowerCase).collect(Collectors.toList());

        SoftAssert soft = new SoftAssert();
        for (String actualElement : actualList) {
            soft.assertTrue(expectedList.contains(actualElement),
                    "\nElement <" + actualElement + "> is expected but not present.\n");
        }

        soft.assertAll();
    }

    @Step("{2}. Expected [{0}] to not be in {1}")
    public static <T> void listShouldNotContain(String actualElem, List<T> expectedList, String message) {
        Assert.assertTrue(!expectedList.contains(actualElem), message);
    }
}
