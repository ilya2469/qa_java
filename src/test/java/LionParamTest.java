
package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {

    @Parameterized.Parameters(name = "{index}: sex={0} -> hasMane={1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Parameterized.Parameter(0)
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expectedHasMane;

    @Test
    public void maneDependsOnSex() throws Exception {
        assertEquals(expectedHasMane, new Lion(sex, new Feline()).doesHaveMane());
    }
}
