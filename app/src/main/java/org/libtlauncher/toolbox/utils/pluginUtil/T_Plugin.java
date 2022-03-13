package org.libtlauncher.toolbox.Utils.pluginUtil;

import cn.bmob.v3.BmobObject;


public class T_Plugin extends BmobObject {
    @Override
    public String toString() {
        return "PluginBean{" +
                "PluginId='" + PluginId + '\'' +
                ", PluginTitle='" + PluginTitle + '\'' +
                ", PluginRanking='" + PluginRanking + '\'' +
                ", PluginDesc='" + PluginDesc + '\'' +
                ", PluginQGroupKey='" + PluginQGroupKey + '\'' +
                ", PluginCover='" + PluginCover + '\'' +
                '}';
    }

    private String PluginId;
    private String PluginTitle;
    private String PluginRanking;
    private String PluginDesc;
    private String PluginQGroupKey;
    private String PluginCover;

    public String getPluginId() {
        return PluginId;
    }

    public void setPluginId(String pluginId) {
        PluginId = pluginId;
    }
    public String getPluginQGroupKey() {
        return PluginQGroupKey;
    }

    public void setPluginQGroupKey(String pluginQGroupKey) {
        PluginQGroupKey = pluginQGroupKey;
    }


    public String getPluginTitle() {
        return PluginTitle;
    }

    public void setPluginTitle(String pluginTitle) {
        PluginTitle = pluginTitle;
    }

    public String getPluginRanking() {
        return PluginRanking;
    }

    public void setPluginRanking(String pluginRanking) {
        PluginRanking = pluginRanking;
    }

    public String getPluginDesc() {
        return PluginDesc;
    }

    public void setPluginDesc(String pluginDesc) {
        PluginDesc = pluginDesc;
    }

    public String getPluginCover() {
        return PluginCover;
    }

    public void setPluginCover(String pluginCover) {
        PluginCover = pluginCover;
    }

}
