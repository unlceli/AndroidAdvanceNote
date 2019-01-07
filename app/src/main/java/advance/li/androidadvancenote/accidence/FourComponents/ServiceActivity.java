package advance.li.androidadvancenote.accidence.FourComponents;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import advance.li.androidadvancenote.R;

public class ServiceActivity extends AppCompatActivity {

    private Button startService, unbindService;
    private ServiceProject.MyBinder myBinder;
    private ServiceConnection serviceConnection;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        startService = (Button) findViewById(R.id.service_start);
        unbindService = (Button) findViewById(R.id.unbind_service);

        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(ServiceActivity.this, ServiceProject.class));
                serviceConnection = new MyServiceConnection();
                bindService(new Intent(ServiceActivity.this, ServiceProject.class), serviceConnection, Context.BIND_AUTO_CREATE);
            }
        });

        unbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(serviceConnection);
            }
        });
    }

    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("MyService", "onServiceConnected");
            myBinder = (ServiceProject.MyBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("MyService", "onServiceDisconnected");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
