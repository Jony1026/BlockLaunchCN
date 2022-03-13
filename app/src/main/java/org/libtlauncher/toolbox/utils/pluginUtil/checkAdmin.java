package org.libtlauncher.toolbox.Utils.pluginUtil;

import android.app.Activity;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.LauncherInfo;

import xyz.hasnat.sweettoast.SweetToast;

public class checkAdmin {
    public static boolean check(LinearLayout item_switch, int switch_widget, final Activity act) {
        if (LauncherInfo.UserLevel.equals("ADMIN")) {


            LinearLayout layout = item_switch;
            Switch layout_switch = layout.findViewById(switch_widget);


            layout_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        LauncherInfo.isLoaderDebug = true;
                        SweetToast.success(act, "开启成功");
                    } else {
                        LauncherInfo.isLoaderDebug = false;
                        SweetToast.info(act, "关闭成功");
                    }
                }
            });
            return true;
        } else {
            SweetToast.error(act, "未登录或没有权限...");
            act.finish();
            return false;
        }
    }
}
