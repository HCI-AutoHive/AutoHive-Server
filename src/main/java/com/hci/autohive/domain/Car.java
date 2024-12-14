package com.hci.autohive.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

@Entity
@Setter
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long carId;

  @Column(nullable = false)
  private String model;

  @Column(nullable = false)
  private String imageUrl;

  @Column(nullable = false)
  private Float starRating;

}
