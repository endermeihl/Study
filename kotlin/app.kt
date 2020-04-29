fun main() {
    println(Thread.currentThread().name)
    t.start()
}

val t = Thread {
    println("thread")
    println(Thread.currentThread().name)
}