package kr.co.trinity.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	private static HashMap<String, Controller> mapper =
	                     new HashMap<String, Controller>();
	//parsing
	//properties파일 load ->key list검색 -> key와 매핑된 value얻고 ->class이름인 value를
	//Controller객체로 생성 -> hashmap에 저장
	public static void mapping(String fileName){
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(fileName));
			Set keyList = props.keySet();
			Iterator<String> iterator = keyList.iterator();
			while(iterator.hasNext()){
				String key=iterator.next();
				Controller c=
				(Controller)Class.forName(props.getProperty(key)).newInstance();
				mapper.put(key, c);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
	    } catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static Controller getAction(String action){
		 return mapper.get(action);
	}
}











