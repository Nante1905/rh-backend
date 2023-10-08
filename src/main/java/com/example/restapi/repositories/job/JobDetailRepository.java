package com.example.restapi.repositories.job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restapi.model.job.JobDetail;

public interface JobDetailRepository extends JpaRepository<JobDetail, Integer> {
    @Query(value = "select * from job where id not in (select id_job from candidature where id_cv in (select id from cv where id_utilisateur=?1))", nativeQuery = true)
    public List<JobDetail> findJobNotApplied(int id);
}
