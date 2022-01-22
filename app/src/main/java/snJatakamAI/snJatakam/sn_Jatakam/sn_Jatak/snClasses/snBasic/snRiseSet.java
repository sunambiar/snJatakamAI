
/*--------------------------------------------------------*/
/*               Suresh's  Jatakam - classes              */
/*--------------------------------------------------------*/
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic;
/*--------------------------------------------------------*/
public class snRiseSet {
  static final double PI = 3.1415926535897932384626433832795d;
  static final double radians = PI / 180.0;
  static final double degrees = 180.0 / PI;
  /*------------------------------------------------------------------*/
  private static double range360(double x) {
    long xy;
    xy = (long)(x / 360.0);
    return (x - xy * 360.0);
  }
  /*------------------------------------------------------------------*/
  public static double snRiseSet (double day, double glat,
     			double glong, int index, double altitude) {
	//------------- index indicates whether Rise = 1 or Set = 2 ------------
    double sinalt, gha, lambda, delta, t, c, days, utold, utnew;
    double sinphi, cosphi, L, G, E, obl, signt, act;
    // Altitude values are : Astronomical)-18.0);
    // Nautical(-12.0)		Civil (-6.0)		Sun (-0.833)
    if (altitude == 0.0) altitude = -0.833;
    utold = 180.0;  // initial value finds first position @12h UT on day
    utnew = 0.0;
    sinalt = Math.sin(altitude * radians);
    sinphi = Math.sin(glat * radians);
    cosphi = Math.cos(glat * radians);
    signt = (index == 1 ? 1.0 : -1.0);
    while (Math.abs(utold - utnew) > 0.1) {
      utold = utnew;
      days = day + utold / 360.0; // Update args of Sun's position
      t = days / 36525;
      // Find Sun's co-ordinates
      L = range360(280.46 + 36000.77 * t);
      G = 357.528 + 35999.05 * t;
      G *= radians;
      lambda = L + 1.915 * Math.sin(G) +
                   0.02 * Math.sin(2 * G);
      lambda *= radians;
      E = -1.915 * Math.sin(G) - 0.02 * Math.sin(2*G)
              + 2.466 * Math.sin(2*lambda) - 0.053 * Math.sin(4*lambda);
      obl = 23.4393 - 0.13 * t;
      //System.out.println("Obliquity===>"+DMS.dms(obl));
      obl *= radians;
      // Update the hour angle and declination of sun
      gha = utold - 180.0 + E;
      delta = Math.asin(Math.sin(obl) * Math.sin(lambda));
      // Calculate correction term for this loop
      c = (sinalt - sinphi * Math.sin(delta)) / (cosphi * Math.cos(delta));
      act = Math.acos(c);
      act *= degrees;
      //System.out.println("Act = " + DMS.dms(act));
      if (c > 1) act = 0.0;
      if (c < -1) act = 180.0;
      // Find the newly corrected ut for sunrise/set
      utnew = range360(utold - (gha + glong + signt * act));
      //System.out.println("UTnew = " + utnew + " UT Old = " + utold+ " sign = "+signt);
    }
    return (utnew / 15.0);
  }
  /*------------------------------------------------------------------*/
}
/*-------------------------- For Horoscope -----------------------*/
