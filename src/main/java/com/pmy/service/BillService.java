package com.pmy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pmy.entity.Bill;
import com.pmy.entity.Provider;
import com.pmy.entity.User;

public interface BillService {
	/**
	 * 按条件分页查询订单
	 * @param productName
	 * @param proName
	 * @param isPayment
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Bill> getBillList(String productName,Integer providerId,Integer isPayment,int pageIndex,int pageSize);
	/**
	 * 查看所有供应商
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
	int getProviderRows(String productName,Integer providerId,Integer isPayment);
	
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
    Bill getBillById(Integer id);
    /**
     * 修改订单信息
     * @param id
     * @return
     */
    int updateBillById(Bill bill);
    
}
