package com.pmy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmy.dao.BillMapping;
import com.pmy.entity.Bill;
import com.pmy.entity.Provider;
import com.pmy.service.BillService;

@Service("billService")
public class BillServiceImpl implements BillService{
	@Autowired
	private BillMapping billMapping;

	/**
	 * 按条件分页查询订单
	 */
	public List<Bill> getBillList(String productName, Integer providerId,
			Integer isPayment, int pageIndex, int pageSize) {
		return billMapping.getBillList(productName, providerId, isPayment, (pageIndex-1)*pageSize, pageSize);
	}
	
	/**
	 * 查看所有供应商
	 */
	public List<Provider> getAllProvider() {
		return billMapping.getAllProvider();
	}
	/**
	 * 根据商品名称，供应商，是否付款查询返回的个数
	 */
	public int getProviderRows(String productName, Integer providerId,
			Integer isPayment) {
		return billMapping.getProviderRows(productName, providerId, isPayment);
	}
	/**
	 * 根据ID删除订单
	 */
	public int delBill(Integer id) {
		return billMapping.delBill(id);
	}

	/**
	 * 新增订单
	 */
	public int addBill(Bill bill) {
		return billMapping.addBill(bill);
	}
	
	/**
	 * 根据ID查询订单详情
	 */
	public Bill getBillById(Integer id) {
		return billMapping.getBillById(id);
	}

	/**
	 * 修改订单信息
	 */
	public int updateBillById(Bill bill) {
		return billMapping.updateBillById(bill);
	}


	public BillMapping getBillMapping() {
		return billMapping;
	}

	public void setBillMapping(BillMapping billMapping) {
		this.billMapping = billMapping;
	}






}
