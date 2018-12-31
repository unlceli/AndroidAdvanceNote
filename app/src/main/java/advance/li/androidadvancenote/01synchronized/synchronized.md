Synchronized 相关知识
1.1 JMM   基础和概念：  学习来源： https://www.jianshu.com/p/26385b1b9a8c
    (1) 共享性，互斥性，原子性，可见性，有序性。

    （2）JMM内存模型---描述线程本地内存和主内存之间的抽象关系，线程A和线程B之间铜须，需要通过主内存。


注意：现成本地内存只是一个抽象概念，它涵盖缓存，写缓冲区，寄存器以及其他的硬件和编译器优化。
1.2 happends-before ：

    JMM可以通过happens-before关系向程序员提供跨线程的内存可见性保证。（如果A线程的写操作a与B线程的读操作b之间存在hanppens-before关系，尽管a操作和b操作在不同的线程，但JMM向程序员保证a操作对b操作可见）

2. synchronized实现原理
2.1 使用场景




synchronized的使用场景。