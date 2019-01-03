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

	
###生命周期：
 
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


----------
