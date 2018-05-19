package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザ一覧DTOクラス
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// ユーザリスト
	List<UserDto> userList;
}
