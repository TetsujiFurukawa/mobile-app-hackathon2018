package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.User;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.FriendSearchConditionDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.UserDtoRepository;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	UserRepository userRepository;
	UserDtoRepository userDtoRepository;

	public User getUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);

		if (user != null) {
			return user.get();
		} else {
			return null;
		}
	}

	public List<UserDto> getFriends(FriendSearchConditionDto friendSearchConditionDto) {
		List<UserDto> friends =userDtoRepository.getFriends(friendSearchConditionDto.getUser_id(),
				friendSearchConditionDto.getSearch_datetimeFrom(),friendSearchConditionDto.getSearch_datetimeTo(),
				friendSearchConditionDto.getLatitudeFrom(),friendSearchConditionDto.getLatitudeTo(),
				friendSearchConditionDto.getLongitudeFrom(),friendSearchConditionDto.getLongitudeTo());

		return friends;
	}

}
