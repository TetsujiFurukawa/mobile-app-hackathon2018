package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Geometry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class If2018005Service {

	GeometryService geometryService;

	public void registerGeometry(Geometry geometry) {
		List<Geometry> geometryList = geometryService.findByUserId(geometry);

		if (geometryList.size() > 0) {
			geometry.setGeometory_id(geometryList.get(0).getGeometory_id());
			//			geometryService.?
		}
		geometryService.insertGeometry(geometry);

	}
}
