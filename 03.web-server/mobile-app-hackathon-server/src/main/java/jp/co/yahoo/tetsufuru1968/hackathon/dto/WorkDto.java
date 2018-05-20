package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkDto {

	// 労働実績ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer work_id;

	//日付
	@Column(nullable = false)
	private Date pay_date;

	//ユーザID
	@Column(nullable = false)
	private Integer user_id;

	//労働アイテムID
	@Column(nullable = false)
	private Integer work_item_id;

	//子供コメント
	@Column(nullable = false)
	private String child_comment;

	// 添付画像
	@Column(nullable = true)
	private byte[] attached_image;

	// 親コメントID
	@Column(nullable = true)
	private Integer parent_comment_id;

	// 承認フラグ
	@Column(nullable = true)
	private Integer approval;

	// 労働アイテム名称
	private String work_item_name;

	// 通貨ID
	private String currency_id;

	// 数量
	private Integer number;

	// 承認文言
	private String approval_message;

}
