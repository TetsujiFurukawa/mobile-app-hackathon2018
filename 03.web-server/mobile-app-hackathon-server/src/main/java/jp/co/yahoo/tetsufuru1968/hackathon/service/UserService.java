package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.User;
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

	public User getUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);

		if (user != null) {
			return user.get();
		} else {
			return null;
		}
	}

}
