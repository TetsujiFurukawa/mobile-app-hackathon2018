package jp.co.yahoo.tetsufuru1968.hackathon.api.spajam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Geometry;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.GeometryDto;
import jp.co.yahoo.tetsufuru1968.hackathon.service.If2018005Service;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/spajam/if20180005")
@NoArgsConstructor
public class If20180005RestController {

	@Autowired
	If2018005Service if2018005ervice;

	@PostMapping
	public void registerGeometry(@RequestBody GeometryDto geometryDto) {
		Geometry geometry = new Geometry();
		geometry.setUser_id(geometryDto.getUser_id());
		geometry.setSearch_datetime(geometryDto.getSearch_datetime());
		String user_geometry = "'POINT(" + geometryDto.getLongitude().toString() + " " + geometryDto.getLatitude()
				+ ")'";
		geometry.setUser_geometry(new Point(geometryDto.getLongitude(), geometryDto.getLatitude()));
		geometry.setUser_geometry(new Point(geometryDto.getLongitude(), geometryDto.getLatitude()));

		if2018005ervice.registerGeometry(geometry);

	}

}
