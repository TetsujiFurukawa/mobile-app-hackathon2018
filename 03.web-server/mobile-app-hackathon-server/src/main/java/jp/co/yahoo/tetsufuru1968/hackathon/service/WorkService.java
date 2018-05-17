package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Work;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkDto;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WorkDtoRepository;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WorkRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkService {

	WorkDtoRepository workDtoRepository;
	WorkRepository workRepository;

	// 一覧取得
	public List<WorkDto> getWorks(Integer userId) {

		return workDtoRepository.getWorks(userId);

	}

	// 登録する
	public Work create(Work work) {
		return workRepository.save(work);

	}

	// 更新する
	public Work update(Work work) {
		return workRepository.save(work);
	}

}
