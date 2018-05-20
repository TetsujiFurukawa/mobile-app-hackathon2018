package jp.co.yahoo.tetsufuru1968.hackathon.service;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserSearchConditionDto;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	UserRepository userRepository;

	public UserListDto getExchangetargetUser(UserSearchConditionDto userSearchConditionDto) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
