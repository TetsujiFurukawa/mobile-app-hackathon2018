package jp.co.yahoo.tetsufuru1968.hackathon.domain;

import java.io.Serializable;

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
@Table(name = "t_wallet")
@AllArgsConstructor
@NoArgsConstructor
public class Wallet implements Serializable {

	// お財布ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer wallet_id;

	// ユーザID
	private Integer user_id;

	// 通貨ID
	private String currency_id;

	// 数量
	private Integer number;

}
