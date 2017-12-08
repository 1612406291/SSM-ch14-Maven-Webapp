package com.pmy.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.PathParam;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pmy.entity.Provider;
import com.pmy.service.ProviderService;

@Controller
@RequestMapping("provider")
public class ProviderController {
	
	@Autowired
	private ProviderService ps;
	/**
	 * 按条件分页查询供应商列表
	 * @return
	 */
	private int pageSize =5;
	private HttpServletRequest request;
	@RequestMapping("provider.do")
	public String getProviderList(String queryProCode,
																String queryProName,
																@RequestParam(defaultValue="1") Integer pageIndex,
																Map<String , Object> model){
		model.put("queryProCode", queryProCode);
		model.put("queryProName", queryProName);
		//计算总行数
		int totalCount = ps.getProviderRows(queryProCode, queryProName);
		//计算总页数
		int totalPageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		List<Provider> providerList = ps.getProviderList(queryProCode, queryProName, pageIndex, totalPageCount);
		model.put("providerList", ps.getProviderList(queryProCode, queryProName, pageIndex, totalPageCount));
		model.put("currentPageNo", pageIndex);//当前的页码数
		model.put("totalPageCount", totalPageCount);//总页数
		model.put("totalCount", totalCount);//总行数
		return "providerlist";
	}
	
	/**
	 * 增加供应商,接收上传的图片
	 * @param provider
	 * @return
	 */
	@RequestMapping("provideradd.do")
	public String addProvider(@ModelAttribute("provider")@Valid Provider provider,BindingResult result,@RequestParam("photos") MultipartFile[] photos,HttpServletRequest req){
		/*int add = ps.addProvider(provider);
		if (add >0) {
			return "redirect:provider.do";
		}
		return "provideradd";*/
		if (!result.hasErrors()) {
			String path = req.getSession().getServletContext().getRealPath("photos");
			List<String > errors = new ArrayList<String>();
			List<String > filenames = new ArrayList<String>();
			//检测
			for (MultipartFile photo : photos) {
				String err = getErrInfo(photo);
				//上传
				if (err == null) {
					String fileName = upload(photo,path);
					filenames.add(fileName);
				}else {
					errors.add(err);
				}
			}
			if(filenames.size() > 0){
				provider.setCompanyLicPicPath("photos"+File.separator+filenames.get(0));
				//provider.setCompanyLicPicPath("photos"+File.separator+filenames.get(1));
				if(ps.addProvider(provider) > 0){
					return "redirect:provider.do";
				}
			}
			req.setAttribute("errors", errors);
			req.setAttribute("filenames", filenames);
		}
		return "provideradd";
	}
		
	private String upload(MultipartFile photo, String path) {
		String fileName = photo.getOriginalFilename();
		long time = System.currentTimeMillis();
		int randNumber = RandomUtils.nextInt(1000000);
		File dest = new File(path,time+"_"+randNumber+"_"+fileName);
		try {
			photo.transferTo(dest);
			return fileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param photo
	 * @return
	 */
	private String getErrInfo(MultipartFile photo) {
		String fileName = photo.getOriginalFilename();
		String suf = FilenameUtils.getExtension(fileName);
		String err = null;
		if(photo.isEmpty()){
			err = String.format("%s：上传文件不能为空",fileName);
		}else if(photo.getSize()>500000){
			err = String.format("%s：上传文件大小不能超过500KB",fileName);
		}else if(!formats.contains(suf.toLowerCase())){
			err = String.format("%s：上传文件格式不正确，支持的格式：%s",fileName,formats);
		}
		return err;
	}
	static List<String> formats = new ArrayList<String>();
	static{
		formats.add("png");
		formats.add("jpg");
		formats.add("jpeg");
		formats.add("pneg");
	}

	/**
	 * 删除供应商
	 * @param provider
	 * @return
	 */
	@RequestMapping("delProvider.do")
	public String delprovider(Integer proid){
		int del = ps.delProvider(proid);
		if (del > 0) {
			return "redirect:provider.do";
		}
		return "providerlist";
	}
	
	/**
	 * 根据供应商id查看供应商
	 * @return
	 */
	@RequestMapping("providerView.do")
	public String getProviderById(@PathVariable("id")Long id,Map<String , Object> model){
		model.put("provier", ps.getProviderById(id));
		return "providerview";
	}
	
	/**
	 * 跳转到修改供应商页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("ModifyProvider.do")
	public String goModifyProvider(@PathParam("proid")Long proid,Map<String , Object> map){
		map.put("provider", ps.getProviderById(proid));
		return "providermodify";
	}
	/**
	 * 修改供应商
	 */
	@RequestMapping("updateProvider.do")
	public String  updateProvider(Provider provider) {
		if (ps.updateProvider(provider) > 0) {
			return "redirect:provider.do";
		}
		return "providermodify";
	}
}
