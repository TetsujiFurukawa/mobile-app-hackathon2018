package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 友達一覧検索用DTOクラス
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendSearchConditionDto {

	// ユーザID
	private Integer user_id;

	// 検索日時　From
	private Date search_datetimeFrom;

	// 検索日時　To
	private Date search_datetimeTo;

	// 緯度　From
	private Double latitudeFrom;

	// 緯度　To
	private Double latitudeTo;

	// 経度　From
	private Double longitudeFrom;

	// 経度　To
	private Double longitudeTo;

}
