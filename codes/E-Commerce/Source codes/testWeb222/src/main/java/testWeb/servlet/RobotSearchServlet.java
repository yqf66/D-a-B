package testWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import testWeb.dao.*;
import testWeb.dao.impl.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import testWeb.vo.*;

public class RobotSearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		/*UserInfo user=new UserInfo();
		Exploration e=new Exploration();
		HttpSession session = req.getSession();
        user.setUsername(((String) session.getAttribute("username")));
		PrintWriter out = res.getWriter();
		RobotSearchDAO dao=new RobotSearchDAOImpl();
		if(dao.RobotSearch(e, user)==1) {*/
			/*out.println("Username: " + user.getUsername());
            out.println("Robotname: " + user.getRobotname());
            out.println("Timestamp: " + e.getTimestamp());
            out.println("Statistic_of_treasure:"+e.getStatistic_of_treasure());*/
			/*req.setAttribute("username", user.getUsername());
			req.setAttribute("robotname", user.getRobotname());
			req.setAttribute("timestamp", e.getTimestamp());
			req.setAttribute("treasureStatistic", e.getStatistic_of_treasure());
			req.getRequestDispatcher("RobotSearchResult.jsp").forward(req, res);
		}
		else if(dao.RobotSearch(e, user)==2) {
			out.println("在exploration表中未找到相应robotname");
		}
		else {
			out.println("在userinfo表中未找到相应username");
		}*/
		HttpSession session = req.getSession();
		UserInfo user=new UserInfo();
		user.setUsername(((String) session.getAttribute("username")));
		PrintWriter out = res.getWriter();
		RobotSearchDAO dao=new RobotSearchDAOImpl();
		if(dao.UserSearch(user)==1) {
			session.setAttribute("ExplorationList", dao.RobotSearch(user));
			res.sendRedirect("./RobotSearchResult.jsp");
		}
		else {
			out.println("发生错误");
		}
	}
}
