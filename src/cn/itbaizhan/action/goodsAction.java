package cn.itbaizhan.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itbaizhan.dao.TCatelogDAO;
import cn.itbaizhan.dao.TGoodsDAO;
import cn.itbaizhan.dao.TPingDAO;
import cn.itbaizhan.model.TCatelog;
import cn.itbaizhan.model.TGoods;
import cn.itbaizhan.model.TPing;

public class goodsAction extends ActionSupport {
	private int goodsId;
	private int goodsCatelogId;
	private String goodsName;
	private String goodsMiaoshu;
	private String fujian;
	private String goodsYanse;
	private int goodsShichangjia;
	private int goodsTejia;
	private int goodsKucun;

	private int catelogId;

	private String message;
	private String path;

	private TGoodsDAO goodsDAO;
	private TCatelogDAO catelogDAO;
	
	private TPingDAO pingDAO;
	
	

	public String goodsNoTejiaAdd() {
		TGoods goods = new TGoods();
		goods.setGoodsCatelogId(goodsCatelogId);
		goods.setGoodsName(goodsName);
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setGoodsPic(fujian);
		goods.setGoodsYanse(goodsYanse);
		goods.setGoodsShichangjia(goodsShichangjia);
		goods.setGoodsKucun(goodsKucun);

		goods.setGoodsIsnottejia("no");
		goods.setGoodsDel("no");
		goodsDAO.save(goods);
		this.setMessage("添加成功");
		this.setPath("goodsManaNoTejia.action");
		return "succeed";

	}
	
	public String goodsEdit()
	{
		TGoods goods = goodsDAO.findById(goodsId);
		goods.setGoodsCatelogId(goodsCatelogId);
		goods.setGoodsName(goodsName);
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setGoodsPic(fujian);
		goods.setGoodsYanse(goodsYanse);
		goods.setGoodsShichangjia(goodsShichangjia);
		goods.setGoodsKucun(goodsKucun);
		goodsDAO.attachDirty(goods);
		this.setMessage("修改成功");
		this.setPath("goodsManaNoTejia.action");
		return "succeed";
	}

	public String goodsEditPre() {
		TGoods catelog = goodsDAO.findById(goodsId);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("goods", catelog);
		return ActionSupport.SUCCESS;
	}

	public String goodsNoTejiaDel() {
		TGoods goods = goodsDAO.findById(goodsId);
		goods.setGoodsDel("yes");
		goodsDAO.attachDirty(goods);
		this.setMessage("删除商品成功");
		this.setPath("goodsManaNoTejia.action");
		return "succeed";
	}

