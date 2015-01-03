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
package  com.github.xbn.analyze;
   import  com.github.xbn.lang.ExpirableComposer;
   import  com.github.xbn.io.z.GetDebugApbl_Fieldable;
   import  com.github.xbn.testdev.CompositionConstructor;
   import  com.github.xbn.testdev.CompositionFunction;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.io.SimpleDebuggable;
   import  com.github.xbn.lang.ExtraErrInfoableComposer;
/**
   <p>For classes that need to implement {@code Analyzer}, that cannot extend {@code AbstractAnalyzer}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class AnalyzerComposer extends SimpleDebuggable  {
   private int     iNlzd = -1;
   private boolean bWNlzd = false;
   private final ExtraErrInfoableComposer cfxic;
   private final ExpirableComposer ec;
   private boolean bAutoResetState;
   /**
      <p>Create a new {@code AnalyzerComposer}.</p>

    * @see  #AnalyzerComposer(boolean, AnalyzerComposer) this(b,ac)
    * @see  #AnalyzerComposer(Analyzer) this(z)
    */
   @CompositionConstructor
   public AnalyzerComposer()  {
      super();
      //Never ever call interface functions, directly or indirectly, in a constructor.
      zresetStateAB();
      zresetCountsAB();
      cfxic = new ExtraErrInfoableComposer();
      ec = new ExpirableComposer();
      bAutoResetState = true;
   }
   /**
      <p>Create a new {@code AnalyzerComposer} as a duplicate of another.</p>

      <p>This<ol>
         <li>Sets<ol>
            <li>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()} to {@code to_copy.getAnalyzedCount()}</li>
            <li>{@link #wasAnalyzed() wasAnalyzed}{@code ()} to {@code to_copy.wasAnalyzed()}</li>
         </ol></li>
         <li>Calls {@link #zresetStateAB() zresetStateAB}{@code ()} &nbsp; &nbsp; <i>(as specified by  <code><i>[{@link com.github.xbn.analyze.Analyzer Analyzer}]</i>.{@link com.github.xbn.analyze.Analyzer#getObjectCopy() getObjectCopy}()</code>)</i></li>
      </ol>

    * @param  ignored  Required to prevent an ambigous-invocation error, when attempting to call this or the {@link #AnalyzerComposer(Analyzer) other} copy-constructor with a class such as {@link com.github.xbn.analyze.AbstractAnalyzer AbstractAnalyzer}, which both extends this {@code AnalyzerComposer} and is an {@link com.github.xbn.analyze.Analyzer Analyzer}.
    * @see  #AnalyzerComposer()
    */
   @CompositionConstructor
   protected AnalyzerComposer(boolean ignored, AnalyzerComposer to_copy)  {
      super(to_copy);  //AnalyzerComposers ARE Debuggable. No need for ignored
      iNlzd = to_copy.getAnalyzedCount();
      bWNlzd = to_copy.wasAnalyzed();
      cfxic = new ExtraErrInfoableComposer(ignored, to_copy.cfxic);
      ec = new ExpirableComposer(ignored, to_copy.ec);
      bAutoResetState = to_copy.doAutoResetState();

      //Never ever call interface functions, directly or indirectly, in a constructor.
      zresetStateAB();
   }
   /**
      <p>Create a new {@code AnalyzerComposer} from an {@code Analyzer}.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.io.SimpleDebuggable#SimpleDebuggable(Debuggable) super}{@code (to_copy)}</li>
         <li>Sets<ol>
            <li>{@link #getAnalyzedCount() getAnalyzedCount}{@code ()} to {@code to_copy.getAnalyzedCount()}</li>
         </ol></li>
         <li>Calls {@link #zresetStateAB() zresetStateAB}{@code ()}</li>
      </ol>
    * @see  #AnalyzerComposer()
    */
   @CompositionConstructor
   public AnalyzerComposer(Analyzer to_copy)  {
      super(to_copy);
      iNlzd = to_copy.getAnalyzedCount();
      cfxic = new ExtraErrInfoableComposer().extraErrInfo(to_copy.getExtraErrInfo());
      ec = new ExpirableComposer(to_copy);
      bAutoResetState = to_copy.doAutoResetState();

      //Never ever call interface functions, directly or indirectly, in a constructor.
      zresetStateAB();
      zresetCountsAB();
   }
   @CompositionFunction
   public void resetState()  {
      zresetStateAB();
   }
   protected final void zresetStateAB()  {
      bWNlzd = false;
   }
   @CompositionFunction
   public void resetCounts()  {
      zresetCountsAB();
   }
   @CompositionFunction
   public boolean doAutoResetState()  {
      return  bAutoResetState;
   }
   @CompositionFunction
   public void setAutoResetState_4prot(boolean is_auto)  {
      bAutoResetState = is_auto;
   }
   protected final void zresetCountsAB()  {
      iNlzd = 0;
   }
   @CompositionFunction
   public boolean doesExpire()  {
      return  ec.doesExpire();
   }
   @CompositionFunction
   public void declareExpirable_4prot()  {
      ec.declareExpirable_4prot();
   }
   @CompositionFunction
   public void declareExpired_4prot()  {
      resetState();
      ec.declareExpired_4prot();
   }
   @CompositionFunction
   public boolean isExpired()  {
      return  ec.isExpired();
   }
   /**
    * @return  The number of times {@link #declareAnalyzed_4prot() declareAnalyzed_4prot}{@code ()} was called since the most recent call to {@link #resetCounts() resetCounts}{@code ()}.
    */
   @CompositionFunction
   public int getAnalyzedCount()  {
      return  iNlzd;
   }
   /**
      <p>Declare that an analysis took place.</p>

      <p>This<ol>
         <li>Increments {@link #getAnalyzedCount() getAnalyzedCount}{@code ()} and sets {@link #wasAnalyzed() wasAnalyzed}{@code ()} to {@code true}.</li>
      </ol>
    */
   @CompositionFunction
   public void declareAnalyzed_4prot()  {
      iNlzd++;
      bWNlzd = true;
   }
   /**
    * @return  {@code true} If {@link #declareAnalyzed_4prot() declareAnalyzed_4prot}{@code ()} was called more recently than {@link #resetState() resetState}{@code ()}
    */
   @CompositionFunction
   public boolean wasAnalyzed()  {
      return  bWNlzd;
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         if(wasAnalyzed())  {
            to_appendTo.append("analyzed ").append(getAnalyzedCount()).append(" times");
         }  else  {
            to_appendTo.append("not-analyzed");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      if(doAutoResetState())  {
         to_appendTo.append(" (auto-reset)");
      }
      to_appendTo.append(", ");
      return  ec.appendToString(to_appendTo);
   }
   @CompositionFunction
   public Object getExtraErrInfo()  {
      return  cfxic.getExtraErrInfo();
   }
   @CompositionFunction
   public void setExtraErrInfo(Object xtra_errInfo)  {
      cfxic.setExtraErrInfo(xtra_errInfo);
   }
//static...START
   /**
      <p>If this {@code Analyzer} needs its {@code stateReset()}, crash. This is useful as the first step of any analysis.</p>

    * @param  analyzer  May not be {@code null}.
    * @exception  IllegalStateException  If <code>analyzer.{@link com.github.xbn.analyze.Analyzer#wasAnalyzed() wasAnalyzed}()</code> is {@code true}.
    */
   public static final void autoResetStateOrCINeedTo(Analyzer analyzer)  {
      try  {
         if(analyzer.doAutoResetState())  {
            analyzer.resetState();
            return;
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(analyzer, "analyzer", null, rx);
      }
      if(analyzer.wasAnalyzed())  {
         throw  new IllegalStateException("Must resetState(). " + analyzer);
      }
   }
   public static final Appendable getDebugApbl(GetDebugApbl_Fieldable fieldable, String fldbl_name)  {
      try  {
         return  fieldable.getDebugApbl();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(fieldable, fldbl_name, null, rx);
      }
   }
//static...END
}
