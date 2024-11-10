package cn.itbaizhan.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itbaizhan.dao.TCatelogDAO;
import cn.itbaizhan.dao.TGoodsDAO;
import cn.itbaizhan.dao.TOrderDAO;
import cn.itbaizhan.dao.TOrderItemDAO;
import cn.itbaizhan.dao.TPingDAO;
import cn.itbaizhan.model.TGoods;
import cn.itbaizhan.model.TOrder;
import cn.itbaizhan.model.TOrderItem;
import cn.itbaizhan.model.TPing;
import cn.itbaizhan.model.TUser;
import cn.itbaizhan.util.Cart;

public class buyAction extends ActionSupport
{
	private int goodsId;
	private int quantity;
	
	private int orderId;
	
	private TGoodsDAO goodsDAO;
	private TOrderDAO orderDAO;
	private TOrderItemDAO orderItemDAO;
	
	private String message;
	private String path;
	
	private String odderSonghuodizhi;
	private String odderFukuangfangshi;
	
	private TPingDAO pingDAO;
	
	public String addToCart()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		TOrderItem orderItem=new TOrderItem();
		orderItem.setGoods(goods);
		orderItem.setGoodsQuantity(quantity);
		
		Map session= ServletActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		cart.addGoods(goodsId, orderItem);
		session.put("cart",cart);
		//this.setMessage("");
		this.setPath("myCart.action");
		return "succeed";
	}
	
	
	
	public String myCart()
	{
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderQueren()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderSubmit()
	{
		Map session= ServletActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		TUser user=(TUser)session.get("user");
		TOrder order=new TOrder();
		order.setOrderBianhao(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setOrderZhuangtai("no");//Î´ï¿½ï¿½ï¿½ï¿½
		order.setOrderUserId(user.getUserId());
		order.setOrderJine(cart.getTotalPrice());
		System.out.println(odderFukuangfangshi+"%%%%%%%%%");
		order.setOdderFukuangfangshi(odderFukuangfangshi);
		order.setOdderSonghuodizhi(odderSonghuodizhi);
		
		orderDAO.save(order);
		
		for (Iterator it = cart.getItems().values().iterator(); it.hasNext();)
		{

			TOrderItem orderItem = (TOrderItem) it.next();
			orderItem.setOrderId(order.getOrderId());
			orderItem.setGoodsId(orderItem.getGoods().getGoodsId());
			orderItemDAO.save(orderItem);
			
			TGoods tg=goodsDAO.findById(orderItem.getGoods().getGoodsId());
			tg.setGoodsKucun(tg.getGoodsKucun()-orderItem.getGoodsQuantity());
			goodsDAO.attachDirty(tg);
			
			
		}
		
		cart.getItems().clear();
		session.put("cart", cart);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("order", order);
		
		return ActionSupport.SUCCESS;
		
	}
	
	
	
	public String myOrder()
	{
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		String sql="from TOrder where orderUserId="+user.getUserId();
		List orderList=orderDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderMana()
	{
		String sql="from TOrder order by orderUserId";
		List orderList=orderDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderDel()//ï¿½Ã»ï¿½ï¿½Ô¼ï¿½É¾ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	{
		TOrder order=orderDAO.findById(orderId);
		orderDAO.delete(order);
		
		
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		this.setMessage("É¾³ý¶©µ¥³É¹¦");
		this.setPath("myOrder.action?userId="+user.getUserId());
		return "succeed";
	}
	
	public String orderShouhuo()//ï¿½Ã»ï¿½ï¿½Ô¼ï¿½É¾ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	{
		TOrder order=orderDAO.findById(orderId);
		order.setOrderZhuangtai("shou");
		orderDAO.attachDirty(order);
		
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		this.setMessage("ÒÑÊÕ»õ");
		this.setPath("myOrder.action?userId="+user.getUserId());
		return "succeed";
	}
	
	public String orderDelByAd()//ï¿½ï¿½ï¿½ï¿½Ô±É¾ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	{
		TOrder order=orderDAO.findById(orderId);
		orderDAO.delete(order);
		String sql="delete from TOrderItem where orderId="+orderId;
		orderItemDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("É¾³ý²Ù×÷³É¹¦");
		this.setPath("orderMana.action");
		return "succeed";
	}
	
	
	public String orderShouli()
	{
		TOrder order=orderDAO.findById(orderId);
		order.setOrderZhuangtai("yes");//ï¿½Ñ¾ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
		orderDAO.attachDirty(order);
		this.setMessage("ÒÑÊÜÀí");
		this.setPath("orderMana.action");
		return "succeed";
	}
	
	
	
	public String orderDetail()
	{
		String sql="from TOrderItem where orderId="+orderId;
		List orderItemList=orderItemDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<orderItemList.size();i++)
		{
			TOrderItem orderItem=(TOrderItem)orderItemList.get(i);
			orderItem.setGoods(goodsDAO.findById(orderItem.getGoodsId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderItemList", orderItemList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderDetailPing()
	{
		String sql="from TOrderItem where orderId="+orderId;
		List orderItemList=orderItemDAO.getHibernateTemplate().find(sql);
		String itemid = "";
		for(int i=0;i<orderItemList.size();i++)
		{
			TOrderItem orderItem=(TOrderItem)orderItemList.get(i);
			orderItem.setGoods(goodsDAO.findById(orderItem.getGoodsId()));
			itemid = itemid + ":" + orderItem.getOrderItemId();
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderItemList", orderItemList);
		request.put("order_id", orderId);
		request.put("itemid", itemid);
		return ActionSupport.SUCCESS;
	}
	
	public String orderPing(){
		HttpServletRequest req = ServletActionContext.getRequest();	
		Map session= ServletActionContext.getContext().getSession();
		
		String order_id = req.getParameter("order_id");
		String itemids = req.getParameter("itemid");

		TUser user=(TUser)session.get("user");
		System.out.println("order_id  " + order_id);
		System.out.println("user  " + user.getUserName()+ " " + user.getUserId());

		String[] getId = itemids.substring(1).split(":");
		for (String itemid : getId) {
			String pings = req.getParameter("txt" + itemid);
			if (pings.trim().length() > 0) {
				String date=new Date().toLocaleString();
				String goodsname = req.getParameter("goodsname" + itemid);
				String goodsids = req.getParameter("goods" + itemid);
				
				System.out.println(goodsids+"--"+goodsname+"--"+itemid+"----"+pings);
				
				TPing ping=new TPing();
				ping.setAdddate(date);
				ping.setGoodsId(goodsids);
				ping.setInfo(pings);
				ping.setLoginname(user.getUserName());
				ping.setMingcheng(goodsname);
				ping.setOrderId(order_id);
				ping.setOrderitemId(itemid);
				ping.setUserId(user.getUserId()+"");
				
				pingDAO.save(ping);
			}
			
		}
		
		
		
		TOrder order=orderDAO.findById(Integer.parseInt(order_id));
		order.setOrderZhuangtai("ping");//ï¿½Ñ¾ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
		orderDAO.attachDirty(order);
		
		
		this.setMessage("Success");
		//this.setPath("myOrder.action?userId="+user.getUserId());
		return "success";
		
	}
	
	public String testCart()
	{
		Map session= ServletActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		Map items=cart.getItems();
		
		for (Iterator it = items.values().iterator(); it.hasNext();)
		{
         
			TOrderItem orderItem = (TOrderItem) it.next();
			TGoods goods = orderItem.getGoods();
			System.out.println(goods.getGoodsName()+"ï¿½ï¿½ï¿½ï¿½Æ·ï¿½ï¿½ï¿½ï¿½");
			int quantity = orderItem.getGoodsQuantity();
			System.out.println(quantity+"ï¿½ï¿½ï¿½ï¿½Æ·ï¿½ï¿½ï¿½ï¿½");
			System.out.println("--------------------------------------------------");
			
			
		}
		return null;
	}
	
	
	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}
	
	public String getOdderFukuangfangshi()
	{
		return odderFukuangfangshi;
	}



	public void setOdderFukuangfangshi(String odderFukuangfangshi)
	{
		this.odderFukuangfangshi = odderFukuangfangshi;
	}



	public String getOdderSonghuodizhi()
	{
		return odderSonghuodizhi;
	}



	public void setOdderSonghuodizhi(String odderSonghuodizhi)
	{
		this.odderSonghuodizhi = odderSonghuodizhi;
	}



	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}
	public int getGoodsId()
	{
		return goodsId;
	}
	
	public int getOrderId()
	{
		return orderId;
	}



	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
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


	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
	public TOrderDAO getOrderDAO()
	{
		return orderDAO;
	}
	public void setOrderDAO(TOrderDAO orderDAO)
	{
		this.orderDAO = orderDAO;
	}
	public TOrderItemDAO getOrderItemDAO()
	{
		return orderItemDAO;
	}
	public void setOrderItemDAO(TOrderItemDAO orderItemDAO)
	{
		this.orderItemDAO = orderItemDAO;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}



	public TPingDAO getPingDAO() {
		return pingDAO;
	}



	public void setPingDAO(TPingDAO pingDAO) {
		this.pingDAO = pingDAO;
	}
	
	
	

}