	public String goodsManaNoTejia() {
		String sql = "from TGoods where goodsDel='no' and goodsIsnottejia='no' order by goodsCatelogId";
		List goodsList = goodsDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < goodsList.size(); i++) {
			TGoods goods = (TGoods) goodsList.get(i);
			System.out.println(goods.getGoodsCatelogId());
			goods.setGoodsCatelogName(catelogDAO.findById(
					goods.getGoodsCatelogId()).getCatelogName());
		}
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}

	public String goodsYesTejiaAdd() {
		TGoods goods = new TGoods();
		goods.setGoodsCatelogId(goodsCatelogId);
		goods.setGoodsName(goodsName);
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setGoodsPic(fujian);
		goods.setGoodsYanse(goodsYanse);
		goods.setGoodsShichangjia(goodsShichangjia);

		goods.setGoodsIsnottejia("yes");
		goods.setGoodsDel("no");
		goodsDAO.save(goods);
		this.setMessage("Success");
		this.setPath("goodsManaYesTejia.action");
		return "succeed";

	}

	public String goodsYesTejiaDel() {
		TGoods goods = goodsDAO.findById(goodsId);
		goods.setGoodsDel("yes");
		goodsDAO.attachDirty(goods);
		this.setMessage("Success");
		this.setPath("goodsManaYesTejia.action");
		return "succeed";
	}

	public String goodsManaYesTejia() {
		String sql = "from TGoods where goodsDel='no' and goodsIsnottejia='yes' order by goodsCatelogId";
		List goodsList = goodsDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < goodsList.size(); i++) {
			TGoods goods = (TGoods) goodsList.get(i);
			goods.setGoodsCatelogName(catelogDAO.findById(
					goods.getGoodsCatelogId()).getCatelogName());
		}
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}

	public String goodsDetail() {
		Map request = (Map) ServletActionContext.getContext().get("request");

		TGoods goods = goodsDAO.findById(goodsId);
		goods.setGoodsDianji(goods.getGoodsDianji() + 1);
		goodsDAO.update(goods);
		request.put("goods", goods);
		
		List <TPing> plist=pingDAO.findByGoodsId(goodsId+"");
		
		if(plist!=null){
			System.out.println(plist.size());
			 
			request.put("pingItemList", plist);
		}
		
		return ActionSupport.SUCCESS;
	}

	public String goodsDetailHou() {
		Map request = (Map) ServletActionContext.getContext().get("request");

		TGoods goods = goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}

	public String goodsAllYesTejia() {
		Map request = (Map) ServletActionContext.getContext().get("request");

		String sql = "from TGoods where goodsDel='no' and goodsIsnottejia='yes' order by goodsCatelogId";
		List goodsYesTejiaList = goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsYesTejiaList", goodsYesTejiaList);
		return ActionSupport.SUCCESS;
	}

	public String goodsAllNoTejia() {
		Map request = (Map) ServletActionContext.getContext().get("request");

		String sql = "from TGoods where goodsDel='no' and goodsIsnottejia='no' order by goodsCatelogId";
		List goodsYesTejiaList = goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsYesTejiaList", goodsYesTejiaList);
		return ActionSupport.SUCCESS;
	}

	public String goodsByCatelog() {
		Map request = (Map) ServletActionContext.getContext().get("request");

		String sql = "from TGoods where goodsDel='no' and goodsCatelogId=? order by goodsCatelogId";
		Object[] con = { catelogId };
		List goodsByCatelogList = goodsDAO.getHibernateTemplate()
				.find(sql, con);
		request.put("goodsByCatelogList", goodsByCatelogList);

		System.out.println(goodsByCatelogList.size() + "^^^" + goodsCatelogId);
		return ActionSupport.SUCCESS;
	}

	public String goodSearch() {
		Map request = (Map) ServletActionContext.getContext().get("request");
		String sql = "";
		if (catelogId == 0) {
			sql = "from TGoods where goodsDel='no' and goodsName like '%"
					+ goodsName + "%'" + " order by goodsCatelogId";
		} else {
			sql = "from TGoods where goodsDel='no' and goodsCatelogId="
					+ catelogId + " and goodsName like '%" + goodsName + "%'"
					+ " order by goodsCatelogId";
		}

		List goodsList = goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsList", goodsList);

		return ActionSupport.SUCCESS;
	}

	public int getCatelogId() {
		return catelogId;
	}

	public void setCatelogId(int catelogId) {
		this.catelogId = catelogId;
	}

	public int getGoodsCatelogId() {
		return goodsCatelogId;
	}

	public void setGoodsCatelogId(int goodsCatelogId) {
		this.goodsCatelogId = goodsCatelogId;
	}

	public TGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(TGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsMiaoshu() {
		return goodsMiaoshu;
	}

	public void setGoodsMiaoshu(String goodsMiaoshu) {
		this.goodsMiaoshu = goodsMiaoshu;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getFujian() {
		return fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public TCatelogDAO getCatelogDAO() {
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO) {
		this.catelogDAO = catelogDAO;
	}

	public int getGoodsShichangjia() {
		return goodsShichangjia;
	}

	public void setGoodsShichangjia(int goodsShichangjia) {
		this.goodsShichangjia = goodsShichangjia;
	}

	public int getGoodsTejia() {
		return goodsTejia;
	}

	public void setGoodsTejia(int goodsTejia) {
		this.goodsTejia = goodsTejia;
	}

	public String getGoodsYanse() {
		return goodsYanse;
	}

	public void setGoodsYanse(String goodsYanse) {
		this.goodsYanse = goodsYanse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getGoodsKucun() {
		return goodsKucun;
	}

	public void setGoodsKucun(int goodsKucun) {
		this.goodsKucun = goodsKucun;
	}

	public TPingDAO getPingDAO() {
		return pingDAO;
	}

	public void setPingDAO(TPingDAO pingDAO) {
		this.pingDAO = pingDAO;
	}

    
	
	
}
