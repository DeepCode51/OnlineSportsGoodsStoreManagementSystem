package cn.itbaizhan.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itbaizhan.dao.TAdminDAO;
import cn.itbaizhan.model.TAdmin;
import cn.itbaizhan.util.Pagination;

public class adminAction extends ActionSupport
{
	private int userId;
	private String userName;
	private String userPw;
	private String userType;
	 
	private String message;
	private String path;
	
	private int index=1;

	private TAdminDAO adminDAO;
	
	
	public String adminAdd()
	{
		TAdmin admin=new TAdmin();
		admin.setUserName(userName);
		admin.setUserPw(userPw);
		admin.setUserType(userType);
		adminDAO.save(admin);
		this.setMessage("添加成功");
		this.setPath("adminManage.action"); 
		return "succeed";
	}
	
	public String adminEdit()
	{
		TAdmin admin=new TAdmin();
		admin.setUserName(userName);
		admin.setUserPw(userPw);
		admin.setUserType(userType);
		admin.setUserId(userId);
		adminDAO.update(admin);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("messageInfo", "修改成功");
//		this.setMessage("???????");
		//this.setPath("adminManage.action");
		return adminManage();
	}
	
	public String toadminEdit()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("admin", adminDAO.findById(userId));
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String adminManage()
	{
		List adminList=adminDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("adminList", adminList);
		 
			
		return ActionSupport.SUCCESS;
	}
	
	public String adminManageFenye()
	{
		List adminList=adminDAO.findAll();
		int pageSize=3;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, adminList.size());
		List adminListFenye = adminList.subList(fromIndex, toIndex);
		

        Pagination p = new Pagination();//???? ???????
        p.setIndex(index);//???????
        p.setPageSize(pageSize);
        p.setTotle(adminList.size());//?????????????
        p.setData(adminListFenye);//????????
        p.setPath("adminManageFenye.action?");//?????·??

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}
	
	public String adminDel()
	{
		adminDAO.delete(adminDAO.findById(userId));
		this.setMessage("删除成功");
		this.setPath("adminManage.action");
		return "succeed";
	}
	
	

	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}

	public String getMessage()
	{
		return message;
	}

	public int getIndex()
	{
		return index;
	}



	public void setIndex(int index)
	{
		this.index = index;
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

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	 
}
