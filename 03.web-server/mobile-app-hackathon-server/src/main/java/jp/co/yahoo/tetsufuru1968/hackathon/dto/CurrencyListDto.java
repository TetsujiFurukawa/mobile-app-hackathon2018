package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユ通貨一覧DTOクラス
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyListDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// 通貨リスト
	List<CurrencyDto> currencyList;
}
