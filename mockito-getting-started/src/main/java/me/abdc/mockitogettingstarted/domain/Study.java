package me.abdc.mockitogettingstarted.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Study {

    private Long id;

    private String name;

    private int limitCount;

    private LocalDateTime openedDateTime;

    @ManyToOne
    private Member owner;
}
