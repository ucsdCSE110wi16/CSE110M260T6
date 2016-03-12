package cse110m260t6.omnialarm;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

/**
 * Created by Sylvia on 3/7/2016.
 */
public class ReverseStringTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testReverseNotNull() {
        Reverse_String rs = new Reverse_String();

        assertNotNull(rs);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
