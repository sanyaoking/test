package top.mengchao.thread;

import java.lang.reflect.Field;
import java.util.HashMap;

public class DwxxRzBean {
	private String GBFG_ID           ;//����ƽ̨����
	private String GS_TYPE           ;//����ƽ̨����
	private String GS_SFRD           ;//�Ƿ������϶�
	private String GS_ZFRD           ;//���������϶�
	private String GS_YJHRD          ;//������϶�
	private String GS_RMYHRD         ;//���������϶�
	private String GS_CHG_TYPE       ;//�������
	private String GS_CHG_DATE       ;//�������

	public String getGBFG_ID() {
		return GBFG_ID;
	}
	public void setGBFG_ID(String gBFG_ID) {
		GBFG_ID = gBFG_ID;
	}
	public String getGS_TYPE() {
		return GS_TYPE;
	}
	public void setGS_TYPE(String gS_TYPE) {
		GS_TYPE = gS_TYPE;
	}
	public String getGS_SFRD() {
		if("��".equals(GS_SFRD)) {
			GS_SFRD=1+"";
		}else {
			GS_SFRD=0+"";
		}
		return GS_SFRD;
	}
	public void setGS_SFRD(String gS_SFRD) {
		if("��".equals(gS_SFRD)) {
			GS_SFRD=1+"";
		}else {
			GS_SFRD=0+"";
		}
//		GS_SFRD = gS_SFRD;
	}
	public String getGS_ZFRD() {
		if("��".equals(GS_ZFRD)) {
			GS_ZFRD=1+"";
		}else {
			GS_ZFRD=0+"";
		}
		return GS_ZFRD;
	}
	public void setGS_ZFRD(String gS_ZFRD) {
		if("��".equals(gS_ZFRD)) {
			GS_ZFRD=1+"";
		}else {
			GS_ZFRD=0+"";
		}
//		GS_ZFRD = gS_ZFRD;
	}
	public String getGS_YJHRD() {
		if("��".equals(GS_YJHRD)) {
			GS_YJHRD=1+"";
		}else {
			GS_YJHRD=0+"";
		}
		return GS_YJHRD;
	}
	public void setGS_YJHRD(String gS_YJHRD) {
		if("��".equals(gS_YJHRD)) {
			GS_YJHRD=1+"";
		}else {
			GS_YJHRD=0+"";
		}
//		GS_YJHRD = gS_YJHRD;
	}
	public String getGS_RMYHRD() {
		if("��".equals(GS_RMYHRD)) {
			GS_RMYHRD=1+"";
		}else {
			GS_RMYHRD=0+"";
		}
		return GS_RMYHRD;
	}
	public void setGS_RMYHRD(String gS_RMYHRD) {
		if("��".equals(gS_RMYHRD)) {
			GS_RMYHRD=1+"";
		}else {
			GS_RMYHRD=0+"";
		}
//		GS_RMYHRD = gS_RMYHRD;
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
	
}
