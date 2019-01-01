# AndroidAdvanceNote
第一周：synchronized 指标：理解 synchronized 的含义、明确 synchronized 关键字修饰普通方法、静态方法和代 码块时锁对象的差异。
有如下一个类
    A class A { 
     public synchronized void a() {     } 
 
    public synchronized void b() {     } }
    然后创建两个对象 A a1 = new A(); A a2 = new A(); 
    然后在两个线程中并发访问如下代码： Thread1 
    Thread2 a1.a();                      
    a2.a(); 请问二者能否构成线程同步？ 
    如果A 的定义是下面这种呢？
    class A {   
    public static synchronized void a() {     } 
    public static synchronized void b() {     } } 
    
    https://github.com/unlceli/AndroidAdvanceNote/blob/master/app/src/main/java/advance/li/androidadvancenote/01synchronized/synchronized.md

第二周  Service 话题：
清晰地理解 Service。 1、Service的 start 和 bind 状态有什么区别？ 2、同一个 Service，先 startService，然后再 bindService，如何把它停止掉？ 3、你有注意到 Service 的onStartCommand 方法的返回值吗？不同返回值有什么区别？ 4、Service的生命周期方法 onCreate、onStart、onBind 等运行在哪个线程？ 
请从网上查找相干主题的内容，或者参考 Android 开发艺术探索，还可以阅读 Android 官方 文档中有关 Service的章节。 
