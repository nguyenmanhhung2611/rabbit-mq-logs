package vn.easycredit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.easycredit.domain.entity.HistoryCall;

@Repository
public interface HistoryCallRepository extends JpaRepository<HistoryCall, Long> {
    
	@Query("SELECT hc FROM HistoryCall hc")
    Page<HistoryCall> findAll(Pageable pageable);
}
