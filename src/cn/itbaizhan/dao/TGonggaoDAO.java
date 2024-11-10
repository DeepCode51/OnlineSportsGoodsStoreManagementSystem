package cn.itbaizhan.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itbaizhan.dao.TGonggaoDAO;

import cn.itbaizhan.model.TGonggao;

/**
 * Data access object (DAO) for domain model class TGonggao.
 * 
 * @see cn.itbaizhan.model.TGonggao
 * @author MyEclipse Persistence Tools
 */

public class TGonggaoDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TGonggaoDAO.class);

	// property constants
	public static final String GONGGAO_TITLE = "gonggaoTitle";

	public static final String GONGGAO_CONTENT = "gonggaoContent";

	public static final String GONGGAO_FABUZHE = "gonggaoFabuzhe";

	public static final String GONGGAO_ONE1 = "gonggaoOne1";

	public static final String GONGGAO_ONE2 = "gonggaoOne2";

	public static final String GONGGAO_ONE3 = "gonggaoOne3";

	public static final String GONGGAO_ONE4 = "gonggaoOne4";

	public static final String GONGGAO_ONE7 = "gonggaoOne7";

	public static final String GONGGAO_ONE8 = "gonggaoOne8";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TGonggao transientInstance)
	{
		log.debug("saving TGonggao instance");
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

	public void delete(TGonggao persistentInstance)
	{
		log.debug("deleting TGonggao instance");
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

	public TGonggao findById(java.lang.Integer id)
	{
		log.debug("getting TGonggao instance with id: " + id);
		try
		{
			TGonggao instance = (TGonggao) getHibernateTemplate().get(
					"cn.itbaizhan.model.TGonggao", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TGonggao instance)
	{
		log.debug("finding TGonggao instance by example");
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
		log.debug("finding TGonggao instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TGonggao as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGonggaoTitle(Object gonggaoTitle)
	{
		return findByProperty(GONGGAO_TITLE, gonggaoTitle);
	}

	public List findByGonggaoContent(Object gonggaoContent)
	{
		return findByProperty(GONGGAO_CONTENT, gonggaoContent);
	}

	public List findByGonggaoFabuzhe(Object gonggaoFabuzhe)
	{
		return findByProperty(GONGGAO_FABUZHE, gonggaoFabuzhe);
	}

	public List findByGonggaoOne1(Object gonggaoOne1)
	{
		return findByProperty(GONGGAO_ONE1, gonggaoOne1);
	}

	public List findByGonggaoOne2(Object gonggaoOne2)
	{
		return findByProperty(GONGGAO_ONE2, gonggaoOne2);
	}

	public List findByGonggaoOne3(Object gonggaoOne3)
	{
		return findByProperty(GONGGAO_ONE3, gonggaoOne3);
	}

	public List findByGonggaoOne4(Object gonggaoOne4)
	{
		return findByProperty(GONGGAO_ONE4, gonggaoOne4);
	}

	public List findByGonggaoOne7(Object gonggaoOne7)
	{
		return findByProperty(GONGGAO_ONE7, gonggaoOne7);
	}

	public List findByGonggaoOne8(Object gonggaoOne8)
	{
		return findByProperty(GONGGAO_ONE8, gonggaoOne8);
	}

	public List findAll()
	{
		log.debug("finding all TGonggao instances");
		try
		{
			String queryString = "from TGonggao order by gonggaoId desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TGonggao merge(TGonggao detachedInstance)
	{
		log.debug("merging TGonggao instance");
		try
		{
			TGonggao result = (TGonggao) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TGonggao instance)
	{
		log.debug("attaching dirty TGonggao instance");
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

	public void attachClean(TGonggao instance)
	{
		log.debug("attaching clean TGonggao instance");
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

	public static TGonggaoDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TGonggaoDAO) ctx.getBean("TGonggaoDAO");
	}
}