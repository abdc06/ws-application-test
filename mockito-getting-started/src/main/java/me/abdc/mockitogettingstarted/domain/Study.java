package me.abdc.mockitogettingstarted.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter @Setter
public class Study {

    private Long id;

    private String name;

    private int limitCount;

    private LocalDateTime openedDateTime;

    @ManyToOne
    private Member owner;
}
