package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyExchangeDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkDto;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WalletRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WalletService {

	WalletRepository walletRepository;

	// お小遣いの交換
	public List<WorkDto> currencyExchange(CurrencyExchangeDto currencyExchangeDto) {

		return null;

	}

	// 所持金取得
	public CurrencyListDto getCurrencyList(UserDto userDto) {

		return null;

	}
}
