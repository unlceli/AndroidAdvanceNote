package advance.li.androidadvancenote.accidence.FourComponents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import advance.li.androidadvancenote.R;

public class OtherTopActivity extends BaseActivity {
    private Button jump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        jump= (Button) findViewById(R.id.btn_other);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherTopActivity.this, ActivitySingleTop.class);
                startActivity(intent);
            }
        });
    }

}
