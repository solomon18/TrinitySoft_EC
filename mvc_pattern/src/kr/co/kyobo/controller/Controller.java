package kr.co.kyobo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public abstract String handleRequest(HttpServletRequest request, 
			HttpServletResponse response)throws  Exception ;

}
