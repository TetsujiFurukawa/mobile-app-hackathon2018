package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.common.Utility;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.GeometryDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.GeometryDto2;
import jp.co.yahoo.tetsufuru1968.hackathon.service.If2018005Service;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180005")
@NoArgsConstructor
public class If20180005RestController {

	@Autowired
	If2018005Service if2018005ervice;

	@PostMapping
	public void registerGeometry(@RequestBody GeometryDto2 geometryDto2) throws ParseException {

		GeometryDto geometryDto = new  GeometryDto();

		geometryDto.setGeometory_id(geometryDto2.getGeometory_id());
		geometryDto.setUser_id(geometryDto2.getUser_id());
		geometryDto.setSearch_datetime(Utility.convertToDateTimeFromStr(geometryDto2.getSearch_datetime()));
		geometryDto.setLatitude(geometryDto2.getLatitude());
		geometryDto.setLongitude(geometryDto2.getLongitude());

		if2018005ervice.registerGeometry(geometryDto);

	}

}
