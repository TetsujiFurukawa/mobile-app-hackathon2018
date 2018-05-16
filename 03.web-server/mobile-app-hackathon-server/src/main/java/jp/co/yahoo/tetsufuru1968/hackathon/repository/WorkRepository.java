package jp.co.yahoo.tetsufuru1968.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.yahoo.tetsufuru1968.hackathon.dto.WorkDto;

public interface WorkRepository extends JpaRepository<WorkDto, Integer> {
	@Query(value = "SELECT wok.work_id, wok.pay_date, wok.user_id, wok.work_item_id, wok.child_comment, "
			+ "wok.attached_image, wok.parent_comment_id, wok.approval , item.name as work_item_name, item.currency_id,item.number, "
			+ "CASE WHEN wok.approval = 1 THEN 'すごいね' WHEN wok.approval = 2 THEN 'いいね' WHEN wok.approval = 3 THEN 'がんばりましょう' ELSE 'だいじょうぶか？' END AS approval_message "
			+ "FROM spajam.t_work wok INNER JOIN spajam.m_work_item item ON item.work_item_id = wok.work_item_id "
			+ "WHERE wok.user_id=:userId", nativeQuery = true)
	List<WorkDto> getWorks(@Param("userId") Integer userId);
}
