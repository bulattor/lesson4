package ru.tinkoff.fintech.lesson4

import io.mockk.impl.annotations.SpyK
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MyStackTest {

    @SpyK
    var myStack = MyStack<String>()

    @Test
    fun peek() {
        assertEquals(null, myStack.peek())
        myStack.push("kek")
        myStack.push("bad")
        assertEquals("bad", myStack.peek())
    }

    @Test
    fun pop() {
        assertEquals(null, myStack.pop())
        myStack.push("kek")
        myStack.push("bad")
        assertEquals("bad", myStack.pop())
        assertEquals("kek", myStack.peek())
    }
}