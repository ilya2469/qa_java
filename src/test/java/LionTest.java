
package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionDelegatesKittensToFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        assertEquals(3, new Lion("Самец", feline).getKittens());
    }

    @Test
    public void lionCallsFelineGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(0);
        new Lion("Самец", feline).getKittens();
        verify(feline).getKittens();
    }

    @Test
    public void lionGetsFoodFromFelinePredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expected);
        assertEquals(expected, new Lion("Самец", feline).getFood());
    }

    @Test
    public void lionCallsFelineGetFoodWithPredatorArg() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of());
        new Lion("Самец", feline).getFood();
        verify(feline).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void constructorThrowsOnInvalidSex() throws Exception {
        new Lion("не корректный", feline);
    }
}
