package com.hkesports.matchticker.repository.custom;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.type.BigIntegerType;
import org.hibernate.type.BooleanType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;
import org.springframework.util.CollectionUtils;

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
	
	protected void addScalarsExclude(Class<?> clazz, SQLQuery queryObj, String... fieldNames) {
		if(clazz==null || queryObj==null) {
			return;
		}
		addScalarByClass(clazz, queryObj, fieldNames);
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
	 * @param excludeFields
	 */
	protected void addScalarByClass(Class<?> clazz, SQLQuery queryObj, String... excludeFields) {
		if(clazz==null || queryObj==null) {
			return;
		}
		List<String> excludeList = null;
		if(excludeFields != null && excludeFields.length > 0) {
			excludeList = Arrays.asList(excludeFields);
		}
		
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			if(CollectionUtils.isEmpty(excludeList) || !excludeList.contains(field.getName())) {
				addScalar(field, queryObj, true);
			}
		}
		if(clazz.getSuperclass()!=null) {
			addScalarByClass(clazz.getSuperclass(), queryObj, excludeFields);
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
		} else if(fieldType == BigInteger.class) {
			queryObj.addScalar(field.getName(), BigIntegerType.INSTANCE);
		} else if(fieldType == Date.class || fieldType == java.sql.Date.class) {
			queryObj.addScalar(field.getName(), TimestampType.INSTANCE);
		} else if(fieldType == Short.class || fieldType.getName().equals("short")) {
			queryObj.addScalar(field.getName(), ShortType.INSTANCE);
		} else if(fieldType == Double.class || fieldType.getName().equals("double")) {
			queryObj.addScalar(field.getName(), DoubleType.INSTANCE);
		} else if(fieldType == Float.class || fieldType.getName().equals("float")) {
			queryObj.addScalar(field.getName(), FloatType.INSTANCE);
		} else if(fieldType == Boolean.class || fieldType.getName().equals("boolean")) {
			queryObj.addScalar(field.getName(), BooleanType.INSTANCE);
		}
	}
}
