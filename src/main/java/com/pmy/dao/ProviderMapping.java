package com.pmy.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pmy.entity.Provider;

public interface ProviderMapping {
	/**
	 * 根据条件查询供应商列表-ProviderList
	 * @param proCode
	 * @param queryProName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<Provider> getProviderList(@Param("proCode")String proCode,
													@Param("proName")String queryProName,
													@Param("pageIndex")int pageIndex,
													@Param("pageSize")int pageSize);
	
	/**
	 * 根据供应商编码或供应商名称查询返回的记录数
	 * @param proCode
	 * @param proName
	 * @return
	 */
	int getProviderRows(@Param("proCode")String proCode,
										@Param("proName")String proName);
	
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