package com.example.einkaufen.market.response;

import com.example.einkaufen.market.Market;

import java.util.List;

public record MarketGetAllResponse(List<Market> markets) {
}
