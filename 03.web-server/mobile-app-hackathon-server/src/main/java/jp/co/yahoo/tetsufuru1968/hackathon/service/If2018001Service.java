package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.WorkItem;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class If2018001Service {

	WorkItemService workItemService;

	// アイテムを全件取得する
	public List<WorkItem> getWorkItems() {

		return workItemService.getWorkItems();
	}

}
