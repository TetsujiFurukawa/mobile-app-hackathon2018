package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {

	// 通貨ID
	private String currency_id;

	// 数量
	private Integer number;

}
