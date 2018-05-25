package jp.co.yahoo.tetsufuru1968.hackathon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "m_virtual_currency")
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

	// 通貨ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String currency_id;

	// 通貨名
	private String name;

	// ハッシュ値
	private String hash_value;

	// トレードレート
	private Double trade_rate;

}
