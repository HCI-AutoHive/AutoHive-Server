package com.hci.autohive.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Detail {

  @Id
  @Column(nullable = false)
  private Long carId;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "car_id")
  private Car car;

  @Lob
  @Column(nullable = false, columnDefinition = "TEXT")
  private String safety;

  @Lob
  @Column(nullable = false, columnDefinition = "TEXT")
  private String perform;

}

