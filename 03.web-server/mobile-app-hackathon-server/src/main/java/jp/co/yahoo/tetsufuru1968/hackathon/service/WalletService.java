package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Wallet;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyExchangeDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.CurrencyDtoRepository;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WalletRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WalletService {

	WalletRepository walletRepository;
	CurrencyDtoRepository currencyDtoRepository;

	// お小遣いの交換
	public void currencyExchange(CurrencyExchangeDto currencyExchangeDto) {
		Integer srcUserId = currencyExchangeDto.getSrc_user_id();
		Integer trgetUserId = currencyExchangeDto.getTarget_user_id();
		String currencyId = currencyExchangeDto.getCurrency_id();
		Integer number = currencyExchangeDto.getNumber();

		// 送り元から通貨を差し引いて更新する
		walletRepository.addNumber(srcUserId, currencyId, -number);

		// 送信先に通貨を追加する
		List<Wallet> targetWallet = walletRepository.findByCurrency(trgetUserId, currencyId);
		Wallet wallet = new Wallet(trgetUserId, currencyId, number);
		if (targetWallet != null && targetWallet.size() == 0) {
			// レコードが存在しなかった場合は新規登録する
			walletRepository.save(wallet);

		} else {
			// 数量を追加して更新する
			walletRepository.addNumber(trgetUserId, currencyId, number);

		}
	}

	// 所持金取得
	public CurrencyListDto getCurrencyList(UserDto userDto) {
		Integer userId = userDto.getUser_id();
		List<CurrencyDto> CurrencyList = currencyDtoRepository.findByUserId(userId);

		CurrencyListDto currencyListDto = new CurrencyListDto();
		//		currencyListDto.setCurrencyList(CurrencyList);

		return currencyListDto;

	}
}
