package top.mengchao.thread;

import java.lang.reflect.Field;
import java.util.HashMap;

public class DwxxCommonBean {
	private String AGENCY_ID         ;//单位ID
	private String AGENCY_CODE       ;//单位编码
	private String AGENCY_NAME       ;//单位名称
	private String AGENCY_SNAME      ;//单位简称
	private String REGION_ID         ;//所属机构ID
	private String REGION_CODE       ;//所属机构编码
	private String REGION_NAME       ;//所属机构名称
	private String PARENT_ID         ;//上级单位
	private String IS_LEAF           ;//是否末级节点
	private String LEVEL_NUM         ;//单位级次
	private String MB_ID             ;//业务处室
	private String GBDP_ID           ;//主管部门
	private String GBDC_ID           ;//部门分类
	private String GBGL_ID           ;//行政级次
	private String GBUT_ID           ;//单位类型
	private String BS_ID             ;//功能分类
	private String YSDW_CODE         ;//预算单位编码
	private String DEPT_CODE         ;//注册编码
	private String CREDIT_NO         ;//贷款证号
	private String ADDRESS           ;//单位地址
	private String LEGAL_PERSON      ;//法人代表
	private String LEGAL_PHONE       ;//法人代表联系电话
	private String BILL_PERSON       ;//财务负责人
	private String BILL_PHONE        ;//财务联系电话
	private String GS_ML_CODE        ;//土储机构名录代码
	private String GS_REG_DATE       ;//公司注册时间
	private String GS_REG_CAPITAL    ;//注册资本(元)
	private String GS_BUSI_SCOPE     ;//经营范围
	private String GS_REG_JYNX       ;//经营年限（年）
	private String GS_REG_SHZB       ;//实收资本
	private String GS_REG_ZCQK       ;//资产情况
	private String GS_REG_FZQK       ;//负债情况
	private String BOND_ACCOUNT_NAME ;//债券账户名称
	private String ACCOUNT_NUMBER    ;//账号
	private String ACCOUNT_BANK      ;//开户行
	private String CONTACT           ;//联系人
	private String CONTACT_NUMBER    ;//办公电话
	private String CONTACT_PHONE     ;//手机
	private String CONTACT_EMAIL     ;//邮箱
	private String IS_UPLOAD         ;//是否为上报单位
	private String IS_MANAGER        ;// 是否为管理单位0是，1否
	private String IS_CW             ;//否衔接财务系统0是，1否
	private String RG_CODE           ;//区划编码
	private String SET_YEAR          ;//业务年度
	private String REMARK            ;//备注
	private String GS_ML_STATUS      ;//平台名录状态：11名录外；12退出名录；21名录内
	private DwxxRzBean drb  = null;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DwxxCommonBean person = (DwxxCommonBean) o;
        
