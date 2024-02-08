fun main() {
    var a1 = 0

    // Thread 가동
    val t1 = ThreadClass()
    t1.start()

    // Thread 가동
    val r2 = RunnableClass()
    val t2 = Thread(r2)
    t2.start()

    // 코틀린에서만 제공되는 고차함수 사용하는 방법
    // thread 코드 블럭 사용
    // 코드 블럭 내의 작성한 코드를 별도의 Thread로 가동시켜 줌.
    // 자바에서는 사용할 수 없음.
    thread {
        var a4 = 0
        while(a4 < 10){
            Thread.sleep(100)
            println("a4 : $a4")
            a4++
        }
    }

    while(a1 < 10) {
        Thread.sleep(100)
        println("a1 : $a1")
        a1++
    }
}

fun thread(function: () -> Unit) {

}

// Thread 클래스를 상속받은 클래스를 만들어줌
class ThreadClass : Thread() {
    // 별도의 쓰레드를 발생시켜 처리할 코드가 있는 메소드
    override fun run() {
        var a2 = 0
        while(a2 < 10) {
            sleep(100)
            println("a2 : $a2")
            a2++
        }
    }

    fun start() {
        TODO("Not yet implemented")
    }
}

// Runnable 인터페이스를 구현한 클래스
class RunnableClass : Runnable { // 제공하는 이유 : start 없음.
    // 별도의 쓰래드를 발생시켜 처리할 코드가 있는 메서드
    override fun run() {
        var a3 = 0
        while(a3 < 10){
            Thread.sleep(100)
            println("a3 : $a3")
            a3++
        }
    }
}
