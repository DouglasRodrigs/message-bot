package com.douglasrodrigs.messagebot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity

public class Messages {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Long conversationId;

        private LocalDateTime timestamp;

        @Column(name = "from_")
        private Long from;

        @Column(name = "to_")
        private Long to;

        private String text;
}
