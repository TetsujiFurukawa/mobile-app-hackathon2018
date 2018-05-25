package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
	@Query(value = "SELECT * FROM spajam.m_virtual_currency WHERE currency_id = :currencyId", nativeQuery = true)
	Currency findBycurrencyId(@Param("currencyId") String currencyId);
}
