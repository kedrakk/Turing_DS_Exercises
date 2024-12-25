/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author kedk
 */
public class DelimiterTest {

    Delimiter delimiter = new Delimiter();

    @ParameterizedTest
    @CsvSource({"'',true", "c[d],true", "c[d,false", "a{bc}d,true", "a{bcd,false", "a[b{c}d]e,true", "a[b{c}d]e},false", "a[b(c),false"})
    void testDelimiterWithParameterizedTest(String input, Boolean expected) {
        Boolean acutal = delimiter.isValid(input);
        assertEquals(expected, acutal);
    }
}
