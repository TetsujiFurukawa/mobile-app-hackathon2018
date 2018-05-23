package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Geometry;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.GeometryDtoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GeometryService {

	GeometryDtoRepository geometryRepository;

	public List<Geometry> findByUserId(Geometry geometry) {
		return geometryRepository.findByUserId(geometry.getUser_id());
	}

	public void insertGeometry(Geometry geometry) {
		geometryRepository.insertGeometry(geometry.getUser_id(), geometry.getSearch_datetime(),
				geometry.getUser_geometry());
	}
}
