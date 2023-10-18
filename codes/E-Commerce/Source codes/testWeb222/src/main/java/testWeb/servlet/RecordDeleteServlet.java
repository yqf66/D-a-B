package testWeb.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import testWeb.dao.HistoryRecordDAO;
import testWeb.dao.impl.HistoryRecordDAOImpl;
import testWeb.vo.HistoryRecord;

public class RecordDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		int flag = 0;
		HistoryRecord record = new HistoryRecord();
		record.setHistoryRecordID(Integer.parseInt(req.getParameter("historyRecordID")));
		HistoryRecordDAO dao = new HistoryRecordDAOImpl();
		
		  try {
				flag = dao.selectID(record);
				if(flag == 1) {
					dao.deleteRecord(record);
					//req.setAttribute("deletemessage", "Success Delete");
					res.sendRedirect("./DeleteSuccess.jsp");
				}else {
					//req.setAttribute("nodeletemessage", "The record doesn't exist");
					res.sendRedirect("./DeleteError.jsp");
				}
				//RequestDispatcher dispatcher = req.getRequestDispatcher("module.jsp");
			    //dispatcher.forward(req, res);
//				res.sendRedirect("explorationRecord.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}