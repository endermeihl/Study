package base.lockDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PessimisticLockDemo {


    // ------------------------- 悲观锁的调用方式 -------------------------
// synchronized
    public synchronized void testMethod() {
        // 操作同步资源
    }

    // ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    // 需要保证多个线程使用的是同一个锁

    public void modifyPublicResources() {
        lock.lock();
        // 操作同步资源
        lock.unlock();
    }

    public static void main(String[] args) {
        // ------------------------- 乐观锁的调用方式 -------------------------
        AtomicInteger atomicInteger = new AtomicInteger();
        // 需要保证多个线程使用的是同一个AtomicInteger
        atomicInteger.incrementAndGet(); //执行自增1
    }


}
