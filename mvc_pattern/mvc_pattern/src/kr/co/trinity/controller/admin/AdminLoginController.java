package kr.co.trinity.controller.admin;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import kr.co.trinity.controller.Controller;
import kr.co.trinity.vo.Board;


/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController implements Controller {
	
	NodeList nodes = null;
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		////////// 결과 리턴 변수
		ArrayList<String> AdminList = new ArrayList<String>();
		
		
		////////// 아이디 패스워드 변수
		String id = request.getParameter("adminid");
		String password = request.getParameter("adminpassword");
		String nextPage=null;
		
		// xml 문서 검색.
		String dir = request.getSession().getServletContext().getRealPath("xml/data.xml");
		File d = new File(dir);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xPath = factory.newXPath();
		InputSource inputSource = new InputSource(new FileInputStream(d));
		String expression = "/employees/employee[loginID/text()='" + id + "' and passwd/text()='" + password
				+ "']";

		// 노드 검색.
		nodes = (NodeList) xPath.evaluate(expression, inputSource, XPathConstants.NODESET);
		
		if (nodes.getLength() == 1)
		{
			Node node = nodes.item(0);
			String[] arrTokens = node.getTextContent().split("[\\t\\s\\n]+");
			
			AdminList.add(arrTokens[1]);
			AdminList.add(arrTokens[2]);
			nextPage = "index.jsp?content=administrator/adminlist.jsp";
		}
		
		else if (nodes.getLength() > 1)
		{
			for (int i = 0; i < nodes.getLength(); i++)
			{
				Node node = nodes.item(i);
				String[] arrTokens = node.getTextContent().split("[\\t\\s\\n]+");
				
				AdminList.add(arrTokens[1]);
				AdminList.add(arrTokens[2]);
			}
			
			nextPage = "index.jsp?content=administrator/adminlist.jsp";
		}
		
		else
		{
			nextPage = "index.jsp?content=administrator/administrator.jsp";
		}

		request.setAttribute("AdminList", AdminList);
		
		// 페이지 이동. AdminList 출력하도록... 테스트용
		return nextPage;
	}

}
