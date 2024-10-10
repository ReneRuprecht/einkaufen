package com.example.einkaufen.market.utils;

import com.example.einkaufen.market.Market;
import com.example.einkaufen.market.request.MarketCreateRequest;
import com.example.einkaufen.market.response.MarketCreateResponse;

public class MarketMapper {

    public static Market toMarket(MarketCreateRequest marketCreateRequest) {
        return Market.builder()
                     .name(marketCreateRequest.name())
                     .streetName(marketCreateRequest.streetName())
                     .postalCode(marketCreateRequest.postalCode())
                     .build();
    }

    public static MarketCreateResponse toMarketCreateResponse(Market market) {
        return MarketCreateResponse.builder()
                                   .name(market.getName())
                                   .build();
    }

}
