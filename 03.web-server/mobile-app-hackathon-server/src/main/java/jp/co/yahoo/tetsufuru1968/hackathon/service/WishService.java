package jp.co.yahoo.tetsufuru1968.hackathon.service;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WishRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WishService {

	WishRepository wishRepository;

	// 目標までいくらかを取得する
	public String getStatus(UserDto userDto) {
		Integer userId=userDto.getUser_id();
		return wishRepository.findByUserId(userId);
	}
}
