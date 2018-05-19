package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Work;
import jp.co.yahoo.tetsufuru1968.hackathon.service.WorkService;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180005")
@NoArgsConstructor
public class If20180005RestController {

	@Autowired
	WorkService workService;

	@PostMapping
	public Work createWork(@RequestBody Work work) {
		if (work.getWork_id() == null) {
			return workService.create(work);
		} else {
			return workService.update(work);
		}

	}

}
