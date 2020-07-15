package com.example.demo.daoimpl;

import com.example.demo.dao.ResumeDao;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import com.example.demo.repository.ResumeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResumeDaolmpl implements ResumeDao {
     @Autowired
     private ResumeRepository resumeRepository;

     @Override
     public List<Resume>get_applicants(){
          return resumeRepository.get_applicants();
     }

     @Override
     public void alter_resume(Integer user_id,String name,Boolean gender,String birth,String experience,String education){
           Integer exist_user= resumeRepository.checkUserbyId(user_id);
           if(exist_user !=null)
                resumeRepository.alter_resume(user_id,name,gender,birth,experience,education);
           else
                resumeRepository.add_resume(user_id,name,gender,birth,experience,education);
     }
}