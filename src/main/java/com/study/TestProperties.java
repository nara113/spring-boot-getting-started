package com.study;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.time.Duration;

@Setter
@Getter
@Validated
@Component
@ConfigurationProperties("test")
public class TestProperties {

    @NotEmpty
    private String name;
    private int age;
    private Duration second;

}
