package top.mengchao.thread;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilImportExcel {
	public static <T> HashMap<String,Field> getMapFiled(T t) {
		Field[] f = t.getClass().getDeclaredFields();
		HashMap<String,Field> hm = new HashMap<String,Field>();
		for(int i=0;i<f.length;i++) {
			try {
				String key = f[i].getName();
				hm.put(key, f[i]);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return hm;
	}
	
	public static ArrayList<ArrayList<DwxxCommonBean>> qhpa(ArrayList<DwxxCommonBean> list){
		HashMap<String,ArrayList<DwxxCommonBean>> hm = new HashMap<String,ArrayList<DwxxCommonBean>>();
		list.stream().forEach(action->{
			String tmp = action.getREGION_CODE();
			if(null!=hm.get(tmp)) {
				ArrayList<DwxxCommonBean> ltmp = hm.get(tmp);
				ltmp.add(action);
			}else {
				ArrayList<DwxxCommonBean> ltmp = new ArrayList<DwxxCommonBean>();
				ltmp.add(action);
				hm.put(tmp,ltmp);
			}
		});
		return (ArrayList<ArrayList<DwxxCommonBean>>) hm.values().stream().collect(Collectors.toList());
	}
	
	public static ArrayList<ArrayList<DwxxCommonBean>> depa(ArrayList<DwxxCommonBean> list){
		HashMap<String,ArrayList<DwxxCommonBean>> hm = new HashMap<String,ArrayList<DwxxCommonBean>>();
		list.stream().forEach(action->{
			String tmp = action.getGBDP_ID();
			if("其他".equals(tmp)) {
				tmp = "其他部门";
			}
			if(null!=hm.get(tmp)) {
				ArrayList<DwxxCommonBean> ltmp = hm.get(tmp);
				ltmp.add(action);
			}else {
				ArrayList<DwxxCommonBean> ltmp = new ArrayList<DwxxCommonBean>();
				ltmp.add(action);
				hm.put(tmp,ltmp);
			}
		});
		return (ArrayList<ArrayList<DwxxCommonBean>>) hm.values().stream().collect(Collectors.toList());
	}
	
	public static  ArrayList<DwxxCommonBean> remove( ArrayList<DwxxCommonBean> dcblist ) {
		ArrayList<DwxxCommonBean> list = new ArrayList<DwxxCommonBean>();
		dcblist.stream().forEach(e->{
			if(!list.contains(e)) {
				list.add(e);
			}
		});
		return list;
	}
	
	public static void setdw(DwxxCommonBean dw,String key,ArrayList<String> list) {
		
		switch (key) {
			case "AGENCY1":
				String tmp = dw.getREGION_CODE();
				if(tmp.indexOf(".")>0) {
					String tmpt = tmp.substring(0, tmp.indexOf("."));
					dw.setREGION_CODE(tmpt);
					ArrayList<String> l = UtilImportExcel.getinfo(list, tmpt);
					dw.setREGION_ID(l.get(0));
					dw.setREGION_NAME(l.get(2));
				}else {
					ArrayList<String> l = UtilImportExcel.getinfo(list, tmp);
					System.out.println(tmp);
					dw.setREGION_ID(l.get(0));
					dw.setREGION_NAME(l.get(2));
				}
				
				
				break;
			case "MB":
				String tmp1 = dw.getMB_ID();
				ArrayList<String> l1 = UtilImportExcel.getinfo(list, tmp1);
				if(l1.size()!=0) {
					dw.setMB_ID(l1.get(0));
				}
				break;
			case "GBDP":
				String tmp2 = dw.getGBDP_ID();
				if("其他".equals(tmp2)) {
					tmp2 = "其他部门";
				}
				ArrayList<String> l2 = UtilImportExcel.getinfo(list, tmp2);
				if(l2.size()!=0) {
					dw.setGBDP_ID(l2.get(0));
				}
				break;
			case "GBDC":
				String tmp3 = dw.getGBDC_ID();
				ArrayList<String> l3 = UtilImportExcel.getinfo(list, tmp3);
				if(l3.size()!=0) {
					dw.setGBDC_ID(l3.get(0));
				}
				break;
			case "GBGL":
				String tmp4 = dw.getGBGL_ID();
				ArrayList<String> l4 = UtilImportExcel.getinfo(list, tmp4);
				if(l4.size()!=0) {
					dw.setGBGL_ID(l4.get(0));
				}
				break;
			case "GBUT":
				String tmp5 = dw.getGBUT_ID();
				ArrayList<String> l5 = UtilImportExcel.getinfo(list, tmp5);
				if(l5.size()!=0) {
					dw.setGBUT_ID(l5.get(0));
				}
				break;
			default:
				break;
		}
	}
	
	public static String getGBDP(ArrayList<String> list,String key,boolean b) {
		ArrayList<String> ar = new ArrayList<String>();
		String key_tmp = "";
		if("其他".equals(key)) {
			key_tmp="其他部门";
		}else {
			key_tmp = key;
		}
		final String key_ = key_tmp;
		List li = list.stream().filter(e->{
			if(e.indexOf("$$"+key_+"$$")>=0) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		if(li.size()>0) {
			String tmp  =(String)li.get(0);
			String[] t = tmp.split("\\$\\$");
			ar.add(t[1]);
			ar.add(t[2]);
			ar.add(t[3]);
			//return  tmp.split("$$")[]
		}
		if(ar.size()==0) {
			System.out.println(key);
		}
		if(b) {
			System.out.println();
			return ar.get(1);
		}else {
			return ar.get(2);
		}
	}
	
	
	public static ArrayList<String> getinfo(ArrayList<String> list,String key) {
		ArrayList<String> ar = new ArrayList<String>();
		List li = list.stream().filter(e->{
			if(e.indexOf("$$"+key+"$$")>=0) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		if(li.size()>0) {
			String tmp  =(String)li.get(0);
			String[] t = tmp.split("\\$\\$");
			ar.add(t[1]);
			ar.add(t[2]);
			ar.add(t[3]);
			//return  tmp.split("$$")[]
		}
		return ar;
	}
	public static boolean isNumeric3(String str)
	{
	  final String number = "0123456789.";
	  for(int i = 0;i < str.length(); i ++)
	  {
		  if(number.indexOf(str.charAt(i)) == -1)
	     {  
	        return false;  
	     }  
	  }  
	  return true;
	}
	public static void main(String[] str) {
		
		String tmp = "2060/7/22";
		System.out.println(isNumeric3(tmp));
//		String t ="$$a$$b$$c$$";
//		System.out.println(t.indexOf("$$"+"b$$"));
//		String[] tmp = t.split("\\$\\$");
//		Stream.of(tmp).forEach(e->{
//			System.out.println(e);
//		});
//		getBaseInfo("AGENCY");
//		UtilImportExcel.getBaseInfo("MB");
//		UtilImportExcel.getBaseInfo("GBDP");
//		UtilImportExcel.getBaseInfo("GBDC");
//		UtilImportExcel.getBaseInfo("GBGL");
//		UtilImportExcel.getBaseInfo("GBUT");
	}
	public static ArrayList<String> getBaseInfo(String ele_code){
		Properties properties = new Properties();
	     // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = ReadExcel.class.getClassLoader().getResourceAsStream("jdbc.properties");
        ArrayList<String> hlist = new ArrayList<String>();
        // 使用properties对象加载输入流
        try {
			properties.load(in);
			 //获取key对应的value值
	        String dir =  properties.getProperty("jdbc.driver_class");
	        String url =  properties.getProperty("jdbc.connection.url");
	        String username =  properties.getProperty("jdbc.connection.username");
	        String password =  properties.getProperty("jdbc.connection.password");
	       // 加载JDBC驱动
	       Class.forName(dir);
	       Connection Connection=DriverManager.getConnection(url, username, password);
	       String sql = "select ele_source from sys_element where ele_code='"+ele_code+"'";
	       PreparedStatement p = Connection.prepareStatement(sql);
	       ResultSet rs = p.executeQuery();
	       while(rs.next()) {
	    	   System.out.println(ele_code);
	    	  String vw =  rs.getString(1);
	    	  sql = "select chr_id,chr_code,chr_name from "+vw;
	    	  PreparedStatement tmp = Connection.prepareStatement(sql);
	    	  ResultSet rs_tmp = tmp.executeQuery();
	    	  while(rs_tmp.next()) {
	    		  String str_tmp = "$$"+rs_tmp.getString(1)+"$$"+rs_tmp.getString(2)+"$$"+rs_tmp.getString(3)+"$$";
	    		  hlist.add(str_tmp);
	    		  //System.out.println(str_tmp);
	    	  }
	    	  tmp.close();
	       }
	       p.close();
	       Connection.close();
	       
	     
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hlist;
		
	}
}
