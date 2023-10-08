package com.example.restapi.services.job;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.restapi.model.job.Job;
import com.example.restapi.model.job.JobDetail;
import com.example.restapi.model.job.JobDiplome;
import com.example.restapi.model.job.JobExperience;
import com.example.restapi.model.job.JobInfo;
import com.example.restapi.model.job.JobMatrimonial;
import com.example.restapi.model.job.JobNationalite;
import com.example.restapi.model.job.JobSexe;
import com.example.restapi.model.qcm.Question;
import com.example.restapi.model.qcm.Questionnaire;
import com.example.restapi.model.qcm.Reponse;
import com.example.restapi.repositories.job.JobDetailRepository;
import com.example.restapi.repositories.job.JobInfoRepository;
import com.example.restapi.repositories.job.JobRepository;
import com.example.restapi.repositories.qcm.QuestionRepository;
import com.example.restapi.repositories.qcm.QuestionnaireRepository;
import com.example.restapi.repositories.qcm.ReponseRepository;

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
    @Autowired
    QuestionnaireRepository questionnaireRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ReponseRepository reponseRepository;
    @Autowired
    JobInfoRepository jobInfoRepository;

    public List<JobDetail> findAll() {
        return this.jobDetailRepository.findAll();
    }

    public Optional<JobDetail> findById(int id) {
        return this.jobDetailRepository.findById(id);
    }

    public List<JobInfo> findJobInfo() {
        return this.jobInfoRepository.findAll(Sort.by("jour").ascending());
    }

    @Transactional(rollbackOn = { Exception.class })
    public Optional<JobDetail> save(JobDetail jobDetail) throws Exception {
        Job job = new Job(jobDetail.getTitle(), jobDetail.getVolume(), jobDetail.getMan_day(),
                jobDetail.getSal_min(),
                jobDetail.getSal_max(), jobDetail.getService());
        // System.out.println("JOBSERVICEFRONT => " + jobDetail.getService().getId());

        job = this.jobRepository.save(job);

        // job.getService().setIdService(1);

        JobDiplome jobDiplome = jobDetail.getJobDiplome();
        jobDiplome.setIdJob(job.getIdJob());
        this.manager.persist(jobDiplome);

        JobExperience jobExperience = jobDetail.getJobExperience();
        jobExperience.setIdJob(job.getIdJob());
        this.manager.persist(jobExperience);

        JobMatrimonial jobMatrimoniale = jobDetail.getJobMatrimoniale();
        jobMatrimoniale.setIdJob(job.getIdJob());
        this.manager.persist(jobMatrimoniale);

        JobNationalite jobNationalite = jobDetail.getJobNationalite();
        jobNationalite.setIdJob(job.getIdJob());
        this.manager.persist(jobNationalite);

        JobSexe jobSexe = jobDetail.getJobSexe();
        jobSexe.setIdJob(job.getIdJob());
        this.manager.persist(jobSexe);

        Questionnaire qcm = jobDetail.getQuestionnaire();
        // System.out.println("from front >>>> " + qcm.toString());
        qcm.setIdJob(job.getIdJob());
        qcm = questionnaireRepository.save(qcm);
        // System.out.println(" >>>>> after insert >>>>> " + qcm.toString());
        System.out.println(qcm.getQuestions().size());
        for (Question q : qcm.getQuestions()) {
            q.setIdQuestionnaire(qcm.getId());
            q = questionRepository.save(q);
            // System.out.println(" after insert >>>>> " + q.toString());
            for (Reponse r : q.getReponses()) {
                // System.out.println("R ID " + r.getId());
                r.setIdQuestion(q.getId());
            }
            reponseRepository.saveAll(q.getReponses());
        }
        return this.jobDetailRepository.findById(job.getIdJob());
    }

}