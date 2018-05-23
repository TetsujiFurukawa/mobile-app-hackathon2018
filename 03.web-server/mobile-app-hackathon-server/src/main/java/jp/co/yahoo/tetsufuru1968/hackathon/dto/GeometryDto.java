package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_geometry")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeometryDto {

	// 位置ID
	@Id
	private Integer geometory_id;

	// ユーザID
	private Integer user_id;

	// 検索日時
	private Date search_datetime;

	// 緯度
	private Double latitude;

	// 経度
	private Double longitude;

}
