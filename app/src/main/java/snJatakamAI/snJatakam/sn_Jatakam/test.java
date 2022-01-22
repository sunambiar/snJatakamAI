//import java.io.*;
import java.io.DataInputStream;
//import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.text.DecimalFormat;
//import java.util.*;
//import java.lang.*;

import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snVarsJ;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snExchange;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.*;

public class test {
  public static void main (String args[]) {
    snVarsJ J = new snVarsJ();
    snExchange.insertDirName("abc/hello",J.drvName,"surtest/my/my1/my2");
  }
}
