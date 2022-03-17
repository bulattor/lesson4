package ru.tinkoff.fintech.lesson4

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
@ExtendWith(MockKExtension::class)
class MyQueueTest {

    @SpyK
    var myQueue = MyQueue<String>()

    @Test
    fun element() {
        try {
            myQueue.element()
        } catch (e: Exception) {
            assertEquals(true, e is NoSuchElementException)
        }
        myQueue.offer("kek")
        myQueue.offer("bad")
        assertEquals("kek", myQueue.element())
    }

    @Test
    fun remove() {
        try {
            myQueue.element()
        } catch (e: Exception) {
            assertEquals(true, e is NoSuchElementException)
        }
        myQueue.offer("kek")
        myQueue.offer("bad")
        assertEquals("kek", myQueue.remove())
        assertEquals("bad", myQueue.peek())
    }

    @Test
    fun peek() {
        assertEquals(null, myQueue.peek())
        myQueue.offer("kek")
        myQueue.offer("bad")
        assertEquals("kek", myQueue.peek())
    }

    @Test
    fun poll() {
        assertEquals(null, myQueue.poll())
        myQueue.offer("kek")
        myQueue.offer("bad")
        assertEquals("kek", myQueue.poll())
        assertEquals("bad", myQueue.peek())
    }
}