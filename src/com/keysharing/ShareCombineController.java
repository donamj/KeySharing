/*
 * ShareGenerateControlelr is the servlet that handles the key regeneration operation
 * It get the data from form and invokes the appropriate function
 */
package com.keysharing;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShareCombineController
 */
public class ShareCombineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareCombineController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Getting the data from the form
		int level = Integer.parseInt(request.getParameter("level"));
		int share = Integer.parseInt(request.getParameter("share"));
		String prime = request.getParameter("prime");
		String shares = request.getParameter("shares");
		ShareCombine obj = new ShareCombine();
		//Assigning the values to the ShareCombine class instance
		obj.level = level;
		obj.n = share;
		obj.primeNo =new BigInteger(prime);
		//Splits the data from the text box to share and id
		String[] split_line = shares.split("\n");
		Share arr[] = new Share[split_line.length];
		String[] str = new String[2];
		int x;
		String s;
		BigInteger b;
		for (int i=0; i<split_line.length; i++)
		{
			str = split_line[i].split(" ");
			x = Integer.parseInt(str[0]);
			s = str[1].trim();
			b = new BigInteger(s);
			arr[i]= new Share(x,b);
		}
		
		obj.shares = arr;
		//Invokes function to regenrate the key
		obj.combineShare();
		//Presenting the output to user
		PrintWriter out = response.getWriter();
		if (obj.password == null)
			out.print("<center><h1>Not enough shares or wrong input!!!</h1>");
		else
			out.print("<center><h1>The key is : <br>" + obj.password + "<h1><br>");
		
		out.print("<h3><br><br><br>	<a href=index.jsp>RETURN HOME</a><br>	</h3><br></center>");
		
	}

}
