package jp.co.yahoo.tetsufuru1968.hackathon.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Wallet.WlletPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "t_wallet")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(WlletPk.class)
public class Wallet implements Serializable {

	// ユーザID
	@Id
	private Integer user_id;

	// 通貨ID
	@Id
	private String currency_id;

	// 数量
	private Integer number;

	// 複合キー用のクラス
	public class WlletPk implements Serializable {
		// ユーザID
		@Id
		private Integer user_id;

		// 通貨ID
		@Id
		private String currency_id;

	}
}
