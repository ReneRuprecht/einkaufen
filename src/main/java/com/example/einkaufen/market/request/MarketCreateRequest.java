package com.example.einkaufen.market.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public record MarketCreateRequest(

        @JsonProperty(value = "name")
        String name,

        @JsonProperty(value = "street_name")
        String streetName,

        @JsonProperty(value = "postal_code")
        int postalCode) {
}
