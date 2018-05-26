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
		Integer userId = userDto.getUser_id();
		String param1 = "おねだりせいこうまであと";
		String param2 = "お金がたまりました！";
		String param3 = "オーバー";

		return wishRepository.findByUserId(userId).replace("@param1", param1).replace("@param2", param2)
				.replace("@param3", param3);
	}
}
