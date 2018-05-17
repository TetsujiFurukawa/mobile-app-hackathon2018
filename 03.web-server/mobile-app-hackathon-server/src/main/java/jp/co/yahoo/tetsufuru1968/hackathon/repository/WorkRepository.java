package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Work;

public interface WorkRepository extends JpaRepository<Work, Integer> {
}
