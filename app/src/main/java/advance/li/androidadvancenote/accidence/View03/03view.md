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
    我们自定义的View，首先得要测量宽高尺寸。为什么要测量宽高尺寸？我在刚学自定义View的时候非常无法理解！因为我当时觉得
    ，我在xml文件中已经指定好了宽高尺寸了，我自定义View中有必要再次获取宽高并设置宽高吗？既然我自定义的View是继承自View类，
    google团队直接在View类中直接把xml设置的宽高获取，并且设置进去不就好了吗？那google为啥让我们做这样的“重复工作”呢？客官别急，马上给您上茶~
    在学习Android的时候，我们就知道，在xml布局文件中，我们的layout_width和layout_height参数可以不用写具体的尺寸，
    而是wrap_content或者是match_parent。其意思我们都知道，就是将尺寸设置为“包住内容”和“填充父布局给我们的所有空间”。
    这两个设置并没有指定真正的大小，可是我们绘制到屏幕上的View必须是要有具体的宽高的，正是因为这个原因，我们必须自己去处理和设置尺寸。
    当然了，View类给了默认的处理，但是如果View类的默认处理不满足我们的要求，我们就得重写onMeasure函数啦。这里举个例子，比如我们希望我们的View是个正方形
    如果在xml中指定宽高为`wrap_content`，如果使用View类提供的measure处理方式，显然无法满足我们的需求。



##1.1    先看看onMeasure函数原型：
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)

    参数中的widthMeasureSpec和heightMeasureSpec是个什么鬼？看起来很像width和height，
    没错，这两个参数就是包含宽和高的信息。什么？包含？难道还要其他信息？是的！它还包含测量模式
    ，也就是说，一个int整数，里面放了测量模式和尺寸大小。那么一个数怎么放两个信息呢？我们知道，
    我们在设置宽高时有3个选择：wrap_content、match_parent以及指定固定尺寸，而测量模式也有3种：UNSPECIFIED，EXACTLY，AT_MOST，
    当然，他们并不是一一对应关系哈，这三种模式后面我会详细介绍，但测量模式无非就是这3种情况，而如果使用二进制，我们只需要使用2个bit就可以做到，
    因为2个bit取值范围是[0,3]里面可以存放4个数足够我们用了。


## 2.1自定义ViewGroup

    如果是让你负责设计ViewGroup，你会怎么去设计呢？

     1.首先，我们得知道各个子View的大小吧，只有先知道子View的大小，我们才知道当前的ViewGroup该设置为多大去容纳它们。


     2.根据子View的大小，以及我们的ViewGroup要实现的功能，决定出ViewGroup的大小


     3.ViewGroup和子View的大小算出来了之后，接下来就是去摆放了吧，具体怎么去摆放呢？这得根据你定制的需求去摆放了，比如，你想让子View按照垂直顺序一个挨着一个放，或者是按照先后顺序一个叠一个去放，这是你自己决定的。


     4.已经知道怎么去摆放还不行啊，决定了怎么摆放就是相当于把已有的空间"分割"成大大小小的空间，每个空间对应一个子View，我们接下来就是把子View对号入座了，把它们放进它们该放的地方去。


