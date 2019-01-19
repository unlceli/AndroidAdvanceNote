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


###1.1 onMeasure
