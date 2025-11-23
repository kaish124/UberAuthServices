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
@Table(name = "EM_DRIVER")
public class Driver extends AbstractAuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    private String email;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private Set<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private Set<Booking>  bookings;

    public Set<Review> getReviews() {
        if(reviews == null) {
            reviews = Sets.newHashSet();
        }
        return reviews;
    }

    public Set<Booking> getBookings() {
        if(bookings == null) {
            bookings = Sets.newHashSet();
        }
        return bookings;
    }
}
