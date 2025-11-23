package com.uber.authservices.domain.entity;

import com.kaish.uber.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "EM_BOOKING")
public class Booking extends AbstractAuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Driver driver;

    private Instant startTime;
    private Instant endTime;
    private Long totalDistance;
    private Duration totalDuration;
}
