package jp.co.yahoo.tetsufuru1968.hackathon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "m_family")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MFamily {

	// 世帯ID
	@Id
	@GeneratedValue
	private Integer family_id;

	// 世帯名
	private String name;

}
