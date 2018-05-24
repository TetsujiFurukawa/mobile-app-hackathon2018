package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.FriendSearchConditionDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.GeometryDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class If2018006Service {

	private static final int DIFFER_SEARCH_LATITUDE = 100;
	private static final int DIFFER_SEARCH_LONGITUDE = 100;

	// 5分いないにふるふる
	private static final int DIFFER_SEARCH_TIME = 500;

	UserService userService;

	GeometryService geometryService;

	WalletService walletService;

	public List<UserDto> searchFriends(Integer user_id) {
		GeometryDto geometryDto= new GeometryDto();
		geometryDto.setUser_id(user_id);
		List<GeometryDto> geometryList = geometryService.findByUserId(geometryDto);

		if (geometryList.size() > 0) {
			FriendSearchConditionDto friendSearchConditionDto = new FriendSearchConditionDto();

//			LocalDateTime localDateTimeFrom =  LocalDateTime.now();
//			LocalDateTime localDateTimeTo =  LocalDateTime.now();

//			LocalDateTime localDateTimeFrom = geometryList.get(0).getSearch_datetime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDateTime localDateTimeFrom= LocalDateTime.now().plusMinutes(-DIFFER_SEARCH_TIME);
			LocalDateTime localDateTimeTo=LocalDateTime.now().plusMinutes(DIFFER_SEARCH_TIME);

			friendSearchConditionDto.setSearch_datetimeFrom(convertToDate(localDateTimeFrom));
			friendSearchConditionDto.setSearch_datetimeTo(convertToDate(localDateTimeTo));


			friendSearchConditionDto.setLatitudeFrom(geometryList.get(0).getLatitude()-DIFFER_SEARCH_LATITUDE);
			friendSearchConditionDto.setLatitudeTo(geometryList.get(0).getLatitude()+DIFFER_SEARCH_LATITUDE);

			friendSearchConditionDto.setLongitudeFrom(geometryList.get(0).getLongitude()-DIFFER_SEARCH_LONGITUDE);
			friendSearchConditionDto.setLongitudeTo(geometryList.get(0).getLongitude()+DIFFER_SEARCH_LONGITUDE);

			friendSearchConditionDto.setUser_id(user_id);

			List<UserDto> friends =userService.getFriends(friendSearchConditionDto);

			return friends;

		}else {
			List<UserDto> res = new ArrayList<UserDto>();
			return res;
		}

	}

//	private static LocalDateTime convertTOLocalDatetime(Date date) {
//		Instant instant = date.toInstant();
//		ZoneId zone = ZoneId.systemDefault();
//		LocalDateTime converted = LocalDateTime.ofInstant(instant, zone);
//		return converted;
//	}

	private static Date convertToDate(LocalDateTime localDateTime) {
		ZoneId zone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zone);

		Instant instant = zonedDateTime.toInstant();
		Date date = Date.from(instant);

		return date;
	}

	public CurrencyListDto getCurrencyList(UserDto userDto) {
		return walletService.getCurrencyList(userDto);
	}
}
