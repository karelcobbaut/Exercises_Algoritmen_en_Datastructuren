package week7infix;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.Assert;

public class SimpleTest {

    InfixToPostfix fixer = new StackInfixToPostfix();

    private String infixToPostfix(String infix) {
        return fixer.infixToPostfix(Arrays.asList(infix.split(" ")))
                    .stream().collect(Collectors.joining(" "));
    }

    @Test
    public void testConstant() {
        Assert.assertEquals("123", infixToPostfix("123"));
    }

    @Test
    public void testAddition() {
        Assert.assertEquals("1 2 +", infixToPostfix("1 + 2"));
    }

    @Test
    public void testSubstraction() {
        Assert.assertEquals("1 2 -", infixToPostfix("1 - 2"));
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals("1 2 *", infixToPostfix("1 * 2"));
    }

    @Test
    public void testDivision() {
        Assert.assertEquals("1 2 /", infixToPostfix("1 / 2"));
    }

    @Test
    public void testParenthesisLeft() {
        Assert.assertEquals("1 2 3 + *", infixToPostfix("1 * ( 2 + 3 )"));
    }

    @Test
    public void testParenthesisRight() {
        Assert.assertEquals("1 2 + 3 *", infixToPostfix("( 1 + 2 ) * 3"));
    }

    @Test
    public void testParenthesisRight2() {
        Assert.assertEquals("1 2 3 * 4 / + 24 25 4 / 3 + * - 2 +", infixToPostfix("( 1 + 2 * 3 / 4 - 24 * ( 25 / 4 + 3 ) ) + 2"));
    }
    @Test
    public void testParenthesisRight1() {
        Assert.assertEquals("1 1 + 1 + 2 3 * 4 / + 24 25 * 4 / - 3 + 2 +", infixToPostfix("1 + 1 + 1 + 2 * 3 / 4 - 24 * 25 / 4 + 3 + 2"));
    }

    @Test
    public void testParenthesisRight21() {
        Assert.assertEquals("43 32 37 * 98 71 - * 19 61 * 79 * 23 17 * - + 39 * + 37 -", infixToPostfix("( 43 + ( ( ( 32 * 37 ) * ( 98 - 71 ) ) + ( ( ( 19 * 61 ) * 79 ) - 23 * 17 ) ) * 39 - 37 )"));
    }
}
