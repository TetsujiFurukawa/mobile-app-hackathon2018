package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Geometry;

public interface GeometryDtoRepository extends JpaRepository<Geometry, Integer> {
	@Query(value = "SELECT geometory_id,user_id,search_datetime,null as user_geometry FROM spajam.t_geometry WHERE user_id = :userId", nativeQuery = true)
	List<Geometry> findByUserId(@Param("userId") Integer userId);

	@Modifying
	@Query(value = "INSERT INTO spajam.t_geometry (user_id,search_datetime,user_geometry) VALUES (:userId,:searchDatetime,GeomFromText(:userGeometry))", nativeQuery = true)
	int insertGeometry(@Param("userId") Integer userId, @Param("searchDatetime") Date searchDatetime,
			@Param("userGeometry") Point userGeometry);
	//	@Modifying
	//	@Query(value = "INSERT INTO spajam.t_geometry (user_id,search_datetime,user_geometry) VALUES (:userId,:searchDatetime,GeomFromText('POINT(:latitude :longitude)'))", nativeQuery = true)
	//	int insertGeometry(@Param("userId") Integer userId, @Param("searchDatetime") Date searchDatetime,
	//			@Param("latitude") Double latitude, @Param("longitude") Double longitude);

}
