package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.common.Utility;
import jp.co.yahoo.tetsufuru1968.hackathon.domain.Work;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkDto2;
import jp.co.yahoo.tetsufuru1968.hackathon.service.If2018003Service;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180003")
@NoArgsConstructor
public class If20180003RestController {

	@Autowired
	If2018003Service if2018003Service;

	@PostMapping
	public Work registerWork(@RequestBody WorkDto2 workDto2) throws ParseException {
		// 新規登録もしくは更新する

		Work work = new Work();
		work.setWork_id(workDto2.getWork_id());
		work.setPay_date(Utility.convertToDateTimeFromStr(workDto2.getPay_date()));
		work.setUser_id(workDto2.getUser_id());
		work.setWork_item_id(workDto2.getWork_item_id());
		work.setChild_comment(workDto2.getChild_comment());
		work.setAttached_image(workDto2.getAttached_image());
		work.setParent_comment_id(workDto2.getParent_comment_id());
		work.setApproval(workDto2.getApproval());

		return if2018003Service.registerWork(work);

	}

}
