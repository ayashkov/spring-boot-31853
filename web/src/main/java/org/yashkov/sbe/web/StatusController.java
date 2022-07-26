package org.yashkov.sbe.web;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = StatusController.SELF,
    produces = MediaTypes.HAL_JSON_VALUE)
public class StatusController {
    public static final String SELF = "/api/status";

    @GetMapping
    public StatusModel get()
    {
        var model = new StatusModel();

        model.add(Link.of(SELF));

        return model;
    }
}
