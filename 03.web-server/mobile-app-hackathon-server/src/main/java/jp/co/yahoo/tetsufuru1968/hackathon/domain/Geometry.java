package jp.co.yahoo.tetsufuru1968.hackathon.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.geo.Point;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_geometry")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geometry {

	// 位置ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer geometory_id;

	// ユーザID
	private Integer user_id;

	// 検索日時
	private Date search_datetime;

	// 位置
	@Column(name = "user_geometry", columnDefinition = "POINT")
	//	@Column(name = "user_geometry", columnDefinition = "geometry(Point,4326)")
	//	@Column(columnDefinition = "geometry")
	//	@Column(name = "locationpoint", columnDefinition = "POINT")
	//	@Type(type = "org.hibernate.spatial.GeometryType")
	private Point user_geometry;

}
