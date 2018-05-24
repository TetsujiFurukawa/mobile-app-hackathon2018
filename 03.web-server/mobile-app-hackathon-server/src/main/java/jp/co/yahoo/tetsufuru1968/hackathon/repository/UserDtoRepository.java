package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.UserDto;

public interface UserDtoRepository extends JpaRepository<UserDto, Integer> {

	@Query(value =
			"SELECT " +
			"  geo.user_id " +
			"  , usr.name as user_name " +
			"FROM " +
			"  spajam.t_geometry geo " +
			"  INNER JOIN spajam.m_user usr " +
			"    ON usr.user_id = geo.user_id " +
			"WHERE " +
			"  geo.search_datetime BETWEEN :searchDatetimeFrom AND :searchDatetimeTo " +
			"  and geo.latitude BETWEEN :latitudeFrom AND :latitudeTo " +
			"  and geo.longitude BETWEEN :longitudeFrom AND :longitudeTo " +
			"  AND geo.user_id <> :userId", nativeQuery = true)

	List<UserDto> getFriends(@Param("userId") Integer userId,
			@Param("searchDatetimeFrom") Date searchDatetimeFrom,@Param("searchDatetimeTo") Date searchDatetimeTo,
			@Param("latitudeFrom") Double latitudeFrom,@Param("latitudeTo") Double latitudeTo,
			@Param("longitudeFrom") Double longitudeFrom,@Param("longitudeTo") Double longitudeTo);
}
