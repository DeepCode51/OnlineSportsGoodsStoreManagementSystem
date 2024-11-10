package cn.itbaizhan.service;

import java.util.List;

import cn.itbaizhan.dao.TCatelogDAO;

public class catelogService
{
    private TCatelogDAO catelogDAO;
    
    
    public List findAllCatelog()
    {
    	try
		{
			Thread.sleep(1500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String sql="from TCatelog where catelogDel='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		return cateLogList;
    }

	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}
    
}
