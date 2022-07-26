package org.yashkov.sbe.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/status",
    produces = MediaType.APPLICATION_JSON_VALUE)
public class StatusController {
    @GetMapping
    public StatusModel get()
    {
        return new StatusModel();
    }
}
