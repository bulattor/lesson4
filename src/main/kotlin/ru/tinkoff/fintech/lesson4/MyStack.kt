package ru.tinkoff.fintech.lesson4

interface MyStackInterface<T> {
    fun peek() : T?
    fun pop() : T?
    fun push(e: T) : Boolean
}

class MyStack<T> : MyStackInterface<T> {
    private val initialSize = 32
    private var array = arrayOfNulls<Any>(initialSize)
    private var size = 0

    override fun peek() : T? {
        if (size == 0) return null
        return array[size-1] as T
    }

    override fun pop() : T? {
        val e = peek()
        if (e != null) {
            size--
            if (size < array.size/2) resize(size + size/2)
        }
        return e
    }

    override fun push(e: T) : Boolean{
        if (size >= array.size) resize(array.size * 2)
        array[size] = e
        size++

        return true;
    }

    private fun resize(newLength: Int){
        val newArray = arrayOfNulls<Any>(newLength)
        System.arraycopy(array, 0, newArray, 0, size)
        array = newArray
    }
}