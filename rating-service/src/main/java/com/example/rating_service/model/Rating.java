package com.example.rating_service.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String ratingId;
    private String comment;
    private Integer rate;
    private String hotelId;
    private String userId;
}
