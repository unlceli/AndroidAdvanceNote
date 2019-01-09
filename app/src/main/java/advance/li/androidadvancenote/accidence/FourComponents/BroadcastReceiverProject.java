package advance.li.androidadvancenote.accidence.FourComponents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class BroadcastReceiverProject extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
            Toast.makeText(context, "yoyo", Toast.LENGTH_SHORT).show();
        }
    }
}
