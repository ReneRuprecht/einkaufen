package com.example.einkaufen.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
public class Market {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  @JsonProperty(value = "name")
  private String name;

  @Column(name = "street_name")
  @JsonProperty(value = "street_name")
  private String streetName;

  @Column(name = "postal_code")
  @JsonProperty(value = "postal_code")
  private int postalCode;

}
