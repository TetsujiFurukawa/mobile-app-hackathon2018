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

	public List<WorkDto> getWorks(Integer userId) {

		return workRepository.getWorks(userId);

	}

}
