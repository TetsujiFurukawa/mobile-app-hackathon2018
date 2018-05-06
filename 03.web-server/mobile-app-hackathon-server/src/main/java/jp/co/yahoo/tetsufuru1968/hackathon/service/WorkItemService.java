package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.WorkItem;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WorkItemRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkItemService {

	WorkItemRepository workItemRepository;

	public List<WorkItem> getWorkItems() {

		return workItemRepository.findAll();
	}

}
