package cn.itbaizhan.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itbaizhan.dao.TGonggaoDAO;
import cn.itbaizhan.model.TAdmin;
import cn.itbaizhan.model.TGonggao;

public class gonggaoAction extends ActionSupport
{
	private int gonggaoId;
	private String gonggaoTitle;
	private String gonggaoContent;
	private String gonggaoData;
	private String gonggaoFabuzhe;
	
	private String message;
	private String path;
	
	private TGonggaoDAO gonggaoDAO;
	
	public String gonggaoAdd()
	{
		TGonggao gonggao=new TGonggao();
		gonggao.setGonggaoTitle(gonggaoTitle);
		gonggao.setGonggaoContent(gonggaoContent);
		gonggao.setGonggaoData(new Date().toLocaleString());
		gonggaoDAO.save(gonggao);
		this.setMessage("Success");
		this.setPath("gonggaoMana.action");
		return "succeed";
	}
	
	
	public String gonggaoMana()
	{
		List gonggaoList =gonggaoDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("gonggaoList", gonggaoList);
		return ActionSupport.SUCCESS;
	}
	
	public String gonggaoDel()
	{
		TGonggao gonggao=gonggaoDAO.findById(gonggaoId);
		gonggaoDAO.delete(gonggao);
		this.setMessage("É¾³ý³É¹¦");
		this.setPath("gonggaoMana.action");
		return "succeed";
	}
	
	
	public String gonggaoDetail()
	{
		TGonggao gonggao=gonggaoDAO.findById(gonggaoId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("gonggao", gonggao);
		return ActionSupport.SUCCESS;
	}
	
	public String gonggaoDetailQian()
	{
		TGonggao gonggao=gonggaoDAO.findById(gonggaoId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("gonggao", gonggao);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String gonggaoQian5()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		List gonggaoList=gonggaoDAO.findAll();
		if(gonggaoList.size()>5)
		{
			gonggaoList=gonggaoList.subList(0, 5);
		}
		request.put("gonggaoList", gonggaoList);
		return ActionSupport.SUCCESS;
	}

	public String getGonggaoContent()
	{
		return gonggaoContent;
	}

	public void setGonggaoContent(String gonggaoContent)
	{
		this.gonggaoContent = gonggaoContent;
	}

	public TGonggaoDAO getGonggaoDAO()
	{
		return gonggaoDAO;
	}

	public void setGonggaoDAO(TGonggaoDAO gonggaoDAO)
	{
		this.gonggaoDAO = gonggaoDAO;
	}

	public String getGonggaoData()
	{
		return gonggaoData;
	}

	public void setGonggaoData(String gonggaoData)
	{
		this.gonggaoData = gonggaoData;
	}

	public String getGonggaoFabuzhe()
	{
		return gonggaoFabuzhe;
	}

	public void setGonggaoFabuzhe(String gonggaoFabuzhe)
	{
		this.gonggaoFabuzhe = gonggaoFabuzhe;
	}

	public int getGonggaoId()
	{
		return gonggaoId;
	}

	public void setGonggaoId(int gonggaoId)
	{
		this.gonggaoId = gonggaoId;
	}

	public String getGonggaoTitle()
	{
		return gonggaoTitle;
	}

	public void setGonggaoTitle(String gonggaoTitle)
	{
		this.gonggaoTitle = gonggaoTitle;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
	
}
