package com.example.restapi.services.job;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.job.Job;
import com.example.restapi.model.job.JobDetail;
import com.example.restapi.model.job.JobDiplome;
import com.example.restapi.model.job.JobExperience;
import com.example.restapi.model.job.JobMatrimoniale;
import com.example.restapi.model.job.JobNationalite;
import com.example.restapi.model.job.JobSexe;
import com.example.restapi.repositories.job.JobDetailRepository;
import com.example.restapi.repositories.job.JobRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

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
        System.out.println("JOBSERVICEFRONT => " + jobDetail.getService().getIdService());

        job = this.jobRepository.save(job);

        JobDiplome jobDiplome = jobDetail.getJobDiplome();
        jobDiplome.setIdJob(job.getIdJob());
        this.manager.persist(jobDiplome);

        JobExperience jobExperience = jobDetail.getJobExperience();
        jobExperience.setIdJob(job.getIdJob());
        this.manager.persist(jobExperience);

        JobMatrimoniale jobMatrimoniale = jobDetail.getJobMatrimoniale();
        jobMatrimoniale.setIdJob(job.getIdJob());
        this.manager.persist(jobMatrimoniale);

        JobNationalite jobNationalite = jobDetail.getJobNationalite();
        jobNationalite.setIdJob(job.getIdJob());
        this.manager.persist(jobNationalite);

        JobSexe jobSexe = jobDetail.getJobSexe();
        jobSexe.setIdJob(job.getIdJob());
        this.manager.persist(jobSexe);

        return this.jobDetailRepository.findById(job.getIdJob());
    }
}