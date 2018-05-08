package jp.co.yahoo.tetsufuru1968.hackathon.dto;

import java.io.Serializable;
import java.util.List;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.WorkItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 労働一覧DTOクラス
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkItemListDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// 労働一覧リスト
	List<WorkItem> workItemList;
}
