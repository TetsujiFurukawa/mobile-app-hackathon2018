package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 労働一覧DTOクラス
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkListDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// 労働一覧リスト
	List<WorkDto> workList;

	// 通貨リスト
	List<CurrencyDto> currencyList;

	public String status;

	public Boolean isParent;
}
