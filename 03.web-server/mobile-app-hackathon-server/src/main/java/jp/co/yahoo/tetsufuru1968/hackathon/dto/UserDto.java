package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	// ユーザID
	private Integer user_id;

	// ユーザ名
	private String user_name;

}
