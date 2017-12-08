package com.pmy.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmy.dao.ProviderMapping;
import com.pmy.dao.UserMapping;
import com.pmy.entity.Provider;
import com.pmy.entity.User;
import com.pmy.service.ProviderService;
import com.pmy.service.UserService;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService{
	@Autowired
	private ProviderMapping providerMapping;
	
	/**
	 * 根据条件查询供应商列表
	 */
	public List<Provider> getProviderList(String queryProCode,
			String queryProName, int pageIndex, int pageSize) {
		return providerMapping.getProviderList(queryProCode, queryProName, (pageIndex-1)*pageSize, pageSize);
	}
	
	/**
	 * 根据供应商编码或供应商名称查询返回的记录数
	 */
	public int getProviderRows(String proCode, String proName) {
		// TODO Auto-generated method stub
		return providerMapping.getProviderRows(proCode, proName);
	}
	
	/**
	 * 增加供应商
	 */
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return providerMapping.addProvider(provider);
	}

	/**
	 * 删除供应商
	 */
	public int delProvider(Integer id) {
		return providerMapping.delProvider(id);
	}

	/**
	 * 根据供应商id查看供应商
	 */
	public Provider getProviderById(Long id) {
		return providerMapping.getProviderById(id);
	}

	/**
	 * 修改供应商
	 */
	public int updateProvider(Provider provider) {
		return providerMapping.updateProvider(provider);
	}
}
