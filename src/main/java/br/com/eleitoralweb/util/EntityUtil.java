package br.com.eleitoralweb.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.eleitoralweb.bean.Combo;
import br.com.eleitoralweb.exceptions.DAOException;

public class EntityUtil {
	public static <E> Object getId(Class<?> clazz, E bean){
		if(bean == null || bean.getClass().equals(Object.class)) return null;
		if(clazz.isAnnotationPresent(Entity.class)){
			    for (Field field : clazz.getDeclaredFields()) {
					if(field.isAnnotationPresent(Id.class)){
						try {
							field.setAccessible(true);
							return field.get(bean);
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		}
		return getId(bean.getClass().getSuperclass(),bean);
	}
	
	public static <T, V> List<Combo<V>> retrieveCombo(List<T> lista,String idField, String valueField) throws DAOException{
		List<Combo<V>> comboList = new ArrayList<Combo<V>>();
		if(lista != null && !lista.isEmpty()){
			Class<?> clazz = null; 
			Combo<V> itemCombo;
			clazz = lista.get(0).getClass();
			Field idFieldObj = null;
			Field valueFieldObj = null;
			try {
				idFieldObj = clazz.getDeclaredField(idField);
				valueFieldObj = clazz.getDeclaredField(valueField);
				idFieldObj.setAccessible(true);
				valueFieldObj.setAccessible(true);
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(idFieldObj != null && valueFieldObj != null){
				for (T t : lista) {
					try {
						itemCombo = new Combo<V>((V)idFieldObj.get(t), valueFieldObj.get(t).toString());
						comboList.add(itemCombo);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return comboList;
	}
	/**
	 * Retorna um Hashmap com os atributos não nulos de um objeto
	 * @param clazz
	 * @param obj
	 * @param fieldName
	 * @param params
	 * @return
	 */
	public static <T, V> Map<String, Object> loadParams(T obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		loadParams(obj.getClass(), obj, null, map);
		return map;
	}
	private <T> Object loadParams(Class<?> clazz, T obj,
								  String fieldName, Map<String, Object> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		Object id = null;

		if (clazz.getSuperclass() != null) {
			id = loadParams(clazz.getSuperclass() , obj, fieldName, map);
		}
		if(clazz.getAnnotation(Entity.class) != null){
			Object o = null;
			Boolean fieldAnottation = Boolean.FALSE;
			for (Field field : clazz.getDeclaredFields()) {
				String f = fieldName != null ? fieldName.concat(UNDERSCORE).concat(field.getName()):field.getName();
				fieldAnottation = (field.getAnnotation(Column.class) != null
						|| field.getAnnotation(JoinColumn.class) != null)
						|| (field.getAnnotation(Transient.class) != null && specificConditions.containsKey(f));
				if(field.getAnnotation(Id.class) != null){
					id = ReflectionsUtil.getValue(obj, field);
					if(id != null && field.getType().isPrimitive() && "0".equals(id.toString())) {
						id = null;
						fieldAnottation = Boolean.FALSE;
					}
					if(specificConditions != null && specificConditions.containsKey(f)){
						id = null;
					}
				}

				if(!fieldAnottation){
					Method meth = ReflectionsUtil.getMethodGet(clazz, field.getName());
					if(meth != null){
						fieldAnottation = (meth.getAnnotation(Column.class) != null
								|| meth.getAnnotation(JoinColumn.class) != null);
						if(meth.getAnnotation(Id.class) != null){
							id = ReflectionsUtil.invokeMethod(meth, obj);
							if(id != null && meth.getReturnType().isPrimitive() && "0".equals(id.toString())) {
								id = null;
								fieldAnottation = Boolean.FALSE;
							}
							if(specificConditions != null && specificConditions.containsKey(f)){
								id = null;
							}
						}
					}
				}
				if (fieldAnottation) {
					field.setAccessible(Boolean.TRUE);
					try {
						o = field.get(obj);
						if (o != null) {
							if(field.getType().getAnnotation(Entity.class) != null){
								Object idField = loadParams(o.getClass(), o, f, map);
								if(idField != null &&  (ignoreFields == null || ignoreFields.isEmpty()
										|| !ignoreFields.contains(f))){
									map.put(f, o);
								}
							}else{
								if(ignoreFields == null || ignoreFields.isEmpty()
										|| !ignoreFields.contains(f)){
									map.put(f, o);
								}
							}
						}
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(id == null) {
				params.putAll(map);
			}
		}
		return id;
	}
	
}