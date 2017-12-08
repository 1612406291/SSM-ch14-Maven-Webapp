package com.pmy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pmy.entity.Bill;
import com.pmy.entity.Provider;
import com.pmy.entity.User;


public interface BillMapping {
	/**
	 * 通过条件查询
	 * @param productName
	 * @param proName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<Bill> getBillList(@Param("productName")String productName,
													@Param("providerId")Integer providerId,
													@Param("isPayment")Integer isPayment,
													@Param("pageIndex")int pageIndex,
													@Param("pageSize")int pageSize);
	
	/**
	 * 查看所有的供应商名称
	 * @return
	 */
	List<Provider> getAllProvider();
	/**
	 * 根据商品名称，供应商，是否付款查询返回的个数
	 * @param productName
	 * @param providerId
	 * @param isPayment
	 * @return
	 */
	int getProviderRows(@Param("productName") String productName,
												@Param("providerId")Integer providerId,
												@Param("isPayment")Integer isPayment);
	/**
	 * 根据ID删除订单
	 * @param id
	 * @return
	 */
	int delBill(Integer id);
	
	/**
	 * 增加订单
	 * @param bill
	 * @return
	 */
    int addBill(Bill bill);
    /**
     * 根据ID查看订单
     * @param id
     * @return
     */
    Bill getBillById(@Param("bid")Integer bid);
    
    /**
     * 修改订单信息
     * @param id
     * @return
     */
    int updateBillById(Bill bill);
}