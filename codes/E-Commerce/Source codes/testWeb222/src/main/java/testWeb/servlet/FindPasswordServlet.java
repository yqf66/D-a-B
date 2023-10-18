package testWeb.servlet;

import java.io.*;
import testWeb.dao.*;
import testWeb.dao.impl.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import testWeb.vo.UserInfo;

public class FindPasswordServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		UserInfo user=new UserInfo();
		user.setUsername(req.getParameter("username"));
		user.setNewpassword(req.getParameter("newpassword"));
		FindPasswordDAO dao=new FindPasswordDAOImpl();
		PrintWriter out = res.getWriter();
		if(dao.FindPassword(user)==1) {
			res.sendRedirect("./Find_password_success.jsp");
		}else {
			res.sendRedirect("./Invalid-username.jsp");
		}
	}
}