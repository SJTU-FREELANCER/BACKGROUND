package com.example.demo.dao;

import com.example.demo.entity.Resume;

import java.util.List;

public interface ResumeDao {
    public List<Resume> get_applicants();
    public void alter_resume(Integer user_id,String name,Boolean gender,String birth,String experience,String education);
}