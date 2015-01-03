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
package  com.github.xbn.linefilter.alter;
   import  com.github.xbn.analyze.alter.ExpirableElements;
   import  com.github.xbn.lang.ExpiredException;
   import  com.github.xbn.analyze.alter.AbstractAlterer;
   import  com.github.xbn.analyze.alter.MultiAlterType;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.io.RTIOException;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.text.padchop.EscapeAction;
   import  com.github.xbn.text.padchop.NewVzblPadChopFor;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  java.io.IOException;
   import  java.util.Iterator;
/**
   <p>Alters all the the lines returned by a string iterator with a single alterer.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class AllTextLineAlterer extends AbstractAlterer  {
   private int lineNum;
   private final ValueAlterer<String,String> alterer;
   private static final VzblPadChop VPC_DBG = NewVzblPadChopFor.trimEscChopWithDDD(true, EscapeAction.ESCAPE, 100);
   public AllTextLineAlterer(TextLineAlterer[] alterers, ExpirableElements xprbl_elements, MultiAlterType multi_type, Appendable dbgDest_nullIfNone)  {

      //Crashes if any elements are expired.
      this.alterer = new ExpirableTextLineAlterList(alterers, xprbl_elements, multi_type, dbgDest_nullIfNone);
   }
   /**
      <p>Create a new instance from a line-alterer.</p>

    * @param  line_alterer  May not be {@code null} or {@linkplain com.github.xbn.lang.Expirable#isExpired() expired}. A <i>duplicate</i> of this object (defensive copy) is stored internally.
    * @exception  ExpiredException  If {@code line_alterer} is expired.
    */
   public AllTextLineAlterer(ValueAlterer<String,String> line_alterer)  {
      try  {
         if(line_alterer.isExpired())  {
            throw  new ExpiredException("line_alterer");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(line_alterer, "line_alterer", null, rx);
      }
      this.alterer = line_alterer.getObjectCopy();
   }
   /**
      <p>Create a new instance as a duplicate of another.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.analyze.validate. AbstractAlterer#AbstractAlterer(AbstractAlterer) super}{@code (to_copy)}/li>
         <li>YYY</li>
      </ol>

    * @param  to_copy  May not be <code>null</code>.
    * @see  #getObjectCopy()
    */
   public AllTextLineAlterer(AllTextLineAlterer to_copy)  {
      super(to_copy);
      this.alterer = to_copy.alterer.getObjectCopy();
   }
   public String getAlteredFromLineObjects(int start_lineNum, Iterator<String> line_itr, String lineSep_orNullForNone)  {
      return  appendAlteredFromLineObjects((new StringBuilder()), start_lineNum, line_itr, lineSep_orNullForNone).toString();
   }
   /**
      <p>Append all lines, accumulated and altered, with runtime exceptions.</p>
    */
   public Appendable appendAlteredFromLineObjects(Appendable to_appendTo, int start_lineNum, Iterator<String> line_itr, String lineSep_orNullForNone)  {
      try  {
         return  appendAlteredFromLineObjectsX(to_appendTo, start_lineNum, line_itr, lineSep_orNullForNone);
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
   /**
      <p>Append all altered lines, with checked exceptions.</p>

    * @param  to_appendTo  May not be {@code null}.
    * @param  start_lineNum  The line number of the first line returned by the iterator.
    * @param  line_itr  May not be {@code null}, and <i>should</i> return at least one line.
    * @exception  RuntimeException  If getting the altered value fails. The cause can be obatined with {@link java.lang.RuntimeException#getCause() getCause}{@code ()}.
    */
   public Appendable appendAlteredFromLineObjectsX(Appendable to_appendTo, int start_lineNum, Iterator<String> line_itr, String lineSep_orNullForNone) throws IOException  {
      lineNum = start_lineNum;
      try  {
         while(line_itr.hasNext())  {
            String line = line_itr.next();
            try  {
               line = alterer.getAltered(line, line);
            }  catch(RuntimeException rx)  {
               throw  new RuntimeException("Attempting getAltered(line, line). line=" + lineNum + ", line=\"" + VPC_DBG.get(line) + "\"", rx);
            }
            to_appendTo.append(line);
            if(lineSep_orNullForNone != null)  {
               to_appendTo.append(lineSep_orNullForNone);
            }
            lineNum++;
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(line_itr, "line_itr", null, rx);
      }
      return  to_appendTo;
   }
   public String getAlteredLines(int start_lineNum, Iterator<String> line_itr, String lineSep_orNullForNone)  {
      return  appendAlteredLines((new StringBuilder()), start_lineNum, line_itr, lineSep_orNullForNone).toString();
   }
   /**
      <p>Append all lines, accumulated and altered, with runtime exceptions.</p>
    */
   public Appendable appendAlteredLines(Appendable to_appendTo, int start_lineNum, Iterator<String> line_itr, String lineSep_orNullForNone)  {
      try  {
         return  appendAlteredLinesX(to_appendTo, start_lineNum, line_itr, lineSep_orNullForNone);
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
   /**
      <p>Append all altered lines, with checked exceptions.</p>

    * @param  to_appendTo  May not be {@code null}.
    * @param  start_lineNum  The line number of the first line returned by the iterator.
    * @param  line_itr  May not be {@code null}, and <i>should</i> return at least one line.
    * @exception  RuntimeException  If getting the altered value fails. The cause can be obatined with {@link java.lang.RuntimeException#getCause() getCause}{@code ()}.
    */
   public Appendable appendAlteredLinesX(Appendable to_appendTo, int start_lineNum, Iterator<String> line_itr, String lineSep_orNullForNone) throws IOException  {
      lineNum = start_lineNum;
      try  {
         while(line_itr.hasNext())  {
            String line = line_itr.next();
            try  {
               line = alterer.getAltered(line, line);
            }  catch(RuntimeException rx)  {
               throw  new RuntimeException("Attempting getAltered(line, line). lineNum=" + lineNum + ", line=\"" + VPC_DBG.get(line) + "\"", rx);
            }
            to_appendTo.append(line);
            if(lineSep_orNullForNone != null)  {
               to_appendTo.append(lineSep_orNullForNone);
            }
            lineNum++;
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(line_itr, "line_itr", null, rx);
      }
      return  to_appendTo;
   }
   /**
      <p>Duplicate this <code>AllTextLineAlterer</code>.</p>

    * @return  <code>(new <a href="#AllTextLineAlterer(AllTextLineAlterer)">AllTextLineAlterer</a>(this))</code>
    */
   public AllTextLineAlterer getObjectCopy()  {
      return  (new AllTextLineAlterer(this));
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  to_appendTo.append(", alterer=[" + alterer + "]");
   }
   /**
    */
   public boolean isComplete()  {
      return  alterer.isComplete();
   }
   /**
    */
   public StringBuilder appendIncompleteInfo(StringBuilder to_appendTo)  {
      return  alterer.appendIncompleteInfo(to_appendTo);
   }
}
