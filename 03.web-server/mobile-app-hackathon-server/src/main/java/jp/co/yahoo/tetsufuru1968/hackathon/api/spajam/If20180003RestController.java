package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Work;
import jp.co.yahoo.tetsufuru1968.hackathon.service.If2018003Service;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180003")
@NoArgsConstructor
public class If20180003RestController {

	@Autowired
	If2018003Service if2018003Service;

	@PostMapping
	public Work registerWork(@RequestBody Work work) {
		// 新規登録もしくは更新する
		return if2018003Service.registerWork(work);

	}

}