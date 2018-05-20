package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserSearchConditionDto;
import jp.co.yahoo.tetsufuru1968.hackathon.service.If2018005Service;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180005")
@NoArgsConstructor
public class If20180005RestController {

	@Autowired
	If2018005Service if2018005ervice;

	@PostMapping
	public UserListDto getExchangetargetUser(@RequestBody UserSearchConditionDto userSearchConditionDto) {
		return if2018005ervice.getExchangetargetUser(userSearchConditionDto);

	}

}
