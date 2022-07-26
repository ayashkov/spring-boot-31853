package org.yashkov.sbe.core;

import org.springframework.stereotype.Service;

@Service
public class GetStatus {
    public String getStatus()
    {
        return "UP";
    }
}
