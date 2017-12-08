package com.pmy.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.pmy.entity.Bill;
import com.pmy.service.BillService;

@Controller
@RequestMapping("bill")
public class BillController {
	@Autowired
	private BillService bs;
	/**
	 * 按条件查询
	 * @return
	 */
	private int pageSize =5;
	@RequestMapping("bill.do")
	public String getUserList(String queryProductName,
														Integer queryProviderId,
														Integer queryIsPayment,
														@RequestParam(defaultValue="1") Integer pageIndex,Map<String, Object> model){
		//获取所有供应商
		model.put("providerList",bs.getAllProvider());
		//商品名称
		model.put("queryProductName", queryProductName);
		//是否付款信息
		model.put("queryIsPayment", queryIsPayment);
		//计算总行数
		int totalCount=bs.getProviderRows(queryProductName, queryProviderId, queryIsPayment);
		//计算总页数
		int totalPageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		model.put("billList", bs.getBillList(queryProductName, queryProviderId, queryIsPayment, pageIndex, pageSize));
		model.put("currentPageNo", pageIndex);//当前的页码
		model.put("totalPageCount", totalPageCount);//总页数
		model.put("totalCount", totalCount);//总行数
		return "billlist";
	}
	
	/**
	 * 根据ID删除订单
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delbill.do")
	public String delBill(@RequestParam Integer billid) {
		Map<String , String > resultMap = new HashMap<String, String>();
		int del = bs.delBill(billid);
		if (del > 0) {
			resultMap.put("delResult", "true");
		}else {
			resultMap.put("delResult", "false");
		}
		return JSONArray.toJSONString(resultMap);
	}
	
	/**
	 * 获取所有供应商
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getProvider.do")
	public String getAllProvider(){
		return JSONArray.toJSONString(bs.getAllProvider());
		
	}
	@RequestMapping("addBill.do")
	public String addBill(@ModelAttribute("bill") Bill bill){
		return "billadd";
	}
	/**
	 * 新增订单
	 */
	@RequestMapping("addSave.do")
	public String addSave(Bill bill){
		int add = bs.addBill(bill);
		if (add > 0) {
			return "redirect:bill.do";
		}
		return "billadd";
	}
	
	/**
	 * 根据ID查询订单详情
	 */
	@RequestMapping("viewBill.do")
	public String getBillById(@RequestParam("billid") Integer billid,Map<String , Object> map) {
		map.put("bill", bs.getBillById(billid));
		return "billview";
	}
	/**
	 * 跳转到修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("modifyBill.do")
	public String modifyBill(@RequestParam("billid")Integer billid,Map<String , Object>model){
		model.put("bill", bs.getBillById(billid));
	
		return "billmodify";
	}
	/**
     * 修改订单信息
     * @param id
     * @return
     */
	@RequestMapping("updateBill.do")
   public  String  updateBillById(Bill bill) {
		if (bs.updateBillById(bill) > 0) {
			return "redirect:bill.do";
		}
		return "jsp/billmodify";
	}
}
