package cse110m260t6.omnialarm;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by GING_CHAN on 3/11/2016.
 */
public class MathSolveTest extends TestCase {

    @Test
    public void testMath() {
        Math_Solve ms = new Math_Solve();
        int first = ms.getFirst();
        int second = ms.getSecond();
        int resultCalculated;

        if(ms.getOperator())
            resultCalculated = first + second;
        else
            resultCalculated = first - second;

        int resultFormulated = ms.getResult();

        assertEquals(resultFormulated, resultCalculated);
    }
}

