package jp.co.yahoo.tetsufuru1968.hackathon.service;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyExchangeDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class If2018006Service {

	WalletService walletService;

	public void CurrencyExchange(CurrencyExchangeDto currencyExchangeDto) {

		walletService.currencyExchange(currencyExchangeDto);

	}

	// 所持金取得
	public CurrencyListDto getCurrencyList(UserDto userDto) {

		return walletService.getCurrencyList(userDto);

	}
}
