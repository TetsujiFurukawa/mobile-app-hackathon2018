package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
