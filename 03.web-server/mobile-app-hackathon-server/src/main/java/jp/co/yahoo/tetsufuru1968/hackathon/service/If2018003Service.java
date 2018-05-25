package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Work;
import lombok.AllArgsConstructor;
import twitter4j.TwitterException;

@Service
@AllArgsConstructor
public class If2018003Service {

	WorkService workService;

	public Work registerWork(Work work) throws IOException, InterruptedException, TwitterException {
		if (work.getWork_id() == null) {
			// 新規作成する
			return workService.create(work);
		} else {
			// 更新する
			return workService.update(work);
		}

	}
}
