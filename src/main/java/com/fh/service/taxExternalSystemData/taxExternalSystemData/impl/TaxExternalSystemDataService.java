package com.fh.service.taxExternalSystemData.taxExternalSystemData.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.JqPage;
import com.fh.util.PageData;
import com.fh.service.taxExternalSystemData.taxExternalSystemData.TaxExternalSystemDataManager;

/**
 * 税务系统数据导入
* @ClassName: TaxExternalSystemDataService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author jiachao
* @date 2019年8月7日
*
 */
@Service("taxExternalSystemDataService")
public class TaxExternalSystemDataService implements TaxExternalSystemDataManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> JqPage(JqPage page)throws Exception{
		return (List<PageData>)dao.findForList("TaxExternalSystemDataMapper.datalistJqPage", page);
	}
	/**获取记录数量
	 * @param pd
	 * @throws Exception
	 */
	public int countJqGridExtend(JqPage page)throws Exception{
		return (int)dao.findForObject("TaxExternalSystemDataMapper.countJqGridExtend", page);
	}

	/**用于判断数据是否重复
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> getRepeatList(List<PageData> list)throws Exception{
		return (List<PageData>)dao.findForList("TaxExternalSystemDataMapper.getRepeatList", list);
	}
	
	/**更新数据库
	 * @param pd
	 * @throws Exception
	 */
	public void batchUpdateDatabase(List<PageData> listData)throws Exception{
		dao.update("TaxExternalSystemDataMapper.batchDelAndIns", listData);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(List<PageData> listData)throws Exception{
		dao.delete("TaxExternalSystemDataMapper.deleteAll", listData);
	}
	
	/**导出列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> exportList(JqPage page)throws Exception{
		return (List<PageData>)dao.findForList("TaxExternalSystemDataMapper.exportList", page);
	}
	/**导出模板
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> exportModel(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("TaxExternalSystemDataMapper.exportModel", pd);
	}

	
	/**获取汇总要用数据
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> getSumUseList(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("TaxExternalSystemDataMapper.getSumUseList", pd);
	}
}

