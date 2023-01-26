package com.example.calculator

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun isNameCorrect(){
        val input = "Daniella"
        Assert.assertEquals("Daniella", input)
    }

    @Test
    fun memangTest(){
        val domINIC = 123
        Assert.assertNotSame(321, domINIC)
    }
}