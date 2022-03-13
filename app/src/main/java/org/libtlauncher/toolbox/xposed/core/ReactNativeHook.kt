package org.libtlauncher.toolbox.xposed.core

import android.os.Handler
import android.widget.Toast
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam
import org.json.JSONArray
import org.json.JSONObject
import org.libtlauncher.toolbox.xposed.info.FuncInfo
import org.libtlauncher.toolbox.xposed.info.NeteaseClassInfo
import org.libtlauncher.toolbox.xposed.info.NeteaseInfo
import org.libtlauncher.toolbox.control.FMP_Toast
import org.libtlauncher.toolbox.debug.LOG
import org.libtlauncher.toolbox.xposed.sdkHook.NeteaseClass


class ReactNativeHook(load: LoadPackageParam?, classLoader: ClassLoader?) {
     val loadPackageParam: LoadPackageParam

    init {

        //  BlockLauncher.InitRNHook();
        var classLoader = classLoader
        loadPackageParam = load!!
        if (classLoader == null) {
            classLoader = load.classLoader
        }


        /*
         *Hook 网易我的世界RN的CallCPP接口
         */XposedHelpers.findAndHookMethod(XposedHelpers.findClass(NeteaseClassInfo.RNBridge, classLoader), "callCpp", String::class.java, object : XC_MethodHook() {
            @Throws(Throwable::class)
            override fun beforeHookedMethod(param: MethodHookParam) {
                super.beforeHookedMethod(param)
                LOG.LOGD(LOG.LOG_RN + "callCpp", param.args[0].toString())
            }
        })


        //使用反射获取Promise类
        /*
         *Hook 网易我的世界RN的CallPython接口
         */
        var ReactNativePython : XC_MethodHook.MethodHookParam? = null;
        XposedHelpers.findAndHookMethod(NeteaseClass.RNBridge, "callPython", String::class.java, NeteaseClass.Promise, object : XC_MethodHook() {
            @Throws(Throwable::class)
            override fun beforeHookedMethod(param: MethodHookParam) {
                super.beforeHookedMethod(param)
                ReactNativePython = param;
                LOG.LOGD(LOG.LOG_Debug, "callPython:" + param.args[0].toString())
                val json = JSONObject(param.args[0].toString()) //将参数 字符串转换为 JSON
                val func_name = json.getString("func_name") //获取函数名字
                val args = json.getString("args") //获取函数名字
                //当函数名字为加入网络游戏时 并且启动功能IP外进时
                if (func_name == "join_network_game") {
                    val ags = json.getJSONArray("args") //获取JSON里的参数
                    val IPS = ags.getString(0) //获取加入的IP xc
                    val PortS = ags.getString(1) //获取加入的端口 xc
                    val NameS = ags.getString(3)
                    FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "IP:$IPS Port:$PortS Name:$NameS", true)
                }
                if (func_name == "join_rental_game") {
                    val ags = json.getJSONArray("args") //获取JSON里的参数
                    val JoinIP = ags.getString(0) //获取加入的IP
                    val JoinPort = ags.getString(1) //获取加入的端口
                    val JoinServer = ags.getString(2)
                    Toast.makeText(NeteaseInfo.MCContext, "IP:$JoinIP,Port:$JoinPort,Server:$JoinServer", Toast.LENGTH_LONG).show()
                    param.args[0] = json.toString() //写入该函数参数
                }
                //当调用设置昵称时
                if (func_name == "setNickName") {
                    val ags = json.getJSONArray("args") //获取JSON里的参数
                    val UserName = ags.getString(0)
                    FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "Welcome:$UserName", true)
                    NeteaseInfo.UserNickName = UserName
                    if (NeteaseInfo.LoaderMode == 3) {
                        Handler().postDelayed({
                            try {
                                InjectManager.inject(NeteaseInfo.MCActivity, NeteaseInfo.UserNickName, 1,NeteaseInfo.JsPath)
                            } catch (e: Exception) {
                                LOG.LOGD(LOG.LOG_Debug,e.toString())
                            }
                        }, 1)
                    }

                }

                //当获取手机验证时
                if (func_name == "set_mobile_authenticated") {
                    if (FuncInfo.isNoMobileBindInGame) {
                        val js = JSONArray("[true]")
                        json.remove("args")
                        json.put("args", js)
                        param.args[0] = json.toString()
                    }
                }

                if (func_name == "setClientTipConfig") {
                    val statement = "Null"
                    val warn_tip = "warn_tip"
                    val NeteaseToast = """
                        §c§lB§el§bo§ac§dk§cL§2a§3u§an§5c§eh§de§er §f§nCN:
                        Js插件公告:
                        ${NeteaseInfo.JsTips}
                        """.trimIndent()
                    val js = JSONArray("[{\"warn_tip\":\"$warn_tip\",\"game_center_tip\":\"$NeteaseToast\",\"mobileBindHideVer\":[\"\"],\"statement\":\"$statement\",\"game_tip_position\":\"center\",\"game_tip\":\"\",\"welfareHideVer\":[\"\"],\"login_note\":\"\"}]\n")
                    json.remove("args")
                    json.put("args", js)
                    param.args[0] = json.toString()
                    if (NeteaseInfo.LoaderMode == 2) {
                        Handler().postDelayed({
                            try {
                                InjectManager.inject(NeteaseInfo.MCActivity, NeteaseInfo.UserNickName, 0,NeteaseInfo.JsPath)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }, 1) //延迟5000毫秒 = 5秒*/
                    }
                }
                if (func_name == "checkJsClass") {
                 //   FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "BlockLauncher CN:去除Js检测成功", true)
                    val js = JSONArray("[\"com.Andlua.LY\"]")
                    json.remove("args")
                    json.put("args", js)
                    param.args[0] = json.toString()
                }
            }
        })


        //Hook NeteaseSDK
        XposedHelpers.findAndHookMethod(NeteaseClass.SdkNetease, "extendFunc", String::class.java, object : XC_MethodHook() {
            @Throws(Throwable::class)
            override fun beforeHookedMethod(param: MethodHookParam) {
                super.beforeHookedMethod(param)
                LOG.LOGD(LOG.LOG_Debug, "NeteaseSDK:" + param.args[0].toString())
                val json = JSONObject(param.args[0].toString())
                val methodId = json.getString("methodId")
                LOG.LOGD(LOG.LOG_Debug, "NeteaseSDK:Method:$methodId")
                if (methodId.contains("showAd")) {
                    FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "阻止广告弹出成功$json", true)
                }
            }
        })
    }
}