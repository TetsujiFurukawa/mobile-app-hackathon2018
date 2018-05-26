package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyDto;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyDto;

public interface CurrencyDtoRepository extends JpaRepository<CurrencyDto, Integer> {

	@Query(value = "SELECT wal.user_id,wal.currency_id as currency_id,wal.number as number FROM spajam.t_wallet wal WHERE wal.user_id = :userId", nativeQuery = true)
	List<CurrencyDto> findByUserId(@Param("userId") Integer userId);

}
