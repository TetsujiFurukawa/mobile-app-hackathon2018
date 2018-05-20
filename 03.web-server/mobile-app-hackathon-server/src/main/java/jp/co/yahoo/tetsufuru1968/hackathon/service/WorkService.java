package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Work;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WorkRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkService {

	//	WorkDtoRepository workDtoRepository;
	WorkRepository workRepository;

	// 登録する
	public Work create(Work work) {
		Date payDate = new Date();
		work.setPay_date(payDate);
		return workRepository.save(work);

	}

	// 更新する
	public Work update(Work work) {
		return workRepository.save(work);
	}

}
