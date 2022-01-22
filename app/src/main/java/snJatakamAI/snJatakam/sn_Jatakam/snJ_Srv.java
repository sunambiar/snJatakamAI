
package snJatakamAI.snJatakam.sn_Jatakam;

/*-------------------- snJatak Servlet--------*/
//package snJatak;
/*--------------------------------------------*/
//import javax.servlet.*;
import javax.servlet.http.*;
//import java.util.*;
import java.io.*;
//import java.sql.*;
/*------------------------------------------------------*/
public class snJ_Srv extends HttpServlet {
    //public void doGet (HttpServletRequest req, HttpServletResponse res)

    public void service(HttpServletRequest req, HttpServletResponse res)
            //throws ServletException, IOException {
            throws IOException {
        String[] args = new String[30];
        snJatak snB = null;
        String ayanamsa;
        int argc;
        try {
            res.setContentType("text/html");
            PrintWriter pW = res.getWriter();
            argc = 0;

            args[argc++] = "VH";
            args[argc++] = req.getParameter("nm");
            args[argc++] = req.getParameter("sex");
            args[argc++] = req.getParameter("dd");
            args[argc++] = req.getParameter("mm");
            args[argc++] = req.getParameter("yy");
            args[argc++] = req.getParameter("hh");
            args[argc++] = req.getParameter("mt");
            args[argc++] = req.getParameter("ss");
            args[argc++] = req.getParameter("tmZ");
            args[argc++] = req.getParameter("place");
            args[argc++] = req.getParameter("ltd");
            args[argc++] = req.getParameter("ltm");
            //args[argc++] = req.getParameter("lts");
            args[argc++] = req.getParameter("ns");
            args[argc++] = req.getParameter("lgd");
            args[argc++] = req.getParameter("lgm");
            //args[argc++] = req.getParameter("lgs");
            args[argc++] = req.getParameter("ew");
            args[argc++] = req.getParameter("summdetl");
            ayanamsa = new String(req.getParameter("ayan"));
            args[argc++] = ayanamsa;
            //if (Integer.parseInt(ayanamsa.trim()) == 3) {
            args[argc++] = req.getParameter("ayd");
            args[argc++] = req.getParameter("aym");
            args[argc++] = req.getParameter("ays");

            snB = new snJatak(pW, args);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/*--------------------------------------------------------*/
