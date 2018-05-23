package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
	@Modifying
	@Query(value = "UPDATE spajam.t_wallet SET spajam.t_wallet.number = number + :number WHERE user_id = :userId AND currency_id = :currencyId", nativeQuery = true)
	int addNumber(@Param("userId") Integer userId, @Param("currencyId") String currencyId,
			@Param("number") Integer number);

	@Query(value = "SELECT wal.user_id,wal.currency_id,wal.wallet_id,wal.number FROM spajam.t_wallet wal WHERE wal.user_id = :userId AND wal.currency_id = :currencyId", nativeQuery = true)
	List<Wallet> findByCurrency(@Param("userId") Integer userId, @Param("currencyId") String currencyId);

	//	@Query(value = "SELECT wal.user_id,wal.currency_id as currency_id,wal.number as number FROM spajam.t_wallet wal WHERE wal.user_id = :userId", nativeQuery = true)
	//	List<Wallet> findByUserId(@Param("userId") Integer userId);

}
