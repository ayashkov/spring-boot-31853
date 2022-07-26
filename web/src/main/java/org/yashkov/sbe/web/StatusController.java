package org.yashkov.sbe.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yashkov.sbe.core.GetStatus;

@RestController
@RequestMapping(path = StatusController.SELF,
    produces = MediaTypes.HAL_JSON_VALUE)
public class StatusController {
    public static final String SELF = "/api/status";

    @Autowired
    private GetStatus getStatus;

    @GetMapping
    public StatusModel get()
    {
        var model = new StatusModel(getStatus.getStatus());

        model.add(Link.of(SELF));

        return model;
    }
}
