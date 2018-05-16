package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class If2018002Service {

	WorkService workService;

	// 一覧を取得する
	public List<WorkDto> getWorks(Integer userId) {

		return workService.getWorks(userId);

	}

}
