package org.yashkov.starter.angular.web.model;

import org.springframework.hateoas.RepresentationModel;

public class StatusModel extends RepresentationModel<StatusModel> {
    public final String apiVersion = "1.0.0";

    public final String status;

    public StatusModel(String status)
    {
        this.status = status;
    }
}
