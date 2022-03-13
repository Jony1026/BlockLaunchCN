package org.libtlauncher.toolbox.xposed

import android.app.Activity
import android.content.Context

object getMCContext {
    val topActivityInstance: Activity?
        get() {
            var activityThreadClass: Class<*>? = null
            try {
                activityThreadClass = Class.forName("android.app.ActivityThread")
                val activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null)
                val activitiesField = activityThreadClass.getDeclaredField("mActivities")
                activitiesField.isAccessible = true
                val activities = activitiesField[activityThread] as Map<*, *>
                for (activityRecord in activities.values) {
                    val activityRecordClass: Class<*> = activityRecord!!.javaClass
                    val pausedField = activityRecordClass.getDeclaredField("paused")
                    pausedField.isAccessible = true
                    if (!pausedField.getBoolean(activityRecord)) {
                        val activityField = activityRecordClass.getDeclaredField("activity")
                        activityField.isAccessible = true
                        return activityField[activityRecord] as Activity
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

    @get:Throws(Exception::class)
    val application: Context
        get() {
            val clazz = Class.forName("android.app.ActivityThread")
            val field = clazz.getDeclaredField("sCurrentActivityThread")
            field.isAccessible = true
            val `object` = field[null]
            val decMethod = clazz.getDeclaredMethod("getApplication", *arrayOfNulls(0))
            decMethod.isAccessible = true
            return decMethod.invoke(`object`, *arrayOfNulls(0)) as Context
        }
}