package jp.co.yahoo.tetsufuru1968.hackathon.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "t_wish")
@AllArgsConstructor
@NoArgsConstructor
public class Wish implements Serializable {

	@Id
	@GeneratedValue
	private Integer wish_id;

	// ユーザID
	private Integer user_id;

	// 名前
	private String name;

	// 通貨ID
	private String currency_id;

	// 数量
	private Integer number;

	// 購入フラグ
	private Integer buyFlg;

}
