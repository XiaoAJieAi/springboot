package com.n22.springboot.dao.db1;

import org.springframework.stereotype.Repository;

import com.n22.springboot.model.SysLog;

@Repository
public interface SysLogDao {

	public void saveSysLog(SysLog sysLog);
}
