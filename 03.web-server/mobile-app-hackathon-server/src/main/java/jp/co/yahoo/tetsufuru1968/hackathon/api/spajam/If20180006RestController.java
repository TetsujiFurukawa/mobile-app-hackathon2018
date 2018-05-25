package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.FriendListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import jp.co.yahoo.tetsufuru1968.hackathon.service.If2018006Service;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180006")
@NoArgsConstructor
public class If20180006RestController {

	@Autowired
	If2018006Service if2018006service;

	@CrossOrigin
	@PostMapping
	public FriendListDto searchFriends(@RequestBody UserDto userDto) {
		// 友達を検索
		List<UserDto> friends = if2018006service.searchFriends(userDto.getUser_id());

		// 手持ちの通貨を取得
		List<CurrencyDto> currencyList = if2018006service.getCurrencyList(userDto).getCurrencyList();

		FriendListDto friendListDto = new FriendListDto();

		friendListDto.setUserList(friends);
		friendListDto.setCurrencyList(currencyList);

		return friendListDto;

	}

}
