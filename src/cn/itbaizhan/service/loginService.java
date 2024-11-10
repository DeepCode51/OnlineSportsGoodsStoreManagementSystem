package cn.itbaizhan.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import cn.itbaizhan.dao.TAdminDAO;
import cn.itbaizhan.dao.TUserDAO;
import cn.itbaizhan.model.TAdmin;
import cn.itbaizhan.model.TUser;

public class loginService
{
	private TAdminDAO adminDAO;
	private TUserDAO userDAO;
	 public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	
	
	public String login(String userName,String userPw,String randomCode,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//ϵͳ����Ա��½
		{
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session=ctx.getSession(); 
			String code=(String) session.getAttribute(RANDOMCODEKEY);
		 
			if(!randomCode.trim().equalsIgnoreCase(code)){
				return "codeerror";
			}
			
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName,userPw};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0)
			{
				 result="no";
			}
			else
			{
				 
				 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
		}
	 
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
	
    public String jiance(String userName)
    {
    	System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="from TUser where userName='"+userName+"'";
		List list=userDAO.getHibernateTemplate().find(sql);
		if(list.size()>0)
		{
			return "no";
		}
		else
		{
			return "yes";
		}
    }
    
    
}
