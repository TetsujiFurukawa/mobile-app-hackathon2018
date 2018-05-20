package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Wallet;
import jp.co.yahoo.tetsufuru1968.hackathon.dto.CurrencyDto;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

	@Query(value = "UPDATE spajam.t_wallet SET number = number + :number WHERE user_id = :userId AND currency_id = :currencyId; \r\n", nativeQuery = true)
	void addNumber(@Param("userId") Integer userId, @Param("currencyId") String currency_id,
			@Param("number") Integer number);

	@Query(value = "SELECT wal.user_id FROM spajam.t_wallet wal WHERE wal.user_id = :userId AND wal.currency_id = :currencyId;", nativeQuery = true)
	List<Wallet> findByCurrency(@Param("userId") Integer userId, @Param("currencyId") String currency_id);

	@Query(value = "SELECT wal.currency_id,wal.number FROM spajam.t_wallet wal WHERE wal.user_id = :userId;", nativeQuery = true)
	List<CurrencyDto> findByUserId(@Param("userId") Integer userId);

}