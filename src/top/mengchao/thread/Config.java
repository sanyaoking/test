package top.mengchao.thread;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Config {
	private String REGION_CODE     ="4";   
	private String AGENCY_NAME     ="7";   
	private String AGENCY_SNAME    ="8";   
	private String MB_ID           ="9";   
	private String GBDP_ID         ="10";   
	private String GBDC_ID         ="11";
	private String GBUT_ID         ="12";
	private String DEPT_CODE       ="13";
	private String CREDIT_NO       ="14";
	private String ADDRESS         ="15";
	private String LEGAL_PERSON    ="16";
	private String LEGAL_PHONE     ="17";
	private String BILL_PERSON     ="18";
	private String BILL_PHONE      ="19";
	private String GS_ML_CODE      ="20";
	private String GS_REG_DATE     ="21";
	private String GS_REG_CAPITAL  ="22";
	private String GS_BUSI_SCOPE   ="23";
	private String GS_REG_JYNX     ="24";
	private String GS_REG_SHZB     ="25";
	private String GS_REG_ZCQK     ="26";
	private String GS_REG_FZQK     ="27";
	private String REMARK          ="33";
	/**融资平台专用**/
	private String GS_ZFRD         ="28";
	private String GS_YJHRD        ="29";
	private String GS_RMYHRD       ="30";
	private String GS_CHG_TYPE     ="31";
	private String GS_CHG_DATE     ="32";
	
	public static HashMap<String,String> getinfo(){
		Config con = new Config();
		Field[] f  = con.getClass().getDeclaredFields();
		HashMap<String,String> hm = new HashMap<String,String>();
		for(int i=0;i<f.length;i++) {
			try {
				String key =(String)(f[i].get(con));
				String value = f[i].getName();
				hm.put(key, value);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return hm;
	}
	
	public String getREGION_CODE() {
		return REGION_CODE;
	}
	public void setREGION_CODE(String rEGION_CODE) {
		REGION_CODE = rEGION_CODE;
	}
	public String getAGENCY_NAME() {
		return AGENCY_NAME;
	}
	public void setAGENCY_NAME(String aGENCY_NAME) {
		AGENCY_NAME = aGENCY_NAME;
	}
	public String getAGENCY_SNAME() {
		return AGENCY_SNAME;
	}
	public void setAGENCY_SNAME(String aGENCY_SNAME) {
		AGENCY_SNAME = aGENCY_SNAME;
	}
	public String getMB_ID() {
		return MB_ID;
	}
	public void setMB_ID(String mB_ID) {
		MB_ID = mB_ID;
	}
	public String getGBDP_ID() {
		return GBDP_ID;
	}
	public void setGBDP_ID(String gBDP_ID) {
		GBDP_ID = gBDP_ID;
	}
	public String getGBDC_ID() {
		return GBDC_ID;
	}
	public void setGBDC_ID(String gBDC_ID) {
		GBDC_ID = gBDC_ID;
	}
	public String getGBUT_ID() {
		return GBUT_ID;
	}
	public void setGBUT_ID(String gBUT_ID) {
		GBUT_ID = gBUT_ID;
	}
	public String getDEPT_CODE() {
		return DEPT_CODE;
	}
	public void setDEPT_CODE(String dEPT_CODE) {
		DEPT_CODE = dEPT_CODE;
	}
	public String getCREDIT_NO() {
		return CREDIT_NO;
	}
	public void setCREDIT_NO(String cREDIT_NO) {
		CREDIT_NO = cREDIT_NO;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getLEGAL_PERSON() {
		return LEGAL_PERSON;
	}
	public void setLEGAL_PERSON(String lEGAL_PERSON) {
		LEGAL_PERSON = lEGAL_PERSON;
	}
	public String getLEGAL_PHONE() {
		return LEGAL_PHONE;
	}
	public void setLEGAL_PHONE(String lEGAL_PHONE) {
		LEGAL_PHONE = lEGAL_PHONE;
	}
	public String getBILL_PERSON() {
		return BILL_PERSON;
	}
	public void setBILL_PERSON(String bILL_PERSON) {
		BILL_PERSON = bILL_PERSON;
	}
	public String getBILL_PHONE() {
		return BILL_PHONE;
	}
	public void setBILL_PHONE(String bILL_PHONE) {
		BILL_PHONE = bILL_PHONE;
	}
	public String getGS_ML_CODE() {
		return GS_ML_CODE;
	}
	public void setGS_ML_CODE(String gS_ML_CODE) {
		GS_ML_CODE = gS_ML_CODE;
	}
	public String getGS_REG_DATE() {
		return GS_REG_DATE;
	}
	public void setGS_REG_DATE(String gS_REG_DATE) {
		GS_REG_DATE = gS_REG_DATE;
	}
	public String getGS_REG_CAPITAL() {
		return GS_REG_CAPITAL;
	}
	public void setGS_REG_CAPITAL(String gS_REG_CAPITAL) {
		GS_REG_CAPITAL = gS_REG_CAPITAL;
	}
	public String getGS_BUSI_SCOPE() {
		return GS_BUSI_SCOPE;
	}
	public void setGS_BUSI_SCOPE(String gS_BUSI_SCOPE) {
		GS_BUSI_SCOPE = gS_BUSI_SCOPE;
	}
	public String getGS_REG_JYNX() {
		return GS_REG_JYNX;
	}
	public void setGS_REG_JYNX(String gS_REG_JYNX) {
		GS_REG_JYNX = gS_REG_JYNX;
	}
	public String getGS_REG_SHZB() {
		return GS_REG_SHZB;
	}
	public void setGS_REG_SHZB(String gS_REG_SHZB) {
		GS_REG_SHZB = gS_REG_SHZB;
	}
	public String getGS_REG_ZCQK() {
		return GS_REG_ZCQK;
	}
	public void setGS_REG_ZCQK(String gS_REG_ZCQK) {
		GS_REG_ZCQK = gS_REG_ZCQK;
	}
	public String getGS_REG_FZQK() {
		return GS_REG_FZQK;
	}
	public void setGS_REG_FZQK(String gS_REG_FZQK) {
		GS_REG_FZQK = gS_REG_FZQK;
	}
	public String getGS_ZFRD() {
		return GS_ZFRD;
	}
	public void setGS_ZFRD(String gS_ZFRD) {
		GS_ZFRD = gS_ZFRD;
	}
	public String getGS_YJHRD() {
		return GS_YJHRD;
	}
	public void setGS_YJHRD(String gS_YJHRD) {
		GS_YJHRD = gS_YJHRD;
	}
	public String getGS_RMYHRD() {
		return GS_RMYHRD;
	}
	public void setGS_RMYHRD(String gS_RMYHRD) {
		GS_RMYHRD = gS_RMYHRD;
	}
	public String getGS_CHG_TYPE() {
		return GS_CHG_TYPE;
	}
	public void setGS_CHG_TYPE(String gS_CHG_TYPE) {
		GS_CHG_TYPE = gS_CHG_TYPE;
	}
	public String getGS_CHG_DATE() {
		return GS_CHG_DATE;
	}
	public void setGS_CHG_DATE(String gS_CHG_DATE) {
		GS_CHG_DATE = gS_CHG_DATE;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	

}
