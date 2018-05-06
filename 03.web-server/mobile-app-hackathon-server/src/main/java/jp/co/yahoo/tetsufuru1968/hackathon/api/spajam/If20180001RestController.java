package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.WorkItem;
import jp.co.yahoo.tetsufuru1968.hackathon.service.WorkItemService;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180001")
@NoArgsConstructor
public class If20180001RestController {

	@Autowired
	WorkItemService workItemService;

	@GetMapping
	public List<WorkItem> getWorkItems() {
		List<WorkItem> workItems = workItemService.getWorkItems();

		return workItems;
	}

}
