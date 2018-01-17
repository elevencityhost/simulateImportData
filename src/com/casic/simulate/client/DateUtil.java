package com.casic.simulate.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 时间工具类<br> 
 * @author 十一城城主
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateUtil {
    /**
     * 
     * 功能描述: 获取当前时间<br>
     *
     * @autor 十一城城主
     * @param format
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getTodayByFormat(String format){
    	Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String szSBDate=sdf.format(c.getTime()); 
        return szSBDate;
    }
    
    /**
     * 
     * @param dateStr
     * @param format
     * @return
     * @author 十一城城主
     * @version V1.0
     */
	public static Date str2DateByFormat(String dateStr, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
    
    /**
     * 格式化日期
     * @param date
     * @param format
     * @return
     * @author 十一城城主
     * @version V1.0
     */
    public static String getDateByFormat(Date date,String format){
    	SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
    	String szSBDate=sdf.format(date.getTime()); 
    	return szSBDate;
    }
    
    /**
     * 获取几天之后的日期
     * @param day
     * @return
     */
    public static Date getAfterDays(int day){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
        c.add(Calendar.DAY_OF_YEAR, day);
        return c.getTime();
    }
    /**
     * 获取几天之前的日期
     * @param day
     * @return
     */
    public static Date getBeforeDays(int day){
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date());
    	c.add(Calendar.DAY_OF_YEAR, -day);
    	return c.getTime();
    }
    
    /**
     * 获取几秒之前的时间
     * @param second
     * @return
     * @author 十一城城主
     * @version V1.0
     */
    public static Date getBeforeSeconds(int second){
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date());
    	c.add(Calendar.SECOND, -second);
    	return c.getTime();
    }
    
    /**
     * 获取日期所在周的第一天
     * @param date
     * @return
     * @author 十一城城主
     * @version V1.0
     */
	public static Date getStartDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
		return c.getTime();
    }
	
	/**
	 * 获取日期所在周的最后一天
	 * @param date
	 * @return
	 * @author 十一城城主
	 * @version V1.0
	 */
	public static Date getEndDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		c.add(Calendar.WEEK_OF_YEAR, 1);//增加一个星期，才是我们中国人理解的本周日的日期
		return c.getTime();
    }
	
	 
    /**
     * 获取当前日期所在月的第一天
     * @param date
     * @return
     * @author 十一城城主
     * @version V1.0
     */
	public static Date getStartDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
    }
	
	/**
	 * 获取日期所在月的最后一天
	 * @param date
	 * @return
	 * @author 十一城城主
	 * @version V1.0
	 */
	public static Date getEndDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
    }
	
	public static void main(String[] args) throws ParseException{

		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");

		Date date = fmt.parse("2015-05-15");

		System.out.println(date);
	}

}
