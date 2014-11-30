/*license*\
   XBN-Java: Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.util;
   import  java.util.Date;
/**
   <p>Date arithmetic.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class DateUtil   {
   private DateUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <p>Number of milliseconds in a second.</p>

      <!-- MAIN VARIABLE -->

      <p>Equal to
      <br/> &nbsp; &nbsp; {@code 1000}</p>

      @see  #MILLS_IN_MINUTE
      @see  #MILLS_IN_HOUR MILLS_IN_HOUR
      @see  #MILLS_IN_DAY
      @see  #MILLS_IN_WEEK
    **/
   public static final int MILLS_IN_SECOND = 1000;
   /**
      <p>Number of milliseconds in a minute.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>({@link #MILLS_IN_SECOND MILLS_IN_SECOND} * 60)</code></p>
    **/
   public static final int MILLS_IN_MINUTE = MILLS_IN_SECOND * 60;
   /**
      <p>Number of milliseconds in a hour.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>({@link #MILLS_IN_MINUTE MILLS_IN_MINUTE} * 60)</code></p>
    **/
   public static final int MILLS_IN_HOUR = MILLS_IN_MINUTE * 60;
   /**
      <p>Number of milliseconds in a day.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>({@link #MILLS_IN_HOUR MILLS_IN_HOUR} * 24)</code></p>
    **/
   public static final int MILLS_IN_DAY = MILLS_IN_HOUR * 24;
   /**
      <p>Number of milliseconds in a week.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>({@link #MILLS_IN_DAY MILLS_IN_DAY} * 7)</code></p>
    **/
   public static final int MILLS_IN_WEEK = MILLS_IN_DAY * 7;

   /**
      <p>Get a Date that is X units before the provided date.</p>

      @param  multiplier  The number used to translate a Date's milleseconds to some other unit. May not be zero.
      @param  units_ago  The number of "units ago" you want the returned date to be, in relation to from.
      @param  from  The date that you want to count back from. May not be {@code null}.

      @return  {@code new Date(from.getTime() - (units_ago / multiplier))}

      @see
         <li>{@link #getDateXBeforeNow(long, int) getDateXBeforeNow(l,i)}, {@link #getDateXBNSeconds(int) getDateXBNSeconds(i)}, {@link #getDateXBNMinutes(int) getDateXBNMinutes(i)}, {@link #getDateXBNHours(int) getDateXBNHours(i)}, {@link #getDateXBNDays(int) getDateXBNDays(i)}, {@link #getDateXBNWeeks(int) getDateXBNWeeks(i)}</li>
         <li>{@link #getDateXSecondsAgo(int, Date) getDateXSecondsAgo(i,dt)}, {@link #getDateXMinutesAgo(int, Date) getDateXMinutesAgo(i,dt)}, {@link #getDateXHoursAgo(int, Date) getDateXHoursAgo(i,dt)}, {@link #getDateXDaysAgo(int, Date) getDateXDaysAgo(i,dt)}, {@link #getDateXAgoWeeks(int, Date) getDateXAgoWeeks(i,dt)}</li>
      </ul>
    **/
   public final Date getDateXAgo(long multiplier, int units_ago, Date from)  {
      if(multiplier == 0)  {
         throw  new IllegalArgumentException("multiplier is zero.");
      }

      long lTime = -1;
      try  {
         lTime = from.getTime();
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("from");
      }

      return  new Date(lTime - (units_ago / multiplier));
   }
   /**
      <p>How many units separate the provided dates?.</p>

      @return  {@code (new Long(d_x, y_date, multiplier)).intValue()}

      @see
         <li>{@link #getXMinusYSeconds(Date, Date) getXMinusYSeconds(dt,dt)}, {@link #getXMinusYMinutes(Date, Date) getXMinusYMinutes(dt,dt)}, {@link #getXMinusYHours(Date, Date) getXMinusYHours(dt,dt)}, {@link #getXMinusYDays(Date, Date) getXMinusYDays(dt,dt)}, {@link #getXMinusYWeeks(Date, Date) getXMinusYWeeks(dt,dt)}</li>
         <li>{@link #getNowMinusYUnits(Date, long) getNowMinusYUnits(dt,l)}, {@link #getNowMinusYSeconds(Date) getNowMinusYSeconds(dt)}, {@link #getNowMinusYMinutes(Date) getNowMinusYMinutes(dt)}, {@link #getNowMinusYHours(Date) getNowMinusYHours(dt)}, {@link #getNowMinusYDays(Date) getNowMinusYDays(dt)}, {@link #getNowMinusYWeeks(Date) getNowMinusYWeeks(dt)}</li>
      </ul>
    **/
   public final int getXMinusYUnits(Date d_x, Date y_date, long multiplier)  {
      return  (new Long(((d_x.getTime() - y_date.getTime()) / multiplier))).intValue();
   }
   /**
      <p>How many units, represented by a long, separate the provided dates?.</p>

      @param  d_x  The date on the left side of the minus equation. May not be {@code null}.
      @param  y_date  The date on the right side of the minus equation. May not be {@code null}.
      @param  multiplier  The number used to translate a Date's milleseconds to some other unit. May not be zero.

      @return  {@code (d_x.getTime() - y_date.getTime()) / multiplier)}
    **/
   public final long getXMinusYUnitsLong(Date d_x, Date y_date, long multiplier)  {
      if(multiplier == 0)  {
         throw  new IllegalArgumentException("multiplier is zero.");
      }

      long lXTime = -1;
      try  {
         lXTime = d_x.getTime();
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("d_x");
      }

      long lYTime = -1;
      try  {
         lYTime = y_date.getTime();
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("y_date");
      }

      return  ((lXTime - lYTime) / multiplier);
   }
}
