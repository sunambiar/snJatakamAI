/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Locale;

/**
 * For redirecting snPrintWriter
 *
 * @author sureshnambiar
 */
public class snPrintWriter {

  private PrintWriter pW = null;
  private boolean printWriterEnabled = true;

  public snPrintWriter() {
    pW = new PrintWriter(System.out);
  }

  public snPrintWriter(Writer writer) {
    pW = new PrintWriter(writer);
  }

  public snPrintWriter(PrintStream ps) {
    pW = new PrintWriter(ps);
  }

  public snPrintWriter(FileOutputStream fos) {
    pW = new PrintWriter(fos);
  }

  public snPrintWriter(Writer writer, boolean bln) {
    pW = new PrintWriter(writer, bln);
  }

  public static void enable(snPrintWriter... sPWs) {
    for (snPrintWriter spw : sPWs) {
      spw.enablePrintWriter();
    }
  }

  public static void disable(snPrintWriter... sPWs) {
    for (snPrintWriter spw : sPWs) {
      spw.disablePrintWriter();
    }
  }

  public void enablePrintWriter() {
    this.printWriterEnabled = true;
  }

  public void disablePrintWriter() {
    this.printWriterEnabled = false;
  }

  public void print(Object obj) {
    if (this.printWriterEnabled) {
      pW.print(obj);
    }
  }

  public void print(String s) {
    if (this.printWriterEnabled) {
      pW.print(s);
    }
  }

  public void print(boolean b) {
    if (this.printWriterEnabled) {
      pW.print(b);
    }
  }

  public void print(char c) {
    if (this.printWriterEnabled) {
      pW.print(c);
    }
  }

  public void print(char[] s) {
    if (this.printWriterEnabled) {
      pW.print(s);
    }
  }

  public void print(double d) {
    if (this.printWriterEnabled) {
      pW.print(d);
    }
  }

  public void print(float f) {
    if (this.printWriterEnabled) {
      pW.print(f);
    }
  }

  public void print(int i) {
    if (this.printWriterEnabled) {
      pW.print(i);
    }
  }

  public void print(long l) {
    if (this.printWriterEnabled) {
      pW.print(l);
    }
  }

  public PrintWriter printf(String format, Object... args) {
    if (this.printWriterEnabled) {
      return pW.printf(format, args);
    }
    return pW.printf("");
  }

  public PrintWriter printf(Locale l, String format, Object... args) {
    if (this.printWriterEnabled) {
      return pW.printf(l, format, args);
    }
    return pW.printf(l, "");
  }

  public void println() {
    if (this.printWriterEnabled) {
      pW.println();
    }
  }

  public void println(Object obj) {
    if (this.printWriterEnabled) {
      pW.println(obj);
    }
  }

  public void println(String s) {
    if (this.printWriterEnabled) {
      pW.println(s);
    }
  }

  public void println(boolean b) {
    if (this.printWriterEnabled) {
      pW.println(b);
    }
  }

  public void println(char c) {
    if (this.printWriterEnabled) {
      pW.println(c);
    }
  }

  public void println(char[] s) {
    if (this.printWriterEnabled) {
      pW.println(s);
    }
  }

  public void println(double d) {
    if (this.printWriterEnabled) {
      pW.println(d);
    }
  }

  public void println(float f) {
    if (this.printWriterEnabled) {
      pW.println(f);
    }
  }

  public void println(int i) {
    if (this.printWriterEnabled) {
      pW.println(i);
    }
  }

  public void println(long l) {
    if (this.printWriterEnabled) {
      pW.println(l);
    }
  }

  public PrintWriter append(CharSequence csq) {
    if (this.printWriterEnabled) {
      pW.append(csq);
    }
    return pW.append("");
  }

  public PrintWriter append(char c) {
    if (this.printWriterEnabled) {
      pW.append(c);
    }
    return pW.append("");
  }

  public PrintWriter append(CharSequence csq, int start, int end) {
    if (this.printWriterEnabled) {
      pW.append(csq, start, end);
    }
    return pW.append("");
  }

  public void close() {
    pW.close();
  }

  public boolean checkError() {
    return pW.checkError();
  }

  public void flush() {
    pW.flush();
  }

}
