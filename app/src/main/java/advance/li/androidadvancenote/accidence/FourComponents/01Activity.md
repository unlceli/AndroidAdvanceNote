#Activity   学习来源：[https://www.jianshu.com/p/51aaa65d5d25](https://www.jianshu.com/p/51aaa65d5d25)
##生命周期
	生命周期：onCreate() -> onStart() - > onResume() -> onPause() -> onStop() -> onDestroy()
![](https://i.imgur.com/G6Dhu5N.png)

- 启动activity：系统先调用onCreate()，然后调用onStart()，最后调用onResume()方法，activity进入运行状态。
- activity被其他activity覆盖其上（DialogActivity）或者锁屏：系统会调用onPause()方法，暂停当前activity的执行。
- 当前activity由被覆盖状态回到前台或者解锁屏：系统会调用onResume()方法，再次进入运行状态。
- 当前Activity转到新的Activity界面或按Home键回到主屏，自身退居后台：系统会先调用onPause方法，然后调用onStop方法，进入停滞状态。
- 用户后退回到此Activity：系统会先调用onRestart方法，然后调用onStart方法，最后调用onResume方法，再次进入运行状态。
- 当前Activity处于被覆盖状态或者后台不可见状态，即第2步和第4步，系统内存不足，杀死当前Activity，而后用户退回当前Activity：再次调用onCreate方法、onStart方法、onResume方法，进入运行状态。
- 用户退出当前Activity：系统先调用onPause方法，然后调用onStop方法，最后调用onDestory方法，结束当前Activity。
- onRestart()：表示activity正在重新启动 ，一般情况下，当前activity从不可见重新变成可见状态时，onRestart()就会被调用，这种情形一般是用户行为所导致的，比如用户按HOME键切换到桌面然后重新打开APP或者按back键。
- onStart()：activity可见了，但是还没有出现在前台，还无法和用户交互。
- onPause()：表示activity正在停止，此时可以做一些存储数据，停止动画等工作，注意不能太耗时，因为这会影响到新activity的显示，onPause必须先执行完，新的activity的onResume才会执行。
- 从activity是否可见来说，onstart()和onStop()是配对的，从activity是否在前台来说，onResume()和onPause()是配对的。
- 旧activity先onPause，然后新activity在启动

	注意：当activity中弹出dialog对话框的时候，activity不会回调onPause。
	然而当activity启动dialog风格的activity的时候，此activity会回调onPause函数。


##生命周期：

----------
正常的使命周期与横竖屏：

	04-11 09:44:57.350 11757-11757/cn.hotwoo.play:remote I/MainActivity: onCreate
	04-11 09:44:57.354 11757-11757/cn.hotwoo.play:remote I/MainActivity: onStart
	04-11 09:44:57.356 11757-11757/cn.hotwoo.play:remote I/MainActivity: onResume
	04-11 09:44:57.425 11757-11757/cn.hotwoo.play:remote I/MainActivity: onCreateOptionsMenu
	04-11 09:44:59.149 11757-11757/cn.hotwoo.play:remote I/MainActivity: onPause
	04-11 09:44:59.151 11757-11757/cn.hotwoo.play:remote I/MainActivity: onSaveInstanceState
	04-11 09:44:59.151 11757-11757/cn.hotwoo.play:remote I/MainActivity: onStop
	04-11 09:44:59.151 11757-11757/cn.hotwoo.play:remote I/MainActivity: onDestroy
	04-11 09:44:59.234 11757-11757/cn.hotwoo.play:remote I/MainActivity: onCreate
	04-11 09:44:59.235 11757-11757/cn.hotwoo.play:remote I/MainActivity: onStart
	04-11 09:44:59.236 11757-11757/cn.hotwoo.play:remote I/MainActivity: onRestoreInstanceState
	04-11 09:44:59.237 11757-11757/cn.hotwoo.play:remote I/MainActivity: onResume
	04-11 09:44:59.270 11757-11757/cn.hotwoo.play:remote I/MainActivity: onCreateOptionsMenu
	04-11 10:02:32.320 11757-11757/cn.hotwoo.play:remote I/MainActivity: onPause
	04-11 10:02:32.516 11757-11757/cn.hotwoo.play:remote I/MainActivity: onStop
	04-11 10:02:32.516 11757-11757/cn.hotwoo.play:remote I/MainActivity: onDestroy


	异常的情况：
    1.资源相关的系统配置发生改变导致activity被杀死并重新创建
    比如说当前activity处于竖屏状态，如果突然旋转屏幕，由于系统配置发生了改变，在默认情况下，activity就会被销毁并且重新创建，当然我们也可以组织系统重新创建我们的activity。
    2.资源内存不足导致低优先级的activity被杀死
    这里的情况和前面的情况1数据存储和恢复是完全一致的，activity按照优先级从高到低可以分为如下三种：
    （1）前台activity---正在和用户交互的activity，优先级最高
    （2）可见但非前台activity---比如activity中弹出了一个对话框，导致activity可见但是位于后台无法和用户直接交互。
    （3）后台activity---已经被暂停的activity，比如执行了onStop，优先级最低。
	注意：当activity中弹出dialog对话框的时候，activity不会回调onPause。
	然而当activity启动dialog风格的activity的时候，此activity会回调onPause函数。

	防止重新创建activity：activity指定configChange属性来不让系统重新创建activity。
	android : configChanges = "orientation"


----------

##Activity与Fragment生命周期关系
创建过程

![](https://i.imgur.com/HvJKfIS.png)

销毁过程

![](https://i.imgur.com/0bmu4Be.png)

##Activity 启动模式
- standard 模式： 在这种模式下，activity默认会进入启动它的activity所属的任务栈中。注意：在非activity类型的context（如ApplicationContext）并没有所谓的任务栈，所以不能通过ApplicationContext去启动standrar模式的activity。
- singleTop 模式：栈顶复用模式。如果新activity无语任务栈的栈顶的时候，activity不会被重新创建，同时onNewIntent方法会被调用。注意：这个activity的onCreate，onStart，onResume不会被调用，因为他们并没有发生改变。
- SingleTask模式：栈内服用模式。只要activity在一个栈中存在，那么多次启动此activity不会被重新创建单例，系统回调onNewIntent。比如ActivityA，系统首先会寻找存在A想要的任务栈，如果没有则创建一个新的任务栈，然后把ActivityA压入栈中，如果存在任务栈，然后再看看有没有ActivityA 的实例，如果实例存在，那么久会把A调到栈顶并调用它的onNewIntent方法，如果不存在则把它压入栈中。
- SingleInstance模式：单实例模式，这种模式activity只能单独地唯一一个任务栈中。由于栈内复用特性，后续的请求均不会创建新的activity实例。


#Android 四大组件- Service

###本地服务（LocalService）
 	调用者和sercice在同一个进程里，所有运行在主线程的man线程中，所以不能进行耗时操作，
	可以采用在service里面创建一个Thread来执行任务，service影响的是进程的生命周期，
	讨论与Thread的区别没有意义。
	任何Activity都可以控制同一service，而系统也只能创建一个对应Service的实例。

##启动方式

###第一种启动方式
通过start方式开启服务。

	1.定义一个类继承service。
	2.manifest.xml文件配置service。
	3.使用context的startService（Intent）方法启动sercice。
	4.不在使用时，调用stopService（Intent）方法停止服务。

使用start方法启动的生命周期。

	onCreate -> onStartCommand -> onDestory。

注意：如果服务已经开启，不会重复回调onCreate 方法，如果再次调用Content.startSerice() 方法，
	service而是会调用onStart 或者onStartCommand方法。停止服务需要调用context.StopService方法，
	服务停止的时候onDestoty会调用。

特点：一旦服务开启就跟着调用者没有任何的关系，开启者退出了，开启者挂了，服务还在后台长期的运行，开启者不能调用服务里面的方法。

###第二种方法

通过bind的方式开启服务。
使用service的步骤：

	1.定义一个类继承service。
	2.在manifest.xml 文件中注册service。
	3.使用context的bindService（intent，ServiceConnecttion，int）方法调用service。
	4.不能使用时，调用unbingService（serviceConnection）方法停止该服务。

生命周期：

	oncrate -> onBind -> onUnbind -> onDestory。

注意：绑定服务不会调用Onstart挥着onstartCommand方法。

特点：bind的方法开启服务，绑定五福，调用者挂了服务也会跟着挂掉，绑定着可以调用服务里面的方法。

注：具体代码详见 同目录 ServiceProject 和ServiceActivity。


##远程服务

	调用者和service不在同一进程中，service在单独的进程中的main进程中，是一种跨进程通信方式。aidl。

绑定远程服务的步骤：


	- 在服务的内部创建一个内部类，提供一个方法，可以间接调用服务的方法
	- 把暴露的接口文件的扩展名为 .aidl 文件，去掉访问修饰符
	- 实现服务的onbind方法，继承Bander金额实现aidl定义的接口，提供给外界可调用的方法
	- 在activity中绑定服务 bindService。
	- 在服务成功绑定的时候会调用onServiceConnected方法，传递一个IBinder对象。
	- adil定义的接口 .Stub.asInterface(bind) 调用接口里面的方法。

##IntentService

IntentService 是Service 的子类，比普通的 Service增加额外的功能，先看service本身存在的两个问题：

	- Service不会专门启动一条单独的进程，Service与它所在应用位于同于个进程中，
	- service也不在一个专门的一条新线程。因此不用改在Service中直接处理耗时的任务。

IntentService特征：

	- 会创建独立的worker线程来处理所有的intent 请求。
	- 会创建独立的worker线程来处理onHandleIntent() 方法实现的代码，无须处理多线程问题。
	- 所有请求处理完成后，IntentService会自定停止，无须调用StopSelf（） 方法停止Service。
	- 为Service的onBind() 提供默认实现返回null。
	- 为Service的onStartCommand提供模式显示，将请求Intent添加到队列中。

#Android四大组件 -BroadcastReceiver


	广播被分为两种不同的类型：“普通广播（Normal broadcasts）”和“有序广播（Ordered broadcasts）”。
	普通广播是完全异步的，可以在同一时刻（逻辑上）被所有接收者接收到，消息传递的效率比较高
	，但缺点是：接收者不能将处理结果传递给下一个接收者，并且无法终止广播Intent的传播；
	然而有序广播是按照接收者声明的优先级别（声明在intent-filter元素的android:priority属性中，
	数越大优先级别越高,取值范围:-1000到1000。也可以调用IntentFilter对象的setPriority()进行设置），
	被接收者依次接收广播。如：A的级别高于B,B的级别高于C,那么，广播先传给A，再传给B，最后传给C。
	A得到广播后，可以往广播里存入数据，当广播传给B时,B可以从广播中得到A存入的数据。


