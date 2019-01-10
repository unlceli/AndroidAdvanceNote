package advance.li.androidadvancenote.accidence.FourComponents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import advance.li.androidadvancenote.R;

public class ActivityStandard extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        findViewById(R.id.btn_standard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityStandard.this, ActivityStandard.class);
                startActivity(intent);
            }
        });
    }
}
