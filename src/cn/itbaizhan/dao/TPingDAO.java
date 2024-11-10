package cn.itbaizhan.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itbaizhan.dao.TPingDAO;

import cn.itbaizhan.model.TPing;

/**
 * Data access object (DAO) for domain model class TOrder.
 * 
 * @see cn.itbaizhan.model.TOrder
 * @author MyEclipse Persistence Tools
 */

public class TPingDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TPingDAO.class);

	// property constants


	protected void initDao()
	{
		// do nothing
	}

	public void save(TPing transientInstance)
	{
		log.debug("saving TPing instance");
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

	public void delete(TPing persistentInstance)
	{
		log.debug("deleting TPing instance");
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

	public TPing findById(java.lang.Integer id)
	{
		log.debug("getting TPing instance with id: " + id);
		try
		{
			TPing instance = (TPing) getHibernateTemplate().get(
					"cn.itbaizhan.model.TPing", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPing instance)
	{
		log.debug("finding TPing instance by example");
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
		log.debug("finding TPing instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TPing as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByGoodsId(Object goodsId)
	{
		return findByProperty("goodsId", goodsId);
	}

	 

	public List findAll()
	{
		log.debug("finding all TPing instances");
		try
		{
			String queryString = "from TPing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPing merge(TPing detachedInstance)
	{
		log.debug("merging TPing instance");
		try
		{
			TPing result = (TPing) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPing instance)
	{
		log.debug("attaching dirty TPing instance");
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

	public void attachClean(TPing instance)
	{
		log.debug("attaching clean TPing instance");
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

	public static TPingDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TPingDAO) ctx.getBean("TPingDAO");
	}
}