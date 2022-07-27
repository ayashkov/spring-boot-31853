package org.yashkov.starter.angular.core.model;

public class Status {
    private final boolean drain;

    private final String appVersion;

    public Status(boolean drain, String appVersion)
    {
        this.drain = drain;
        this.appVersion = appVersion;
    }

    public boolean isDrain()
    {
        return drain;
    }

    public String getAppVersion()
    {
        return appVersion;
    }
}
