package testWeb.servlet;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import testWeb.vo.*;
import testWeb.dao.userDAO;
import testWeb.dao.impl.*;

public class UserLoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		UserInfo userinfo=new UserInfo();
		userinfo.setUsername(req.getParameter("username"));
		userinfo.setPassword(req.getParameter("password"));
		userDAO dao=new UserDAOImpl();
		int flag=0;
		try {
			flag=dao.queryByUserInfo(userinfo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(flag==1) {
			HttpSession session=req.getSession();
			session.setAttribute("username", userinfo.getUsername());
			res.sendRedirect("./welcome.jsp");
		}
		else {
			res.sendRedirect("./error.jsp");
		}
	}
}
