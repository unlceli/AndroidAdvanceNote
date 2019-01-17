#View

##1自定义View
	
	Android 系统内置的View无法实现我们的需求，我们需要针对我们业务需求定制我们想要的View，
	自定义View我们大部分时候只需要两个函数 onMeasure(),onDraw()。
	 onMeasure负责对当前的View的尺寸进行测量，onDraw负责把当前这个View绘制出来。当然还得至少写2 个构造函数。

	public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs); 
    }


###1.1 onMeasure
