package advance.li.androidadvancenote.accidence.FourComponents;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import advance.li.androidadvancenote.R;

public class ActivityProject extends AppCompatActivity {

    private BroadcastReceiverProject mReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        mReceiver = new BroadcastReceiverProject();
        this.registerReceiver(new BroadcastReceiverProject(), filter);
       // registerReceiver(new BroadcastReceiverProject(),new IntentFilter("test"));
    }
}
