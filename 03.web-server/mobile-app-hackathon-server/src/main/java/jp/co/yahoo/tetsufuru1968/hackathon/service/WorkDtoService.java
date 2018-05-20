package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkDto;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WorkDtoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkDtoService {

	WorkDtoRepository workDtoRepository;

	// 一覧取得
	public List<WorkDto> getWorks(Integer userId) {

		return workDtoRepository.getWorks(userId);

	}

}
