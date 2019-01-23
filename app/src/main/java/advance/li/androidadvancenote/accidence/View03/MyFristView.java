package advance.li.androidadvancenote.accidence.View03;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyFristView extends View {


    public MyFristView(Context context) {
        super(context);
    }

    public MyFristView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
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
}
