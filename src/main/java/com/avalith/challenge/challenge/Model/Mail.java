package com.avalith.challenge.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "mail")
@Table(name = "mail")
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id",insertable = false,updatable = false)
    private User from;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id",insertable = false,updatable = false)
    private User to;
    private String message;
    private LocalDateTime sentDateTime;

    public Mail(@JsonProperty("id") UUID id,
                @JsonProperty("from") User from,
                @JsonProperty("to") User to,
                @JsonProperty("message") String message,
                @JsonProperty("sentDateTime") LocalDateTime sentDateTime){
        this.id = id;
        this.from = from;
        this.to = to;
        this.message = message;
        this.sentDateTime = sentDateTime;
    }
}
