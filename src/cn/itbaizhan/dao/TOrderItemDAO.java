package cn.itbaizhan.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itbaizhan.dao.TOrderItemDAO;

import cn.itbaizhan.model.TOrderItem;

/**
 * Data access object (DAO) for domain model class TOrderItem.
 * 
 * @see cn.itbaizhan.model.TOrderItem
 * @author MyEclipse Persistence Tools
 */

public class TOrderItemDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TOrderItemDAO.class);

	// property constants
	public static final String ORDER_ID = "orderId";

	public static final String GOODS_ID = "goodsId";

	public static final String GOODS_QUANTITY = "goodsQuantity";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TOrderItem transientInstance)
	{
		log.debug("saving TOrderItem instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TOrderItem persistentInstance)
	{
		log.debug("deleting TOrderItem instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TOrderItem findById(java.lang.Integer id)
	{
		log.debug("getting TOrderItem instance with id: " + id);
		try
		{
			TOrderItem instance = (TOrderItem) getHibernateTemplate().get(
					"cn.itbaizhan.model.TOrderItem", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TOrderItem instance)
	{
		log.debug("finding TOrderItem instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TOrderItem instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TOrderItem as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOrderId(Object orderId)
	{
		return findByProperty(ORDER_ID, orderId);
	}

	public List findByGoodsId(Object goodsId)
	{
		return findByProperty(GOODS_ID, goodsId);
	}

	public List findByGoodsQuantity(Object goodsQuantity)
	{
		return findByProperty(GOODS_QUANTITY, goodsQuantity);
	}

	public List findAll()
	{
		log.debug("finding all TOrderItem instances");
		try
		{
			String queryString = "from TOrderItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TOrderItem merge(TOrderItem detachedInstance)
	{
		log.debug("merging TOrderItem instance");
		try
		{
			TOrderItem result = (TOrderItem) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TOrderItem instance)
	{
		log.debug("attaching dirty TOrderItem instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TOrderItem instance)
	{
		log.debug("attaching clean TOrderItem instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TOrderItemDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TOrderItemDAO) ctx.getBean("TOrderItemDAO");
	}
}