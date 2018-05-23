package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.User;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class If2018002Service {

	WorkDtoService workDtoService;
	WalletService walletService;
	WishService wishService;
	UserService userService;

	// 一覧を取得する
	public List<WorkDto> getWorks(Integer userId) {

		return workDtoService.getWorks(userId);

	}

	// 所持金取得
	public CurrencyListDto getCurrencyList(UserDto userDto) {

		return walletService.getCurrencyList(userDto);

	}

	// ステータス取得
	public String getStatus(UserDto userDto) {

		return wishService.getStatus(userDto);

	}

	public Boolean isParent(UserDto userDto) {
		User user = userService.getUser(userDto.getUser_id());
		if ("1".equals(user.getDivision())) {
			return true;
		} else {
			return false;
		}

	}

}
