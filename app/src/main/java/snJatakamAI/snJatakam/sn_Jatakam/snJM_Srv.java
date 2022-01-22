package snJatakamAI.snJatakam.sn_Jatakam;

/*-------------------- snJatak Servlet--------*/
//import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snIOglobalSetting;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snPrintWriter;

//import java.util.*;
//import java.sql.*;
/*------------------------------------------------------*/
public class snJM_Srv extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
      //throws ServletException, IOException {
      throws IOException {
    String ArgsG[], ArgsB[];   // = new String[nArgs];
    double snPoruthaCutOff = 0.0;
    String[] args = new String[30];
    String ayanamsa, ayan_d, ayan_m, ayan_s;
    int argc;

    try {
      res.setContentType("text/html");
      snPrintWriter pI = new snPrintWriter(res.getWriter());
      snPrintWriter pM = new snPrintWriter(res.getWriter());
      snPrintWriter pS = new snPrintWriter(res.getWriter());
      snPrintWriter pP = new snPrintWriter(res.getWriter());
      if (snIOglobalSetting.getPrintWriterOn()) {
        snPrintWriter.enable(pI, pM, pS, pP);
      } else {
        snPrintWriter.disable(pI, pM, pS, pP);
      }

      ayanamsa = new String(req.getParameter("ayan"));
      ayan_d = req.getParameter("ayd");
      ayan_m = req.getParameter("aym");
      ayan_s = req.getParameter("ays");

      argc = 0;
      args[argc++] = "VH";
      args[argc++] = req.getParameter("nmG");
      args[argc++] = req.getParameter("sexG");
      args[argc++] = req.getParameter("ddG");
      args[argc++] = req.getParameter("mmG");
      args[argc++] = req.getParameter("yyG");
      args[argc++] = req.getParameter("hhG");
      args[argc++] = req.getParameter("mtG");
      args[argc++] = req.getParameter("ssG");
      args[argc++] = req.getParameter("tmZG");
      args[argc++] = req.getParameter("placeG");
      args[argc++] = req.getParameter("ltdG");
      args[argc++] = req.getParameter("ltmG");
      //args[argc++] = req.getParameter("ltsG");
      args[argc++] = req.getParameter("nsG");
      args[argc++] = req.getParameter("lgdG");
      args[argc++] = req.getParameter("lgmG");
      //args[argc++] = req.getParameter("lgsG");
      args[argc++] = req.getParameter("ewG");
      args[argc++] = req.getParameter("summdetlG");

      args[argc++] = ayanamsa;
      //if (Integer.parseInt(ayanamsa.trim()) == 3) {
      args[argc++] = ayan_d;
      args[argc++] = ayan_m;
      args[argc++] = ayan_s;

      ArgsG = new String[argc];
      System.arraycopy(args, 0, ArgsG, 0, argc);

      argc = 0;
      args[argc++] = "VH";
      args[argc++] = req.getParameter("nmB");
      args[argc++] = req.getParameter("sexB");
      args[argc++] = req.getParameter("ddB");
      args[argc++] = req.getParameter("mmB");
      args[argc++] = req.getParameter("yyB");
      args[argc++] = req.getParameter("hhB");
      args[argc++] = req.getParameter("mtB");
      args[argc++] = req.getParameter("ssB");
      args[argc++] = req.getParameter("tmZB");
      args[argc++] = req.getParameter("placeB");
      args[argc++] = req.getParameter("ltdB");
      args[argc++] = req.getParameter("ltmB");
      //args[argc++] = req.getParameter("ltsB");
      args[argc++] = req.getParameter("nsB");
      args[argc++] = req.getParameter("lgdB");
      args[argc++] = req.getParameter("lgmB");
      //args[argc++] = req.getParameter("lgsB");
      args[argc++] = req.getParameter("ewB");
      args[argc++] = req.getParameter("summdetlB");

      args[argc++] = ayanamsa;
      //if (Integer.parseInt(ayanamsa.trim()) == 3) {
      args[argc++] = ayan_d;
      args[argc++] = ayan_m;
      args[argc++] = ayan_s;

      ArgsB = new String[argc];
      System.arraycopy(args, 0, ArgsB, 0, argc);
      snPoruthaCutOff = Double.parseDouble(req.getParameter("pcutoff"));

      snMatch snM = new snMatch(pP, pS, pM, pI, "VH", ArgsB, ArgsG, 1, snPoruthaCutOff);

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
/*--------------------------------------------------------*/
