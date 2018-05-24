package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	// ユーザID
	@Id
	private Integer user_id;

	// ユーザ名
	private String user_name;

}
