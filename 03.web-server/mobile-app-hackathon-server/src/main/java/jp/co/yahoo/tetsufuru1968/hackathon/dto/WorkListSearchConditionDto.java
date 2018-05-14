package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkListSearchConditionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	//ユーザID
	//	@Column(nullable = true)
	private int user_id;

}
