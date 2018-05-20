package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import jp.co.yahoo.tetsufuru1968.hackathon.service.If2018006Service;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180006")
@NoArgsConstructor
public class If20180006RestController {

	@Autowired
	If2018006Service if2018006Service;

	@PostMapping
	public CurrencyListDto getWallet(@RequestBody UserDto userDto) {

		return if2018006Service.getCurrencyList(userDto);

	}

}
