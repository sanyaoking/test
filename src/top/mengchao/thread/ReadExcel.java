package top.mengchao.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	private ArrayList<ExcelInfo> excelInfo = new ArrayList<ExcelInfo>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadExcel rc = new ReadExcel();
		rc.readExcel("d://汇总.xlsx");
	}

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象  
    public void readExcel(String url) {  
        try {  
        	File file = new File(url);
        	String fileName = file.getName();
        	ExcelInfo el = new ExcelInfo();
        	System.out.println(file.getName());
            // 创建输入流，读取Excel  
            InputStream is = new FileInputStream(file.getAbsolutePath());  
            // jxl提供的Workbook类  
            Workbook wb = new XSSFWorkbook(is);
            // Excel的页签数量  
            int sheet_size = wb.getNumberOfSheets();  
            for (int index = 0; index < sheet_size; index++) {  
                // 每个页签创建一个Sheet对象  
            	 Sheet sheet = wb.getSheetAt(0);
                // sheet.getRows()返回该页的总行数  
            	 ArrayList<DwxxCommonBean> dcblist = new ArrayList<DwxxCommonBean>();
                for (int i = 3; i < sheet.getPhysicalNumberOfRows(); i++) {  
                    // sheet.getColumns()返回该页的总列数  
                	if(null==sheet.getRow(i)) {
                		continue;
                	} 
                	//后去本行数据
                	System.out.println(i+"+++++++++++++++++++++++++==");
               	 	HashMap<String,String> tmp = getRoe(sheet.getRow(i));
               	 	if(null!=tmp) {
	               	    DwxxCommonBean dbtmp = getdwxxx(tmp);
	               	    dcblist.add(dbtmp);
               	 	}
                }  
                el.setDcblist(dcblist);
                el.setFileName(fileName);
                el.insertDB();
            }  
            
            wb.close();
            is.close();
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    private DwxxCommonBean getdwxxx(HashMap<String,String> tmp) {
    	HashMap<String,String> classinfo = Config.getinfo();
    	DwxxCommonBean dw  = new DwxxCommonBean();
    	DwxxRzBean drz = new DwxxRzBean();
    	HashMap<String,Field>  fdw  = UtilImportExcel.getMapFiled(dw);
    	HashMap<String,Field>  frz  = UtilImportExcel.getMapFiled(drz);
    	tmp.forEach((key,value)->{
    		String val = classinfo.get(key);
    		if(null!=val&&!"".equals(val)) {
    			int i = Integer.parseInt(key);
    			if(i<28||i>32) {
    				Field f = fdw.get(val);
    				f.setAccessible(true);
    				try {
						f.set(dw, value);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}else {
    				Field f = frz.get(val);
    				f.setAccessible(true);
    				try {
						f.set(drz, value);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    		}
    	});
    	dw.setDrb(drz);
    	return dw;
    }
	
    @SuppressWarnings("deprecation")
	private String getCellinfo( Cell cellinfo){
    	if(cellinfo==null) {
    		return null;
    	}
    	String value="";
    	switch (cellinfo.getCellType())
        {
            case XSSFCell.CELL_TYPE_NUMERIC: // 数字
//                double d = cellinfo.getNumericCellValue();
                DecimalFormat df = new DecimalFormat("0");  
                value = df.format(cellinfo.getNumericCellValue());  
//                value = String.valueOf(d);
                break;
            case XSSFCell.CELL_TYPE_STRING: // 字符串
                value = cellinfo.getStringCellValue()+"";
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                value = cellinfo.getBooleanCellValue()+"";
                break;
            case XSSFCell.CELL_TYPE_FORMULA: // 公式
                break;
            case XSSFCell.CELL_TYPE_BLANK: // 空值
                break;
            case XSSFCell.CELL_TYPE_ERROR: // 故障
                value = "故障";
                break;
            default:
                System.out.print("未知类型   ");
                value = "未知类型 ";
                break;
        }
    	
    	return value;
    }
    
    private HashMap<String,String> getRoe(Row r){
    	HashMap <String,String> tmp = new HashMap<String,String>();
    	for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {  
            Cell cellinfo = r.getCell(j); 
            String info = getCellinfo(cellinfo);
            if(j==1&&("".equals(cellinfo)||null==cellinfo)) {
            	return null;
            }
            tmp.put((j+1)+"", info);
            //System.out.println(info);  
        } 
    	
    	return tmp;
    }
    
	class ExcelInfo{
		private ArrayList<String> AGENCY1 = new ArrayList<String>();
		private ArrayList<String> MB = new ArrayList<String>();
		private ArrayList<String> GBDP = new ArrayList<String>();
		private ArrayList<String> GBDC = new ArrayList<String>();
		private ArrayList<String> GBGL = new ArrayList<String>();
		private ArrayList<String> GBUT = new ArrayList<String>();
		private ArrayList<String> GBFG = new ArrayList<String>();
		private String fileName="";
		private ArrayList<DwxxCommonBean> dcblist = new ArrayList<DwxxCommonBean>();
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}      
		public ArrayList<DwxxCommonBean> getDcblist() {
			return dcblist;
		}
		public void setDcblist(ArrayList<DwxxCommonBean> dcblist) {
			this.dcblist = dcblist;
		}
		public void insertDB() {
			AGENCY1 = UtilImportExcel.getBaseInfo("AGENCY1");
			MB = UtilImportExcel.getBaseInfo("MB");
			GBDP = UtilImportExcel.getBaseInfo("GBDP");
			GBDC = UtilImportExcel.getBaseInfo("GBDC");
			GBGL = UtilImportExcel.getBaseInfo("GBGL");
			GBUT = UtilImportExcel.getBaseInfo("GBUT");
			Properties properties = new Properties();
			     // 使用ClassLoader加载properties配置文件生成对应的输入流
	        InputStream in = ReadExcel.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
		       String sql_zg = "insert into GDMS_BD_DWXX (AGENCY_ID,AGENCY_CODE,AGENCY_NAME,AGENCY_SNAME,REGION_ID,REGION_CODE,REGION_NAME,PARENT_ID,IS_LEAF,LEVEL_NUM,RG_CODE,set_year,GBDP_ID)values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		       String sql = "insert into GDMS_BD_DWXX " + 
		       		"  (AGENCY_ID,REGION_ID,REGION_CODE,AGENCY_NAME,AGENCY_SNAME,MB_ID,GBDP_ID,GBDC_ID,GBUT_ID,DEPT_CODE,CREDIT_NO,ADDRESS,LEGAL_PERSON,LEGAL_PHONE,BILL_PERSON,BILL_PHONE,GS_ML_CODE,GS_REG_DATE,GS_REG_CAPITAL,GS_BUSI_SCOPE,GS_REG_JYNX,GS_REG_SHZB,GS_REG_ZCQK,GS_REG_FZQK,REMARK,GS_ZFRD,GS_YJHRD,GS_RMYHRD,GS_CHG_TYPE,GS_CHG_DATE,REGION_NAME,AGENCY_CODE,parent_id,is_leaf,level_NUM,RG_CODE,set_year)" + 
		       		"values " + 
		       		"  (?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?,?,?,?,?,?,?,?,?)" + 
		       		"";
		       String sql_del = "delete from GDMS_BD_DWXX where region_id = ";
		       PreparedStatement p = Connection.prepareStatement(sql);
		       
		       //去重复
		       System.out.println("==================="+this.dcblist.size());
		       this.dcblist = UtilImportExcel.remove(this.dcblist);
		       System.out.println("==================="+this.dcblist.size());
		       ArrayList<ArrayList<DwxxCommonBean>> qhpa = UtilImportExcel.qhpa(this.dcblist);
		       for(int psq=0;psq<qhpa.size();psq++) {
		    	   ArrayList<ArrayList<DwxxCommonBean>> dpa = UtilImportExcel.depa(qhpa.get(psq));
		    	   HashMap<String,String> hm = new  HashMap<String,String>();
			       for(int ps=0;ps<dpa.size();ps++) {
			    	   ArrayList<DwxxCommonBean> tmp_list = dpa.get(ps);
			    	   for(int i=0;i<tmp_list.size();i++) {
				    	   DwxxCommonBean dw  =tmp_list.get(i);
				    	   UtilImportExcel.setdw(dw,"AGENCY1",AGENCY1);
				    	   UtilImportExcel.setdw(dw,"MB",MB);
				    	   UtilImportExcel.setdw(dw,"GBDP",GBDP);
				    	   UtilImportExcel.setdw(dw,"GBDC",GBDC);
				    	   UtilImportExcel.setdw(dw,"GBGL",GBGL);
				    	   UtilImportExcel.setdw(dw,"GBUT",GBUT);
				    	   //如果去换已经存在则删除原有
//				    	   if(i==0&&ps==0) {
//					    	   PreparedStatement del = Connection.prepareStatement(sql_del+"'"+dw.getREGION_ID()+"'");
//					    	   del.executeUpdate();
//					    	   del.close();
//				    	   }
				    	   //插入主管部门
				    	   String zgbm = dw.getGBDP_ID();
				    	   String zgbm_reg = dw.getREGION_ID()+"##"+zgbm;
				    	   String v = hm.get(zgbm_reg);
				    	   String zgcode = UtilImportExcel.getGBDP(GBDP,zgbm,true);
				    	  
				    	   if(v==null) {
				    		   PreparedStatement p1 = Connection.prepareStatement(sql_zg);
				    		   String agency_id = UUID.randomUUID().toString(); 
				    		   if(null!=agency_id) {
				    			   hm.put(zgbm_reg, agency_id);
				    		   }else {
				    			   hm.put(zgbm_reg, zgbm);
				    		   }
				    		   
				    		   v = agency_id;
				    		   //System.out.println(agency_id);
				    		   p1.setString(1, agency_id);
				    		   String agency_code = UtilImportExcel.getGBDP(GBDP,zgbm,true);//GBDP.get(2);
				    		   p1.setString(2, agency_code);
				    		  // System.out.println(agency_code);
				    		   String agency_name = UtilImportExcel.getGBDP(GBDP,zgbm,false);//GBDP.get(2);
				    		   System.out.println(zgbm_reg+"==================================================="+v);
				    		   System.out.println(agency_code+"==================================================="+dw.getREGION_ID());
				    		   p1.setString(3, agency_name);
				    		   p1.setString(4, "");
				    		   p1.setString(5, dw.getREGION_ID());
				    		   p1.setString(6, dw.getREGION_CODE());
				    		   p1.setString(7, dw.getREGION_NAME());
				    		   p1.setString(8, "0");
				    		   p1.setString(9, "0");
				    		   p1.setString(10, "1");
				    		   p1.setString(11, "5200");
				    		   p1.setString(12, "2018");
				    		   p1.setString(13, dw.getGBDP_ID());
				    		   p1.executeUpdate();
				    		   p1.clearParameters();
				    	   }
				    	   //System.out.println(dw.getMB_ID());
				    	   String agency_id = UUID.randomUUID().toString(); 
				    	   //System.out.println(agency_id);
				    	   String angecy_code = (i+1)+"";
				    	   if(i<9) {
				    		   angecy_code = zgcode + "00"+angecy_code;
				    	   }else if(i>=9&&i<99){
				    		   angecy_code = zgcode + "0"+angecy_code;
				    	   }else {
				    		   angecy_code = zgcode + angecy_code;
				    	   }
				    	   //System.out.println(angecy_code);
				    	   System.out.println(angecy_code+"==================================================="+dw.getREGION_ID());
				    	   p.setString(1, agency_id);
				    	   p.setString(2, dw.getREGION_ID());
				    	   p.setString(3, dw.getREGION_CODE());
				    	   p.setString(4, dw.getAGENCY_NAME());
				    	   p.setString(5, dw.getAGENCY_SNAME());
				    	   p.setString(6, dw.getMB_ID());
				    	   p.setString(7, dw.getGBDP_ID());
				    	   p.setString(8, dw.getGBDC_ID());
				    	   p.setString(9, dw.getGBUT_ID());
				    	   p.setString(10, dw.getDEPT_CODE());
				    	   p.setString(11, dw.getCREDIT_NO());
				    	   p.setString(12, dw.getADDRESS());
				    	   p.setString(13, dw.getLEGAL_PERSON());
				    	   p.setString(14, dw.getLEGAL_PHONE());
				    	   p.setString(15, dw.getBILL_PERSON());
				    	   p.setString(16, dw.getBILL_PHONE());
				    	   p.setString(17, dw.getGS_ML_CODE());
				    	   p.setString(18, dw.getGS_REG_DATE());
				    	   p.setString(19, dw.getGS_REG_CAPITAL());
				    	   p.setString(20, dw.getGS_BUSI_SCOPE());
				    	   String jymx = dw.getGS_REG_JYNX();
				    	   if(!UtilImportExcel.isNumeric3(jymx)) {
				    		   jymx=0+"";
				    	   }
				    	   if(jymx.length()>=5) {
				    		   jymx=0+"";
				    	   }
//				    	   System.out.println(jymx);
//				    	   System.out.println(dw.getGS_REG_SHZB());
//				    	   System.out.println(dw.getGS_REG_ZCQK());
//				    	   System.out.println(dw.getGS_REG_FZQK());
				    	   p.setString(21, jymx);
				    	   p.setString(22, dw.getGS_REG_SHZB());
				    	   p.setString(23, dw.getGS_REG_ZCQK());
				    	   p.setString(24, dw.getGS_REG_FZQK());
				    	   p.setString(25, dw.getREMARK());
				    	   DwxxRzBean db = dw.getDrb(); 
				    	   p.setString(26, db.getGS_ZFRD());
				    	   p.setString(27, db.getGS_YJHRD());
				    	   p.setString(28, db.getGS_RMYHRD());
				    	   p.setString(29, db.getGS_CHG_TYPE());
				    	   p.setString(30, db.getGS_CHG_DATE());
				    	   p.setString(31, dw.getREGION_NAME());
				    	   p.setString(32, angecy_code);
				    	   p.setString(33, v);
				    	   p.setString(34, "1");
				    	   p.setString(35, "2");
				    	   p.setString(36, "5200");
				    	   p.setString(37, "2018");
				    	   p.executeUpdate();
				    	   //p.clearParameters();
				       }
				      
			       }
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
	      
		}
	}
}
