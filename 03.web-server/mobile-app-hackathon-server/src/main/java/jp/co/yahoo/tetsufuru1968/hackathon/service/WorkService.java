package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkDto;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WorkRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkService {

	WorkRepository workRepository;

	// 一覧取得
	public List<WorkDto> getWorks(Integer userId) {

		return workRepository.getWorks(userId);

	}

	//	// 登録・更新
	//	public void insertWorks(Work work) {
	//
	//	}

}
