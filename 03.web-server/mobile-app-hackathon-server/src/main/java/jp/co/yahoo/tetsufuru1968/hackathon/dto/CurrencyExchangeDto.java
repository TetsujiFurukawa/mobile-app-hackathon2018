package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeDto {

	// 日付
	private String pay_date;

	// 送り元ユーザID
	@Column(nullable = false)
	private Integer src_user_id;

	// 送り先ユーザID	ト
	@Column(nullable = false)
	private Integer target_user_id;

	// 通貨ID
	private String currency_id;

	// 数量
	private Integer number;

}
