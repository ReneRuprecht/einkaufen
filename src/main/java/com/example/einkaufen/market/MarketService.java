package com.example.einkaufen.market;

import com.example.einkaufen.market.request.MarketCreateRequest;
import com.example.einkaufen.market.utils.MarketMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;

    public Market save(MarketCreateRequest marketCreateRequest) {
        Market market = MarketMapper.toMarket(marketCreateRequest);

        return marketRepository.save(market);
    }
}
