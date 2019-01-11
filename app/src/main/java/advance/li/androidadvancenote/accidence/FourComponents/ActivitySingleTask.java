package advance.li.androidadvancenote.accidence.FourComponents;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import advance.li.androidadvancenote.R;

public class ActivitySingleTask extends BaseActivity {
    private Button jump,jump2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        jump = (Button) findViewById(R.id.btn_task);
        jump2 = (Button) findViewById(R.id.btn_other);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySingleTask.this, ActivitySingleTask.class);
                startActivity(intent);
            }
        });
        jump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySingleTask.this, OtherTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}
