package com.hkesports.matchticker.repository.custom;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;

public class BasicDaoImpl {
	
	protected void addScalars(Class<?> clazz, SQLQuery queryObj, String... fieldNames) {
		if(clazz==null || queryObj==null) {
			return;
		}
		if(fieldNames==null || fieldNames.length ==0) {
			addScalarByClass(clazz, queryObj);
		} else {
			addScalarByNames(clazz, queryObj, fieldNames);
		}
	}
	
	protected void addScalarsBoth(Class<?> clazz, SQLQuery queryObj, String... fieldNames) {
		if(clazz==null || queryObj==null) {
			return;
		}
		addScalarByClass(clazz, queryObj);
		addScalarByNames(clazz, queryObj, fieldNames);
	}
	
	
	/**
	 * 直接取得傳入之class的所有field來 add scalar
	 * **此方式將"略過" transient、final、static 欄位
	 * @param clazz
	 * @param queryObj
	 * @param fieldNames
	 */
	protected void addScalarByClass(Class<?> clazz, SQLQuery queryObj) {
		if(clazz==null || queryObj==null) {
			return;
		}
		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields) {
			addScalar(field, queryObj, true);
		}
		if(clazz.getSuperclass()!=null) {
			addScalarByClass(clazz.getSuperclass(), queryObj);
		}
	}
	
	/**
	 * 使用Field name來set scalar 
	 * **此方式將"不略過" transient、final、static 欄位
	 * @param clazz
	 * @param queryObj
	 * @param fieldNames
	 */
	protected void addScalarByNames(Class<?> clazz, SQLQuery queryObj, String... fieldNames) {
		if(clazz==null || queryObj==null) {
			return;
		}
		if(fieldNames==null || fieldNames.length == 0) {
			return;
		}
		for(String fieldName:fieldNames) {
			try {
				addScalar(clazz.getDeclaredField(fieldName), queryObj, false);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		if(clazz.getSuperclass()!=null) {
			addScalarByNames(clazz.getSuperclass(), queryObj, fieldNames);
		}
	}
	
	private void addScalar(Field field, SQLQuery queryObj, boolean ignore) {
		if(ignore && Modifier.isTransient(field.getModifiers())) {
			//ingore transient field
			return;
		} else if(ignore && Modifier.isFinal(field.getModifiers())) {
			//ingore final field
			return;
		} else if(ignore && Modifier.isStatic(field.getModifiers())) {
			//ingore static field
			return;
		}
		
		Class<?> fieldType = field.getType();
		if(fieldType == String.class) {
			queryObj.addScalar(field.getName(), StringType.INSTANCE);
		} else if(fieldType == Integer.class || fieldType.getName().equals("int")) {
			queryObj.addScalar(field.getName(), IntegerType.INSTANCE);
		} else if(fieldType == Long.class || fieldType.getName().equals("long")) {
			queryObj.addScalar(field.getName(), LongType.INSTANCE);
		} else if(fieldType == Date.class || fieldType == java.sql.Date.class) {
			queryObj.addScalar(field.getName(), DateType.INSTANCE);
		} else if(fieldType == Short.class || fieldType.getName().equals("short")) {
			queryObj.addScalar(field.getName(), ShortType.INSTANCE);
		} else if(fieldType == Double.class || fieldType.getName().equals("double")) {
			queryObj.addScalar(field.getName(), DoubleType.INSTANCE);
		} else if(fieldType == Float.class || fieldType.getName().equals("float")) {
			queryObj.addScalar(field.getName(), FloatType.INSTANCE);
		} 
	}
}
