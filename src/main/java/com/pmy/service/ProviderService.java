package com.pmy.service;

import java.util.List;

import com.pmy.entity.Provider;

public interface ProviderService {
	/**
	 * 根据条件查询供应商列表
	 * @param queryProCode
	 * @param queryProName
	 * @return
	 */
	public List<Provider> getProviderList(String queryProCode,String queryProName,int pageIndex, int pageSize);
	/**
	 *根据供应商编码或供应商名称查询返回的记录数
	 * @param userName
	 * @param userRole
	 * @return
	 */
	int getProviderRows(String proCode,String  proName);
	/**
	 * 增加供应商
	 * @param provider
	 * @return
	 */
	int addProvider(Provider provider);
	/**
	 * 删除供应商
	 * @param provider
	 * @return
	 */
	int delProvider(Integer id);
	/**
	 * 根据供应商id查看供应商
	 * @param id
	 * @return
	 */
	Provider getProviderById(Long id);
	/**
	 * 修改供应商
	 * @param provider
	 * @return
	 */
	int updateProvider(Provider provider);
}
