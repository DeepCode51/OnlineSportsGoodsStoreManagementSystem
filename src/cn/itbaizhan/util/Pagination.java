package cn.itbaizhan.util;

import java.util.List;

//��װҳ����ʾ�߼�
public class Pagination
{

	private int totle;// �ܹ���������

	private int pageSize;// ÿҳ��ʾ������

	private int totlePage;// ���ж���ҳ

	private int index;// ��ǰ�ǵڼ�ҳ

	private List data; // ����

	private String path;// ����·��

	public void setTotle(int totle)
	{
		this.totle = totle;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public int getTotle()
	{
		return totle;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public int getTotlePage()
	{
		return (this.totle + this.pageSize - 1) / this.pageSize;
	}

	public int getIndex()
	{
		return index;
	}

	public List getData()
	{
		return data;
	}

	public void setData(List data)
	{
		this.data = data;
	}

	public String getPageDisplay()
	{
		StringBuffer displayInfo = new StringBuffer();
		if (index == 0 || pageSize == 0)
		{
			displayInfo.append("û�з�ҳ����Ϣ!");
		} else
		{
			displayInfo.append("<div>");
			displayInfo.append("��" + totle
					+ "����¼&nbsp;&nbsp;&nbsp;&nbsp;ÿҳ<span style='color:#FF0000'>" + pageSize
					+ "</span>��&nbsp;&nbsp;&nbsp;&nbsp;");
			displayInfo.append("��<span style='color:#FF0000'>" + index
					+ "</span>ҳ/��" + this.getTotlePage() + "ҳ&nbsp;&nbsp;&nbsp;&nbsp;");
			// �ж������ǰ�ǵ�һҳ ����ҳ���͡���һҳ��ʧȥ����
			if (index == 1)
			{
				displayInfo.append("��ҳ&nbsp;&nbsp;&nbsp;&nbsp;");
				displayInfo.append("��һҳ&nbsp;&nbsp;&nbsp;&nbsp;");
			} else
			{
				displayInfo.append("<a href='" + path
						+ "index=1'>��ҳ&nbsp;&nbsp;&nbsp;&nbsp;</a>");
				displayInfo.append("<a href='" + path + "index=" + (index - 1)
						+ "'>��һҳ&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;");
			}
			if (index >= this.getTotlePage())
			{
				displayInfo.append("��һҳ&nbsp;&nbsp;&nbsp;&nbsp;");
				displayInfo.append("ĩҳ&nbsp;&nbsp;&nbsp;&nbsp;");
			} else
			{
				displayInfo.append("<a href='" + path + "index=" + (index + 1)
						+ "'>��һҳ&nbsp;&nbsp;&nbsp;&nbsp;</a>");
				displayInfo.append("<a href='" + path + "index="
						+ this.getTotlePage() + "'>ĩҳ</a>&nbsp;&nbsp;&nbsp;&nbsp;");
			}
			displayInfo.append("</div>");
		}
		return displayInfo.toString();
	}
}
