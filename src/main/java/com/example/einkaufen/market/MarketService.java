package com.example.einkaufen.market;

import com.example.einkaufen.market.dto.MarketCreateDto;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MarketService {

  private final MarketRepository marketRepository;

  public Market save(MarketCreateDto marketCreateDto) {

    Market market = Market.builder().name(marketCreateDto.name())
        .streetName(marketCreateDto.streetName()).postalCode(marketCreateDto.postalCode()).build();

    return marketRepository.save(market);
  }

  public List<Market> findAll() {
    return marketRepository.findAll();
  }
}
