package jp.co.yahoo.tetsufuru1968.hackathon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "m_work_item")
@Data
@NoArgsConstructor
public class WorkItem {

	// 労働アイテムID
	@Id
	@GeneratedValue
	private Integer work_item_id;

	//名称
	@Column(nullable = false)
	private String name;

	// 通貨ID
	@Column(nullable = false)
	private String currency_id;

	// 数量
	@Column(nullable = false)
	private Integer number;
}
