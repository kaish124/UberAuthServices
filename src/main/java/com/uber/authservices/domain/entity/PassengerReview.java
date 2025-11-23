package com.uber.authservices.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "EM_PASSENGER_REVIEW")
public class PassengerReview extends Review{
    private String passengerReviewContent;
    private Double passengerReviewRating;

    @ManyToOne
    private Passenger passenger;
}
