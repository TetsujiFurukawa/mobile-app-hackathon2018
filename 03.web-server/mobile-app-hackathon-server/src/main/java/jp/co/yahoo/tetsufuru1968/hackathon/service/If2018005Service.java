package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.GeometryDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class If2018005Service {

	GeometryService geometryService;

	public void registerGeometry(GeometryDto geometryDto) {
		List<GeometryDto> geometryList = geometryService.findByUserId(geometryDto);

		if (geometryList.size() > 0) {
			geometryDto.setGeometory_id(geometryList.get(0).getGeometory_id());
			//			geometryService.?
		}
		geometryService.saveGeometry(geometryDto);

	}
}