        if(null==AGENCY_NAME) {
//        	System.out.println(AGENCY_NAME);
        	return true;
        }
        if (!AGENCY_NAME.equals(person.getAGENCY_NAME())) {
        	
        	return false;
        }else {
        	return true;
        }
       

    }

    @Override
    public int hashCode() {
        int result = AGENCY_NAME.hashCode();
        result = 31 * result + AGENCY_NAME.hashCode();
        return result;
    }
	
	public String getAGENCY_ID() {
		return AGENCY_ID;
	}
	public void setAGENCY_ID(String aGENCY_ID) {
		AGENCY_ID = aGENCY_ID;
	}
	public String getAGENCY_CODE() {
		return AGENCY_CODE;
	}
	public void setAGENCY_CODE(String aGENCY_CODE) {
		AGENCY_CODE = aGENCY_CODE;
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
	public String getREGION_ID() {
		return REGION_ID;
	}
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	public String getREGION_CODE() {
		return REGION_CODE;
	}
	public void setREGION_CODE(String rEGION_CODE) {
		REGION_CODE = rEGION_CODE;
	}
	public String getREGION_NAME() {
		return REGION_NAME;
	}
	public void setREGION_NAME(String rEGION_NAME) {
		REGION_NAME = rEGION_NAME;
	}
	public String getPARENT_ID() {
		return PARENT_ID;
	}
	public void setPARENT_ID(String pARENT_ID) {
		PARENT_ID = pARENT_ID;
	}
	public String getIS_LEAF() {
		return IS_LEAF;
	}
	public void setIS_LEAF(String iS_LEAF) {
		IS_LEAF = iS_LEAF;
	}
	public String getLEVEL_NUM() {
		return LEVEL_NUM;
	}
	public void setLEVEL_NUM(String lEVEL_NUM) {
		LEVEL_NUM = lEVEL_NUM;
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
	public String getGBGL_ID() {
		return GBGL_ID;
	}
	public void setGBGL_ID(String gBGL_ID) {
		GBGL_ID = gBGL_ID;
	}
	public String getGBUT_ID() {
		return GBUT_ID;
	}
	public void setGBUT_ID(String gBUT_ID) {
		GBUT_ID = gBUT_ID;
	}
	public String getBS_ID() {
		return BS_ID;
	}
	public void setBS_ID(String bS_ID) {
		BS_ID = bS_ID;
	}
	public String getYSDW_CODE() {
		return YSDW_CODE;
	}
	public void setYSDW_CODE(String ySDW_CODE) {
		YSDW_CODE = ySDW_CODE;
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
		if(!UtilImportExcel.isNumeric3(GS_REG_CAPITAL)) {
			GS_REG_CAPITAL=0+"";
 	   }
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
		if(!UtilImportExcel.isNumeric3(GS_REG_SHZB)) {
			GS_REG_SHZB=0+"";
 	   }
		return GS_REG_SHZB;
	}
	public void setGS_REG_SHZB(String gS_REG_SHZB) {
		GS_REG_SHZB = gS_REG_SHZB;
	}
	public String getGS_REG_ZCQK() {
		if(!UtilImportExcel.isNumeric3(GS_REG_ZCQK)) {
			GS_REG_ZCQK=0+"";
 	   }
		return GS_REG_ZCQK;
	}
	public void setGS_REG_ZCQK(String gS_REG_ZCQK) {
		GS_REG_ZCQK = gS_REG_ZCQK;
	}
	public String getGS_REG_FZQK() {
		if(!UtilImportExcel.isNumeric3(GS_REG_FZQK)) {
			GS_REG_FZQK=0+"";
 	   }
		return GS_REG_FZQK;
	}
	public void setGS_REG_FZQK(String gS_REG_FZQK) {
		GS_REG_FZQK = gS_REG_FZQK;
	}
	public String getBOND_ACCOUNT_NAME() {
		return BOND_ACCOUNT_NAME;
	}
	public void setBOND_ACCOUNT_NAME(String bOND_ACCOUNT_NAME) {
		BOND_ACCOUNT_NAME = bOND_ACCOUNT_NAME;
	}
	public String getACCOUNT_NUMBER() {
		return ACCOUNT_NUMBER;
	}
	public void setACCOUNT_NUMBER(String aCCOUNT_NUMBER) {
		ACCOUNT_NUMBER = aCCOUNT_NUMBER;
	}
	public String getACCOUNT_BANK() {
		return ACCOUNT_BANK;
	}
	public void setACCOUNT_BANK(String aCCOUNT_BANK) {
		ACCOUNT_BANK = aCCOUNT_BANK;
	}
	public String getCONTACT() {
		return CONTACT;
	}
	public void setCONTACT(String cONTACT) {
		CONTACT = cONTACT;
	}
	public String getCONTACT_NUMBER() {
		return CONTACT_NUMBER;
	}
	public void setCONTACT_NUMBER(String cONTACT_NUMBER) {
		CONTACT_NUMBER = cONTACT_NUMBER;
	}
	public String getCONTACT_PHONE() {
		return CONTACT_PHONE;
	}
	public void setCONTACT_PHONE(String cONTACT_PHONE) {
		CONTACT_PHONE = cONTACT_PHONE;
	}
	public String getCONTACT_EMAIL() {
		return CONTACT_EMAIL;
	}
	public void setCONTACT_EMAIL(String cONTACT_EMAIL) {
		CONTACT_EMAIL = cONTACT_EMAIL;
	}
	public String getIS_UPLOAD() {
		return IS_UPLOAD;
	}
	public void setIS_UPLOAD(String iS_UPLOAD) {
		IS_UPLOAD = iS_UPLOAD;
	}
	public String getIS_MANAGER() {
		return IS_MANAGER;
	}
	public void setIS_MANAGER(String iS_MANAGER) {
		IS_MANAGER = iS_MANAGER;
	}
	public String getIS_CW() {
		return IS_CW;
	}
	public void setIS_CW(String iS_CW) {
		IS_CW = iS_CW;
	}
	public String getRG_CODE() {
		return RG_CODE;
	}
	public void setRG_CODE(String rG_CODE) {
		RG_CODE = rG_CODE;
	}
	public String getSET_YEAR() {
		return SET_YEAR;
	}
	public void setSET_YEAR(String sET_YEAR) {
		SET_YEAR = sET_YEAR;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	public String getGS_ML_STATUS() {
		return GS_ML_STATUS;
	}
	public void setGS_ML_STATUS(String gS_ML_STATUS) {
		GS_ML_STATUS = gS_ML_STATUS;
	}
	
	public DwxxRzBean getDrb() {
		return drb;
	}
	public void setDrb(DwxxRzBean drb) {
		this.drb = drb;
	}

	
}
