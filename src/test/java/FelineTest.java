package com.example;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), new Feline().eatMeat());
    }

    @Test
    public void getFamilyReturnsFelidae() {
        assertEquals("Кошачьи", new Feline().getFamily());
    }

    @Test
    public void getKittensDefaultIsOne() {
        assertEquals(1, new Feline().getKittens());
    }

    @Test
    public void getKittensReturnsPassedValue() {
        assertEquals(5, new Feline().getKittens(5));
    }
}
