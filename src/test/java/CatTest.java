package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void catMakesCorrectSound() {
        assertEquals("Мяу", new Cat(feline).getSound());
    }

    @Test
    public void catReturnsFoodFromFeline() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);
        assertEquals(expected, new Cat(feline).getFood());
    }

    @Test
    public void catAsksFelineForFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of());
        new Cat(feline).getFood();
        verify(feline).eatMeat();
    }
}
