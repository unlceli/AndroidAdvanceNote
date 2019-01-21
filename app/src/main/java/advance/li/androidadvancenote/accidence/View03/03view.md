#View

##1自定义View
	
	Android 系统内置的View无法实现我们的需求，我们需要针对我们业务需求定制我们想要的View，
	自定义View我们大部分时候只需要两个函数 onMeasure(),onDraw()。

	当我们定义一个新的类继承了View或ViewGroup时，系统都会提示我们重写它的构造方法。View / ViewGroup中又四个构造方法可以重写，它们分别有一、二、三、四个参数。
	四个参数的构造方法我们通常用不到，因此这个章节中我们主要介绍一个参数、两个参数和三个参数的构造方法（这里以CustomMenu控件为例）。
	 onMeasure负责对当前的View的尺寸进行测量，onDraw负责把当前这个View绘制出来。当然还得至少写2 个构造函数。

	public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs); 
    }


    1.1.onMeasure
    我们自定义的View，首先得要测量宽高尺寸。为什么要测量宽高尺寸？我在刚学自定义View的时候非常无法理解！因为我当时觉得，我在xml文件中已经指定好了宽高尺寸了，我自定义View中有必要再次获取宽高并设置宽高吗？既然我自定义的View是继承自View类，google团队直接在View类中直接把xml设置的宽高获取，并且设置进去不就好了吗？那google为啥让我们做这样的“重复工作”呢？客官别急，马上给您上茶~
    在学习Android的时候，我们就知道，在xml布局文件中，我们的layout_width和layout_height参数可以不用写具体的尺寸，而是wrap_content或者是match_parent。其意思我们都知道，就是将尺寸设置为“包住内容”和“填充父布局给我们的所有空间”。这两个设置并没有指定真正的大小，可是我们绘制到屏幕上的View必须是要有具体的宽高的，正是因为这个原因，我们必须自己去处理和设置尺寸。当然了，View类给了默认的处理，但是如果View类的默认处理不满足我们的要求，我们就得重写onMeasure函数啦。这里举个例子，比如我们希望我们的View是个正方形，如果在xml中指定宽高为`wrap_content`，如果使用View类提供的measure处理方式，显然无法满足我们的需求。


###1.1 onMeasure
