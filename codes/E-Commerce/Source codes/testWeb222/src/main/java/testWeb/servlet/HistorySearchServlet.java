package testWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import testWeb.dao.*;
import testWeb.dao.impl.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import testWeb.vo.HistoryRecord;
import testWeb.vo.UserInfo;

public class HistorySearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		
		HttpSession session = req.getSession();
		UserInfo user=new UserInfo();
		PrintWriter out = res.getWriter();
		user.setUsername((String) session.getAttribute("username"));
		HistorySearchDAO dao=new HistorySearchDAOImpl();
		if(dao.UserSearch(user)==1) {
			session.setAttribute("historylist", dao.HistorySearch(user));
			res.sendRedirect("./historysearchresult.jsp");
		}
		else {
			out.println("发生错误");
		}
		//session.setAttribute("historylist", dao.HistorySearch());
		//res.sendRedirect("./historysearchresult.jsp");
	}
}
