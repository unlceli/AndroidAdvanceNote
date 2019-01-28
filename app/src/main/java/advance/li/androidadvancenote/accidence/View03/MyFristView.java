package advance.li.androidadvancenote.accidence.View03;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import advance.li.androidadvancenote.R;

public class MyFristView extends View {


    private int dimensionPixelSize;

    public MyFristView(Context context) {
        super(context);
    }

    public MyFristView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        /**
         *  第二个参数就是我们在style.xml 文件名称为  R.styleable + name;
         *  即 属性集合标签，在R文件名称为 R.styleable +name;
         */
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyFristView);
/**
 *  第一个参数 为属性集合里面的属性， R文件名称 R.styleable + 属性集合名称 + 下划线 + 属性名称
 *  第一个参数为，如果没有设置这个属性，则设置默认的值
 */
        dimensionPixelSize = a.getDimensionPixelSize(R.styleable.MyFristView_default_size, 100);
        /**
         * 最后记得 TypedArray 对象回收。
         */
        a.recycle();

    }

    private int getMySize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                mySize = defaultSize;
                break;

            case MeasureSpec.AT_MOST:
                mySize = size;
                break;

            case MeasureSpec.EXACTLY:
                mySize = size;
                break;
        }

        return mySize;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMySize(100, widthMeasureSpec);
        int height = getMySize(100, heightMeasureSpec);
        if (width < height) {
            height = width;
        } else {
            width = height;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r = getMeasuredHeight() / 2;
        int centerx = getLeft() + r;
        int centery = getTop() + r;

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);

        canvas.drawCircle(centerx, centery, r, paint);
    }
}
