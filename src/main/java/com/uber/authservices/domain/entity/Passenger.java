package com.uber.authservices.domain.entity;

import com.google.common.collect.Sets;
import com.uber.authservices.domain.embeddable.Name;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "EM_PASSENGER")
public class Passenger extends AbstractAuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    private String email;

    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger")
    private Set<Booking> bookings;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger")
    private Set<PassengerReview> passengerReviews;

    public Set<Booking> getBookings() {
        if (bookings == null) {
            bookings = Sets.newHashSet();
        }
        return bookings;
    }

    public Set<PassengerReview> getPassengerReviews() {
        if (passengerReviews == null) {
            passengerReviews = Sets.newHashSet();
        }
        return passengerReviews;
    }
}
