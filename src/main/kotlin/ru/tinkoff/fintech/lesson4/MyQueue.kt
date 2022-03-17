package ru.tinkoff.fintech.lesson4

interface MyQueueInterface<T> {
    fun element() : T
    fun remove() : T
    fun peek() : T?
    fun poll() : T?
    fun offer(e: T) : Boolean
}

class MyQueue<T> : MyQueueInterface<T> {
    private val initialSize = 32
    private var array = arrayOfNulls<Any>(initialSize)
    private var size = 0

    override fun element() : T {
        if (size == 0) throw NoSuchElementException("MyQueue is empty.")
        return array[0] as T
    }

    override fun remove() : T {
        val e = element()
        shift()
        return e
    }

    override fun peek() : T? {
        if (size == 0) return null
        return array[0] as T
    }

    override fun poll() : T? {
        val e = peek()
        if (e != null)
            shift()
        return e
    }

    override fun offer(e: T) : Boolean{
        if (size >= array.size) resize(array.size * 2)
        array[size] = e
        size++

        return true;
    }

    private fun shift(){
        for (i in 0 until size) array[i] = array[i+1]
        size--
        if (size < array.size/2) resize(size + size/2)
    }

    private fun resize(newLength: Int){
        val newArray = arrayOfNulls<Any>(newLength)
        System.arraycopy(array, 0, newArray, 0, size)
        array = newArray
    }
}