package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.GeometryDto;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.GeometryDtoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GeometryService {

	GeometryDtoRepository geometryRepository;

	public List<GeometryDto> findByUserId(GeometryDto geometryDto) {
		return geometryRepository.findByUserId(geometryDto.getUser_id());
	}

	public void saveGeometry(GeometryDto geometryDto) {
		geometryRepository.save(geometryDto);
	}

//	public void insertGeometry(Geometry geometry) {
//		geometryRepository.insertGeometry(geometry.getUser_id(), geometry.getSearch_datetime(),
//				geometry.getUser_geometry());
//	}
}
