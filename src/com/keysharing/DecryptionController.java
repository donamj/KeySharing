/*
 * This is the Servlet that controls decryption operation
 * It gets data from the user interface i.e. html form and passes the data to Decryption class
 * It also presents the result obtained to the user
 */
package com.keysharing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DecryptionController
 */
public class DecryptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecryptionController() {
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
		String key = request.getParameter("key");
		String ciphertext = request.getParameter("ciphertext");
		Decryption obj = new Decryption();
		//Assigning the values to the Decryption class instance
		obj.setCiphertext(ciphertext);
		obj.setPassword(key);
		//Invoking decrypt funciton
		try {
			obj.decrypt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		//Handling error condition
		if(obj.getPlaintext() == null)
			out.print("<center><h1>Wrong key or information!!!</h1>"); 
		else
			// Presenting output i.e. the decrpted text to user
			out.print("<center><h1>Plain text :<br>"+obj.getPlaintext()+"</h1>"); 
		out.print("<h3><br><br><br>	<a href=index.jsp>RETURN HOME</a><br>	</h3><br></center>");
		
	}

}
