package com.study.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class HateoasController {

    @GetMapping("/hello")
    public EntityModel<Hello> hello() {
        Hello hello = new Hello("hi", "hello");

        EntityModel<Hello> helloEntityModel = EntityModel.of(hello);
        helloEntityModel.add(linkTo(methodOn(HateoasController.class).hello()).withSelfRel());

        return helloEntityModel;
    }
}
