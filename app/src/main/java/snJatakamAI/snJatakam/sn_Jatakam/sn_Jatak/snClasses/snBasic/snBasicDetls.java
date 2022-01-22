
/*--------------------------------------------------------*/
//package snJatakam;
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic;
/*--------------------------------------------------------*/
import java.io.*;
import java.util.StringTokenizer;
/*--------------------------------------------------------*/
public class snBasicDetls {
   int maxRows = 500;
   int recNo = 0;
   public String[][] token = new String[maxRows][30];
   public int loadBasicDetails(String inpFile) {
     FileInputStream fileStream = null;
     BufferedInputStream buffStream = null;
     LineNumberInputStream lineStream = null;
     DataInputStream dataStream = null;
     String line, str;
     char ch = ' ';
     int i;
     try{
       fileStream = new FileInputStream( inpFile );
       buffStream = new BufferedInputStream(fileStream);
       lineStream = new LineNumberInputStream(buffStream);
       dataStream = new DataInputStream(lineStream);
       while ((line = dataStream.readLine()) != null) {
         int lineNo = lineStream.getLineNumber();
         line = line.trim();
         if (line.length() > 0) {
           if (line.charAt(0) != '#') {
             StringTokenizer st = new StringTokenizer(line,"/:|\n");
             //System.out.print(lineNo + " " + line);
             //System.out.println(" No of tokens = "+st.countTokens());
             for (i=0; st.hasMoreTokens(); i++) {
                                     //i < st.countTokens(); i++) {
               str = st.nextToken();
               token[recNo][i] = new String(str);
               //System.out.print("["+token[recNo][i]+"]");
             }
             //System.out.println();
             recNo++;
           }
         }
       }
     } catch (Exception ioErr) {
       System.out.println(ioErr.toString() );
       System.exit(100);
     }
     finally {
       try { dataStream.close(); } catch (Exception ignored) {}
     }
     return (recNo);
   }
   public int noofRecs() {
     return (recNo);
   }
   public int noofTokens(int nRec) {
     return (token[nRec].length);
   }
}
/*-------------------------- For Horoscope -----------------------*/
