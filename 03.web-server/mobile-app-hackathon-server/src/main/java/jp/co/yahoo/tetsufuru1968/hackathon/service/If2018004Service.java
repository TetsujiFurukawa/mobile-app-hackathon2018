package jp.co.yahoo.tetsufuru1968.hackathon.service;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyExchangeDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class If2018004Service {

	WalletService walletService;

	public void CurrencyExchange(CurrencyExchangeDto currencyExchangeDto) {

		walletService.currencyExchange(currencyExchangeDto);

	}
}
