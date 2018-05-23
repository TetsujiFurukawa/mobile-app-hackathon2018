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
public class CurrencyDto {

	// ユーザID
	@Id
	private Integer user_id;

	// 通貨ID
	private String currency_id;

	// 数量
	private Integer number;

}
