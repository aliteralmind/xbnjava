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
package  com.github.xbn.experimental;
   import  static com.github.xbn.lang.CrashIfBase.*;
/**
   <p>Defines the legal positioning within an ordered collection--where an element <i>could</i> be.</p>

   <h3>Positions in an ordered collection (such as a List or sequence)</h3>

   <p><ul>
      <li><b>First-not-last:</b> <i>Could</i> be the first element in an ordered collection, but not the last.</li>
      <li><b>Middle:</b> Could be neither the first nor the last.</li>
      <li><b>Last-not-first:</b> Could be the last element, but not the first.</li>
      <li><b>Only:</b> Could be the first-and-last element in the sequence.</li>
   </ul>

   <p>For example:</p>

<pre>   new LegalFMLfl(true, false, true, true)</pre>

   <p><ul>
      <li><b>Parameter 1 (true):</b> This object could be the first-but not the last</li>
      <li><b>Parameter 2 (false):</b> If it were somewhere in the middle (neither the first or last elemnt), that would be bad.</li>
      <li><b>Parameter 3 (true):</b> It could be the last element.</li>
      <li><b>Parameter 4 (true):</b> It could be the only element.</li>
   </ul>


   <h3>Different flavors of the same thing</h3>

   <p>Internally, a {@code LegalFMLfl} stores four booleans: {@link #isFirstOnly() isFirstOnly}{@code ()}, {@link #isMiddle() isMiddle}{@code ()}, {@link #isLastOnly() isLastOnly}{@code ()} and {@link #isFirstLast() isFirstLast}{@code ()}.</p>

   <p>A string of boolean-initials could be provided instead, as a much-shorter alternative.</p>

<pre>   //true, false, true, true
   LegalFMLfl lfmlfl = new LegalFMLfl("tftt");</pre>

   <h4>Beginability and endability: {@code com.github.xbn.experimental.MustOptOrForb}</h4>

   <p><code>An {@link com.github.xbn.experimental.MustOptOrForb MustOptOrForb} object</code> may also be used to define legal positinos in a more relaxed, zen-like state of <b>beginability</b> and <b>endability</b>. For example:</p>

<pre>   LegalFMLfl lfmlfl = new LegalFMLfl(MustOptOrForb.OPTIONAL, MustOptOrForb.MUST)
   System.out.println(lfmlfl.isFirstOnly());
   System.out.println(lfmlfl.isMiddle());
   System.out.println(lfmlfl.isLastOnly());
   System.out.println(lfmlfl.isFirstLast());</pre>

   <p>Output:</p>

<pre>   true
   false
   true
   true</pre>

   <p><ul>
      <li>If it is beginable.OPTIONAL, then it <i>could</i> be first-but-not-last.</li>
      <li>Since it is endable-MUST, it could <i>not</i> be middle (neither first-nor-last).</li>
      <li>It could be last-only--not beginable, but still endable.</li>
      <li>It could be first-last, since beginable is OPTIONAL.</li>
   </ul>

   <h3>{@code com.github.xbn.txol.SubSnip}</h3>

   <p>This class was originally created for use by {@code <a href="../txol/SubSnip.html">SubSnip</a>}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class LegalFMLfl  {
   private String sFMLflBoolInits = null;
   private MustOptOrForb emofBegin = null;
   private MustOptOrForb emofEnd = null;
   private boolean bFirstOnly = false;
   private boolean bMiddle = false;
   private boolean bLastOnly = false;
   private boolean bFirstLast = false;

   /**
      <p>Create a new LegalFMLfl.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; {@code this(true, true, true, true)}</p>
    */
   public LegalFMLfl()  {
      this(true, true, true, true);
   }
   /**
      <p>Create a new LegalFMLfl.</p>

    * @param  is_1stOnlyOk  Could it be first-but-not-last? Get with {@link #isFirstOnly() isFirstOnly}{@code ()}.
    * @param  is_middleOk  Could it be middle (not first or last)? Get with {@link #isMiddle() isMiddle}{@code ()}.
    * @param  is_lastOnlyOk  Could it be last-but-not-first? Get with {@link #isLastOnly() isLastOnly}{@code ()}.
    * @param  is_1stLastOkay  Could it be both first and last? Get with {@link #isFirstLast() isFirstLast}{@code ()}.
    */
   public LegalFMLfl(boolean is_1stOnlyOk, boolean is_middleOk, boolean is_lastOnlyOk, boolean is_1stLastOkay)  {
      bFirstOnly = is_1stOnlyOk;
      bMiddle = is_middleOk;
      bLastOnly = is_lastOnlyOk;
      bFirstLast = is_1stLastOkay;
   }
   /**
      <p>Create a new LegalFMLfl with a boolean-initial string.</p>

    * @param  initial_strLengthFourTtFf  Four boolean initials, as described at the top of this class. Must be non-null, and contain exactly four characters, where each is either {@code '<b>t</b>'} or {@code 'T'}, or {@code 'f'} or {@code 'F'}. Get with {@link #getFMLflBoolInits() getFMLflBoolInits}{@code ()}.
    */
   public LegalFMLfl(String initial_strLengthFourTtFf)  {
      if(initial_strLengthFourTtFf == null)  {
         throw  new NullPointerException("initial_strLengthFourTtFf");
      }
      if(initial_strLengthFourTtFf.length() != 4)  {
         throwBSX(initial_strLengthFourTtFf);
      }

      sFMLflBoolInits = initial_strLengthFourTtFf;
      bFirstOnly = getBoolean(0, initial_strLengthFourTtFf);
      bMiddle = getBoolean(1, initial_strLengthFourTtFf);
      bLastOnly = getBoolean(2, initial_strLengthFourTtFf);
      bFirstLast = getBoolean(3, initial_strLengthFourTtFf);
   }
   /**
      <p>Create a new LegalFMLfl with beginability. See the top of this class for details.</p>

    * @param  beginability  Beginability. May not be {@code null}.
    * @param  endability  Endability. May not be {@code null}.
    */
   public LegalFMLfl(MustOptOrForb beginability, MustOptOrForb endability)  {
      if(beginability == null)  {
         throw  new NullPointerException("beginability");
      }
      if(endability == null)  {
         throw  new NullPointerException("endability");
      }

      bFirstOnly = !beginability.isForbidden();
      bMiddle = (!beginability.isMust()  &&  !endability.isMust());
      bLastOnly = !endability.isForbidden();
      bFirstLast = (bFirstOnly  &&  bLastOnly);
   }
   /**
      <p>Is first-but-not-last a legal position?.</p>

    * @return  <b>{@code is_1stOnlyOk}</b>, as provided to the constructor.
    */
   public boolean isFirstOnly()  {
      return  bFirstOnly;
   }
   /**
      <p>Is neither-first-nor-last a legal position?.</p>

    * @return  <b>{@code is_middleOk}</b>, as provided to the constructor.
    */
   public boolean isMiddle()  {
      return  bMiddle;
   }
   /**
      <p>Is last-but-not-first a legal position?.</p>

    * @return  <b>{@code is_lastOnlyOk}</b>, as provided to the constructor.
    */
   public boolean isLastOnly()  {
      return  bLastOnly;
   }
   /**
      <p>Is first-and-last a legal position?.</p>

    * @return  <b>{@code is_1stLastOkay}</b>, as provided to the constructor.
    */
   public boolean isFirstLast()  {
      return  bFirstLast;
   }
   /**
      <p>Does the actual position conform to the legal positions?.</p>

    * @return  {@code isValidActualLocation(is_first, is_last, true, null)}
    */
   public boolean isValidActualLocation(boolean is_first, boolean is_last)  {
      return  isValidActualLocation(is_first, is_last, true, null);
   }
   /**
      <p>Does the actual position conform to the legal positions?.</p>

    * @param  is_actuallyFirst  Is the element actually first in the sequence?
    * @param  is_actuallyEnd  Is the element actually last in the sequence?
    * @return  <b>{@code false}</b>  If <ul>
         <li>{@code is_actuallyFirst} is true, but {@link #isBeginable() beginability} is not legal, or</li>
         <li>{@code is_actuallyEnd} is true, but {@link #isEndable() endability} is not legal.</li>
      </ul>
      <br><b>{@code true}</b> If otherwise.
    */
   public boolean isValidActualLocation(boolean is_actuallyFirst, boolean is_actuallyEnd, boolean do_returnIfFalse, Object xtra_errInfo)  {
      if((is_actuallyFirst  &&  !isBeginable())  ||
            (is_actuallyEnd  &&  !isEndable()))  {
         if(do_returnIfFalse)  {
            return  false;
         }

         if((is_actuallyFirst  &&  !isBeginable())  ||
            (is_actuallyEnd  &&  !isEndable()))  {
            String s = "is_actuallyFirst=" + is_actuallyFirst + ", isBeginable()=" + isBeginable() + ", is_actuallyEnd=" + is_actuallyEnd + ", isEndable()=" + isEndable();
            throw  new IllegalPositionException(getXMsg(s, xtra_errInfo));
         }
      }

      return  true;
   }
   /**
      <p>Get an enum representing beginability.</p>

    * @return  {@code MustOptOrForb.MUST}, {@code MustOptOrForb.OPTIONAL} or {@code MustOptOrForb.FORBIDDEN}, as described at the top of this class.
    * @see  #getEndability()
    * @see  #isBeginable()
    * @see  #isBeginableMust()
    * @see  #isBeginableOptional()
    * @see  #isBeginableForbidden()
    * @see  #isBeginableMust()
    */
   public final MustOptOrForb getBeginability()  {
      if(emofBegin == null)  {
         if(bFirstOnly  ||  bFirstLast)  {
            emofBegin = (bMiddle
               ?  MustOptOrForb.OPTIONAL
               :  MustOptOrForb.MUST);
         }  else  {
            emofBegin = MustOptOrForb.FORBIDDEN;
         }
      }

      return  emofBegin;
   }
   /**
      <p>Get an enum representing endability.</p>

    * @return  {@code MustOptOrForb.MUST}, {@code MustOptOrForb.OPTIONAL} or {@code MustOptOrForb.FORBIDDEN}, as described at the top of this class.
    * @see  #getBeginability()
    * @see  #isBeginable()
    * @see  #isEndableMust()
    * @see  #isEndableOptional()
    * @see  #isEndableForbidden()
    */
   public final MustOptOrForb getEndability()  {
      if(emofEnd == null)  {
         if(bLastOnly  ||  bFirstLast)  {
            emofEnd = (bMiddle
               ?  MustOptOrForb.OPTIONAL
               :  MustOptOrForb.MUST);
         }  else  {
            emofEnd = MustOptOrForb.FORBIDDEN;
         }
      }

      return  emofEnd;
   }
   /**
      <p>Can this element be beginable?.</p>

    * @return  <code>(!{@link #isBeginableForbidden() isBeginableForbidden}())</code>
    */
   public final boolean isBeginable()  {
      return  (!isBeginableForbidden());
   }
   /**
      <p>Is beginability set to MUST?.</p>

    * @return  <code>{@link #getBeginability}{@code ()}.{@link MustOptOrForb#isMust() isMust}()</code>
    */
   public final boolean isBeginableMust()  {
      return  getBeginability().isMust();
   }
   /**
      <p>Is beginability set to OPTIONAL?.</p>

    * @return  <code>{@link #getBeginability}{@code ()}.{@link MustOptOrForb#isOptional() isOptional}()</code>
    */
   public final boolean isBeginableOptional()  {
      return  getBeginability().isOptional();
   }
   /**
      <p>Is beginability set to FORBIDDEN?.</p>

    * @return  <code>{@link #getBeginability}{@code ()}.{@link MustOptOrForb#isForbidden() isForbidden}()</code>
    */
   public final boolean isBeginableForbidden()  {
      return  getBeginability().isForbidden();
   }
   /**
      <p>Can this element be endable?.</p>

    * @return  <code>(!{@link #isEndableForbidden() isEndableForbidden}())</code>
    */
   public final boolean isEndable()  {
      return  (!isEndableForbidden());
   }
   /**
      <p>Is endability set to MUST?.</p>

    * @return  <code>{@link #getEndability}{@code ()}.{@link MustOptOrForb#isMust() isMust}()</code>
    */
   public final boolean isEndableMust()  {
      return  getEndability().isMust();
   }
   /**
      <p>Is endability set to OPTIONAL?.</p>

    * @return  <code>{@link #getEndability}{@code ()}.{@link MustOptOrForb#isOptional() isOptional}()</code>
    */
   public final boolean isEndableOptional()  {
      return  getEndability().isOptional();
   }
   /**
      <p>Is endability set to FORBIDDEN?.</p>

    * @return  <code>{@link #getEndability}{@code ()}.{@link MustOptOrForb#isForbidden() isForbidden}()</code>
    */
   public final boolean isEndableForbidden()  {
      return  getEndability().isForbidden();
   }
   /**
      <p>Is it legal for another element to go before this one?.</p>

    * @return  <code>(!}{@link #isBeginableMust() isBeginableMust}())</code>
    */
   public final boolean isPrecedable()  {
      return  (!isBeginableMust());
   }
   /**
      <p>Is it legal for another element to be after this one?.</p>

    * @return  <code>(!}{@link #isEndableMust() isEndableMust}())</code>
    */
   public final boolean isFollowable()  {
      return  (!isEndableMust());
   }
   /**
      <p>Get a long representation of this class. Each position, if-and-only if true, is fully spelled out. For example:</p>

      <p>{@code FIRST-ONLY, FIRST-LAST}</p>
    */
   public final String getDiagnostics()  {
      StringBuilder sb = new StringBuilder();

      if(isFirstOnly())  {
         sb.append("FIRST-ONLY");
      }

      if(isMiddle())  {
         appCma(sb);
         sb.append("MIDDLE");
      }

      if(isLastOnly())  {
         appCma(sb);
         sb.append("LAST-ONLY");
      }

      if(isFirstLast())  {
         appCma(sb);
         sb.append("FIRST-LAST");
      }

      return  sb.toString();
   }
   private static void appCma(StringBuilder to_appendTo)  {
      if(to_appendTo.length() > 0)  {
         to_appendTo.append(", ");
      }
   }
   /**
      <p>Get the boolean-initial string for this {@code LegalFMLfl}.</p>

    * @return  A string in the format as described at the top of this class.
    * @see  #getFMLflBoolInits(boolean, boolean, boolean, boolean) getFMLflBoolInits(b,b,b,b)
    * @see  #getBoolean(int, String) getBoolean(i,s)
    */
   public String getFMLflBoolInits()  {
      if(sFMLflBoolInits == null)  {
         sFMLflBoolInits = getFMLflBoolInits(isFirstOnly(), isMiddle(), isLastOnly(), isFirstLast());
      }

      return  sFMLflBoolInits;
   }
   /**
      <p>Utility function to create a boolean initail string, usable in the {@code LegalLFMfl} constructor.</p>

    * @return  A string in the format as described at the top of this class, representing these parameter-values, <i>not</i> the internally-held booleans.
    * @see  #getFMLflBoolInits()
    * @see  #getBoolean(int, String) getBoolean(i,s)
    */
   public static String getFMLflBoolInits(boolean is_1stOnlyOk, boolean is_middleOk, boolean is_lastOnlyOk, boolean is_1stLastOkay)  {
      return  (is_1stOnlyOk  ?  "T"  :  "F") +
         (is_middleOk  ?  "T"  :  "F") +
         (is_lastOnlyOk  ?  "T"  :  "F") +
         (is_1stLastOkay  ?  "T"  :  "F");
   }
   /**
      <p>Utility function to get a particular boolean value from a boolean-initial string.</p>

    * @param index  The char-index of the boolean you want, within {@code initial_strLengthFourTtFf}.
    * @param  initial_strLengthFourTtFf  The boolean-initial string, as discussed at the top of this class.
    */
   public static final boolean getBoolean(int index, String initial_strLengthFourTtFf)  {
      char c = Character.toUpperCase(initial_strLengthFourTtFf.charAt(index));
      if(c == 'T')  {
         return  true;
      }

      if(c == 'F')  {
         return  false;
      }

      throwBSX(initial_strLengthFourTtFf);

      return  false;
   }
   private static String throwBSX(String initial_strLengthFourTtFf)  {
      throw  new IllegalArgumentException("initial_strLengthFourTtFf (currently '" + initial_strLengthFourTtFf + "') must be exactly four characters, and each must be a t, T, f or F.");
   }
   /**
    * @return  <b>{@link #getFMLflBoolInits() getFMLflBoolInits}{@code ()}</b>
    */
   public final String toString()  {
      return  getFMLflBoolInits();
   }
}
