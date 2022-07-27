package org.yashkov.starter.angular.web.model;

import org.springframework.hateoas.RepresentationModel;

public class StatusModel extends RepresentationModel<StatusModel> {
    private final String status;

    private final String apiVersion;

    public StatusModel(String status, String apiVersion)
    {
        this.status = status;
        this.apiVersion = apiVersion;
    }

    public String getStatus()
    {
        return status;
    }

    public String getApiVersion()
    {
        return apiVersion;
    }
}
