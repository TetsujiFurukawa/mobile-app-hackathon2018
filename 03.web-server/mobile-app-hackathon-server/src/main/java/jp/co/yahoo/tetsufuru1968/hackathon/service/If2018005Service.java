package jp.co.yahoo.tetsufuru1968.hackathon.service;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserSearchConditionDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class If2018005Service {

	UserService userService;

	public UserListDto getExchangetargetUser(UserSearchConditionDto userSearchConditionDto) {
		return userService.getExchangetargetUser(userSearchConditionDto);
	}
}
