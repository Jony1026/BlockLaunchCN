package org.libtlauncher.toolbox.xposed

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import org.json.JSONObject
import org.libtlauncher.toolbox.control.FMP_Toast
import org.libtlauncher.toolbox.control.HtmlText
import org.libtlauncher.toolbox.xposed.core.GameHook
import org.libtlauncher.toolbox.xposed.floatWin.WindowLib
import org.libtlauncher.toolbox.xposed.info.NeteaseInfo
import java.security.SecureRandom

class NoRootInit {
    fun runNoRootHook(activity: Activity) {
        NeteaseInfo.MCContext = activity
        NeteaseInfo.MCActivity = activity
        val it = NeteaseInfo.MCActivity.intent
        NeteaseInfo.it = it
        if (it.getStringExtra("0x0") != null) {
            val a = it.getStringExtra("loadInfo")
            val jsonObject = JSONObject(a)
            val JSPath = jsonObject.optString("JsPath")
            val LoaderMode = jsonObject.optInt("LoaderMode")
            val isDebug = jsonObject.optBoolean("isDebug")
            NeteaseInfo.JsPath = JSPath
            NeteaseInfo.LoaderMode = LoaderMode
            NeteaseInfo.isLoaderDebug = isDebug

            val b = it.getStringExtra("user")
            val jsonObject2 = JSONObject(b)
            NeteaseInfo.UserID = jsonObject2.optString("id")
            NeteaseInfo.UserPass = jsonObject2.optString("pass")
            GameHook.NoRootHook()
        } else {
            val id = java.lang.Long.toHexString(SecureRandom().nextLong())
            val bt1 = TextView(NeteaseInfo.MCActivity)
            bt1.text = HtmlText.parse("§l§dOriginTips§!§e此OriginBox未正确启动§!§a如要正确启动 请打开APP启动§!§l§rNoRoot - $id")
            bt1.setTextColor(Color.parseColor("#E8B7D4"))
            bt1.textSize = 12f
            bt1.gravity = Gravity.RIGHT
            Gravity.BOTTOM
            val obj = WindowLib.addWindowView(NeteaseInfo.MCContext, bt1, 0, 0, Gravity.BOTTOM)
            val windowManager: WindowManager = obj[0] as WindowManager
            val params: WindowManager.LayoutParams = obj[1] as WindowManager.LayoutParams

            params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            bt1.setOnClickListener(View.OnClickListener {
                FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "check permission ing...", true);
                FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "no permission !", true);
                windowManager.removeView(bt1)
            })

        }
    }
}