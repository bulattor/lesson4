package ru.tinkoff.fintech.lesson4

fun main(){
    /*var queue = MyQueue<Int>()

    //(queue.element())
    //println(queue.remove())

    for (i in 0 until 110) {
        queue.offer(i)
    }

    println(queue.element())
    println(queue.peek())
    println(queue.remove())
    println(queue.poll())
    println(queue.peek())

    for (i in 0 until 50) {
        queue.remove()
        queue.poll()
    }
    println(queue.peek())*/

    var stack = MyStack<Int>()

    for (i in 0 until 110) {
        stack.push(i)
    }
    println(stack.peek())
    println(stack.pop())
    println(stack.peek())
    println(stack.peek())
}