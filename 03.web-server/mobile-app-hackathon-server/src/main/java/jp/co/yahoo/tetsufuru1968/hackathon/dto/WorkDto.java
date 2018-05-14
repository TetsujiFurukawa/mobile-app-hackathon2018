package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import javax.persistence.Entity;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Work;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
public class WorkDto extends Work {

	// 労働アイテム名称
	private String work_item_name;

	// 通貨ID
	private String currency_id;

	// 数量
	private Integer number;

	// 承認文言
	private String approval_message;

}
