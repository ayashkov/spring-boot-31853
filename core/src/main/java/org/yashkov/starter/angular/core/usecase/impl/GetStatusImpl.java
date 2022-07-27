package org.yashkov.starter.angular.core.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.yashkov.starter.angular.core.model.Status;
import org.yashkov.starter.angular.core.usecase.GetStatus;

@Service
@Lazy
public class GetStatusImpl implements GetStatus {
    private final String appVersion;

    @Autowired
    public GetStatusImpl(@Qualifier("version") String version)
    {
        appVersion = version;
    }

    @Override
    public Status getStatus()
    {
        return new Status(false, appVersion);
    }
}
