package org.yashkov.starter.angular.core.usecase.impl;

import org.springframework.stereotype.Service;
import org.yashkov.starter.angular.core.usecase.GetStatus;

@Service
public class GetStatusImpl implements GetStatus {
    @Override
    public String getStatus()
    {
        return "UP";
    }
}
