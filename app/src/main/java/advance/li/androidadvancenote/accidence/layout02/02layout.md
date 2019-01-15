#layout

##布局类型

在Android中，共有2类，6种布局方式。

![](https://i.imgur.com/4nMODwx.png)

##布局介绍

![](https://i.imgur.com/M0FFxIf.png)

##3布局属性

- Android的布局实行通过XML配置
- 下面介绍布局 公有属性和特有属性。

###3.1 公有属性

	
	

	- layout_width 、layout_height
		
	- layout_margin+方位
		
	- padding +方位
		
	- layout_gravity
	
	- gravity

![](https://i.imgur.com/e9WVEcn.png)


###选择器

        4. 选择器（Selector）
        4.1 作用
        通过设置选择器（selector）可使控件 在不同操作下（默认、点击等） 显示不同样式

        通过 xml编写 = selector.xml

        4.2 属性



        XML属性
        说明




        android:drawable
        放一个drawable资源


        android:state_pressed
        按下状态，如一个按钮触摸或者点击。


        android:state_focused
        取得焦点状态，比如用户选择了一个文本框。


        android:state_hovered
        光标悬停状态，通常与focused state相同，它是4.0的新特性


        android:state_selected
        选中状态


        android:state_enabled
        能够接受触摸或者点击事件


        android:state_checked
        被checked了，如：一个RadioButton可以被check了。


        android:state_enabled
        能够接受触摸或者点击事件



