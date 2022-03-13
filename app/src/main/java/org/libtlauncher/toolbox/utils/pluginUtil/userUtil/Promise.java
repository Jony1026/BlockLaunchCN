package org.libtlauncher.toolbox.Utils.pluginUtil.userUtil;

import cn.bmob.v3.BmobUser;

public class Promise extends BmobUser {
    public int getLoginCount() {
        return LoginCount;
    }

    public void setLoginCount(int loginCount) {
        LoginCount = loginCount;
    }

    private int LoginCount;

    public boolean isBan() {
        return isBan;
    }

    public void setBan(boolean ban) {
        isBan = ban;
    }

    public String getBan() {
        return Ban;
    }

    public void setBan(String ban) {
        Ban = ban;
    }

    private boolean isBan;
    private String Ban;
    public String getUserTag() {
        return UserTag;
    }

    public void setUserTag(String userTag) {
        UserTag = userTag;
    }

    public String getUserQQ() {
        return UserQQ;
    }

    public void setUserQQ(String userQQ) {
        UserQQ = userQQ;
    }

    public String getUserActor() {
        return UserActor;
    }

    public void setUserActor(String userActor) {
        UserActor = userActor;
    }

    public String getUserLevel() {
        return UserLevel;
    }

    public void setUserLevel(String userLevel) {
        UserLevel = userLevel;
    }

    public String getUserHasPlugin() {
        return UserHasPlugin;
    }

    public void setUserHasPlugin(String userHasPlugin) {
        UserHasPlugin = userHasPlugin;
    }

    private String UserTag;
    private String UserQQ;
    private String UserActor;
    private String UserLevel;

    public String getUserHasLoaderMode() {
        return UserHasLoaderMode;
    }

    public void setUserHasLoaderMode(String userHasLoaderMode) {
        UserHasLoaderMode = userHasLoaderMode;
    }

    private String UserHasPlugin;
    private String UserHasLoaderMode;

}
