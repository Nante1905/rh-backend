package com.example.restapi.services.job;

import org.springframework.stereotype.Service;

import com.example.restapi.model.job.Job;
import com.example.restapi.model.job.JobDetail;
import com.example.restapi.model.job.JobDiplome;
import com.example.restapi.repositories.job.JobDetailRepository;
import com.example.restapi.repositories.job.JobRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    @Autowired
    EntityManager manager;

    @Autowired
    JobDetailRepository jobDetailRepository;

    @Transactional(rollbackOn = { Exception.class })
    public Optional<JobDetail> save(JobDetail jobDetail) throws Exception {
        Job job = new Job(jobDetail.getTitle(), jobDetail.getVolume(), jobDetail.getMan_day(),
                jobDetail.getSal_min(),
                jobDetail.getSal_max(), jobDetail.getService());

        job = this.jobRepository.save(job);

        JobDiplome jobDiplome = new JobDiplome();
        jobDiplome.setIdJob(job.getIdJob());
        jobDiplome.setCoeff(jobDetail.getJobDiplome().getCoeff());
        jobDiplome.setDiplome(jobDetail.getJobDiplome().getDiplome());

        this.manager.persist(jobDiplome);
        return this.jobDetailRepository.findById(job.getIdJob());
    }
}