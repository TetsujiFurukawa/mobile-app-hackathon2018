package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.User;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkListDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkListSearchConditionDto;
import jp.co.yahoo.tetsufuru1968.hackathon.service.If2018002Service;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180002")
@NoArgsConstructor
public class If20180002RestController {

	@Autowired
	If2018002Service if2018002Service;

	@CrossOrigin
	@PostMapping
	public WorkListDto getWorks(@RequestBody WorkListSearchConditionDto searchCondition) {

		// 親かどうか
		UserDto userDto = new UserDto();
		userDto.setUser_id(searchCondition.getUser_id());
		User user = if2018002Service.getUser(userDto);

		Boolean isParent;
		if (user.getDivision() == 1) {
			isParent = true;
		} else {
			isParent = false;
		}

		List<WorkDto> works;
		if (isParent) {
			works = if2018002Service.getChildWorks(user.getFamily_id());
		} else {
			works = if2018002Service.getWorks(searchCondition.getUser_id());

		}

		// 手持ちの通貨を取得
		List<CurrencyDto> currencyList = if2018002Service.getCurrencyList(userDto).getCurrencyList();

		// ステータス取得
		String status = if2018002Service.getStatus(userDto);

		// 返却する。
		WorkListDto workListDto = new WorkListDto(works, currencyList, status, isParent);

		return workListDto;
	}

}
