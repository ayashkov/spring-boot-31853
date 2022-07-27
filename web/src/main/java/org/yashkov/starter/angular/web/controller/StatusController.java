package org.yashkov.starter.angular.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yashkov.starter.angular.core.usecase.impl.GetStatusImpl;
import org.yashkov.starter.angular.web.model.StatusModel;

@RestController
@RequestMapping(path = StatusController.SELF,
    produces = MediaTypes.HAL_JSON_VALUE)
public class StatusController {
    public static final String SELF = "/api/status";

    @Autowired
    private GetStatusImpl getStatus;

    @GetMapping
    public StatusModel get()
    {
        var model = new StatusModel(getStatus.getStatus());

        model.add(Link.of(SELF));

        return model;
    }
}
