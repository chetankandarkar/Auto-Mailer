package com.auto.mailer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.mailer.bean.AutoMailerBean;

@Repository
public interface AutoMailerDao extends JpaRepository<AutoMailerBean, Long> {

}
