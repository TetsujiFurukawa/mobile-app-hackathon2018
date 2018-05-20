package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyExchangeDto;
import jp.co.yahoo.tetsufuru1968.hackathon.service.WalletService;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180004")
@NoArgsConstructor
public class If20180004RestController {

	@Autowired
	WalletService walletService;

	@PostMapping
	public void CurrencyExchange(@RequestBody CurrencyExchangeDto currencyExchangeDto) {
		walletService.currencyExchange(currencyExchangeDto);
	}

}
