package org.libtlauncher.toolbox.Utils.pluginUtil;

import cn.bmob.v3.BmobObject;

public class About_app extends BmobObject {
    private String UpdateUrl;
    private String Notice;
    private String Version;

    public String getHpk() {
        return Hpk;
    }

    public void setHpk(String hpk) {
        Hpk = hpk;
    }

    private String Hpk;

    public String getUpdateUrl() {
        return UpdateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        UpdateUrl = updateUrl;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        Notice = notice;
    }


}
