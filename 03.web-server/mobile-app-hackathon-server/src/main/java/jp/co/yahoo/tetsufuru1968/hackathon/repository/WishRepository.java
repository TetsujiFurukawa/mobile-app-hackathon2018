package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Wish;

public interface WishRepository extends JpaRepository<Wish, Integer> {

	@Query(value = "SELECT" +
			"   CASE " +
			"    WHEN wish.number > wall.number " +
			"    THEN CONCAT('おねだりせいこうまであと', wish.number - wall.number, cur.name) " +
			"    ELSE CONCAT('お金がたまりました！', wall.number-wish.number, cur.name,'オーバー') " +
			"    END " +
			"FROM" +
			"  spajam.t_wish wish " +
			"  INNER JOIN spajam.t_wallet wall " +
			"    ON wall.user_id = wish.user_id " +
			"    AND wall.currency_id = wish.currency_id " +
			"  INNER JOIN spajam.m_virtual_currency cur " +
			"    ON cur.currency_id = wish.currency_id " +
			"WHERE wall.user_id = :userId and buyFlg = 0;", nativeQuery = true)
	String findByUserId(@Param("userId") Integer userId);

}
