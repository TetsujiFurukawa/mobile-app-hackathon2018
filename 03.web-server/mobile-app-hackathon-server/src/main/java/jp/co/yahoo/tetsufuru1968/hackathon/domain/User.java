package jp.co.yahoo.tetsufuru1968.hackathon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	// ユーザID
	@Id
	@GeneratedValue
	private Integer user_id;

	// 世帯ID
	private Integer family_id;

	// ユーザ名
	private String name;

	// 区分
	private Integer division;

	// ハッシュ値
	private String hash_value;

}
