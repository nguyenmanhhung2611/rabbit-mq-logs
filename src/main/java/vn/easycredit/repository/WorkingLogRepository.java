package vn.easycredit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.easycredit.domain.entity.WorkingLog;

@Repository
public interface WorkingLogRepository extends JpaRepository<WorkingLog, String> {
    
    @Query("SELECT wl FROM WorkingLog wl")
    Page<WorkingLog> findAll(Pageable pageable);
}
