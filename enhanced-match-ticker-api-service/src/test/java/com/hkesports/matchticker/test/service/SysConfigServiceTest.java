package com.hkesports.matchticker.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.model.Code;
import com.hkesports.matchticker.model.Data;
import com.hkesports.matchticker.repository.DataDao;
import com.hkesports.matchticker.service.SysConfigService;
import com.hkesports.matchticker.vo.VersionCheckVo;

public class SysConfigServiceTest extends AbstractTest {
	
	@Resource
	private SysConfigService sysConfigService;
	
	@Resource(name = "dataDao")
	private DataDao dataDao;
	
	@Test
	public void testVersionCheck() throws Exception{
		VersionCheckVo vo = sysConfigService.iosVersionCheck("v_1");
		
		VersionCheckVo vo2 = sysConfigService.androidVersioniCheck("a_v_2");
	}
	
	@Test
	@Ignore
	public void testSaveCodeData(){
		Code code = new Code();
		code.setCodeName("AndroidVersion");
		code.setCodeDesc("用來取得Android version");
		
		List<Data> datas = new ArrayList<>();
		
		Data data = new Data();
		data.setCode(code);
		data.setDataName("a_v_1");
		data.setDataValue("http://aaa.aaa");
		data.setDataDesc("Android version 1!!");
		datas.add(data);
		
		data = new Data();
		data.setCode(code);
		data.setDataName("a_v_2");
		data.setDataValue("http://bbb.bbb");
		data.setDataDesc("Android version 2!!");
		datas.add(data);
		
		dataDao.save(datas);
	}
}
