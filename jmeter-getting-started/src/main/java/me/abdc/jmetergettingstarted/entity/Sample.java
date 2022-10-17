package me.abdc.jmetergettingstarted.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter @ToString
@Entity
public class Sample {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String createdBy;

    private LocalDateTime createdOn;
}
