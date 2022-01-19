package com.study.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;
    private String name;
    private String email;
}
