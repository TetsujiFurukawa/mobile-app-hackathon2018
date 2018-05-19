package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchConditionDto {

	// ユーザID
	private Integer user_id;

	// 検索日時
	private String search_datetime;

	// 緯度
	private String latitude;

	// 経度
	private String longitude;
}
