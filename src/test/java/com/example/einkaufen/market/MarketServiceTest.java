package com.example.einkaufen.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.einkaufen.market.dto.MarketCreateDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MarketServiceTest {

  @Mock
  private MarketRepository marketRepository;

  @InjectMocks
  private MarketService underTest;

  private MarketCreateDto marketCreateDto;

  @BeforeEach
  void setUp() {
    marketCreateDto = new MarketCreateDto("Market1", "StreetName1", 1234);
  }

  @Test
  void save() {
    Market savedMarket = new Market(1L, "Market1", "StreetName1", 1234);

    when(marketRepository.save(any(Market.class))).thenReturn(savedMarket);

    Market createdMarket = underTest.save(marketCreateDto);

    assertEquals(savedMarket.getId(), createdMarket.getId());
    assertEquals(savedMarket.getName(), createdMarket.getName());
    assertEquals(savedMarket.getStreetName(), createdMarket.getStreetName());
    assertEquals(savedMarket.getPostalCode(), createdMarket.getPostalCode());

    verify(marketRepository, times(1)).save(any(Market.class));

  }

  @Test
  void findAll() {
    List<Market> markets = List.of(new Market(1L, "Market1", "StreetName1", 1234));

    when(marketRepository.findAll()).thenReturn(markets);

    List<Market> result = underTest.findAll();

    assertEquals(1, result.size());
    verify(marketRepository, times(1)).findAll();
  }
}