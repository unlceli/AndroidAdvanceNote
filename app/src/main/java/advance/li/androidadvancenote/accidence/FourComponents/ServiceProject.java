package advance.li.androidadvancenote.accidence.FourComponents;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceProject extends Service {
    private String TAG = "MyService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(TAG,"onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"onUnbind");
        return super.onUnbind(intent);

    }

/*
    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        Log.i(TAG,"unbindService");
    }
*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    public interface MyIBinder {
        void invokeNethodInMyService();
    }

    public class MyBinder extends Binder implements MyIBinder {

        @Override
        public void invokeNethodInMyService() {
            for (int i = 0; i < 20; i++) {
                System.out.println("service is opening");
            }
        }
    }
}
