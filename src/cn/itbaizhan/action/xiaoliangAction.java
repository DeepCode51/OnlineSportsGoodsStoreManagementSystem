package cn.itbaizhan.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itbaizhan.dao.TCatelogDAO;
import cn.itbaizhan.dao.TGoodsDAO;
import cn.itbaizhan.dao.TOrderItemDAO;
import cn.itbaizhan.model.TGoods;

public class xiaoliangAction extends ActionSupport {
	private TGoodsDAO goodsDAO;

	private TOrderItemDAO orderItemDAO;

	public String index() {
		Map request = (Map) ServletActionContext.getContext().get("request");

		// paihangbang
		List goodsList = new ArrayList();
		String sql = "select sum(goodsQuantity),goodsId from TOrderItem group by goodsId order by sum(goodsQuantity) desc";
		List list = orderItemDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < list.size(); i++) {
			Object[] b = (Object[]) list.get(i);
			int goodsId = Integer.parseInt(b[1].toString());
			System.out.println(goodsId + "&&");
			TGoods goods = goodsDAO.findById(goodsId);
			goods.setGoodsCount(b[0].toString());
			goodsList.add(goods);
		}
//		if (goodsList.size() > 5) {
//			goodsList = goodsList.subList(0, 5);
//		}
		request.put("goodsList", goodsList);
		// paihangbang
 

		return ActionSupport.SUCCESS;
	}

	public TGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(TGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public TOrderItemDAO getOrderItemDAO() {
		return orderItemDAO;
	}

	public void setOrderItemDAO(TOrderItemDAO orderItemDAO) {
		this.orderItemDAO = orderItemDAO;
	}

}
