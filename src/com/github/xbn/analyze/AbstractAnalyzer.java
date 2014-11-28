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
	import  com.github.xbn.io.TextAppenter;
/**
	<P>Abstract implementation of {@code Analyzer}. For classes needing to implement {@code Analyzer}, that cannot extend {@code AbstractAnalyzer}, see {@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public abstract class AbstractAnalyzer implements Analyzer  {
	private final AnalyzerComposer zc;
//constructors...START
	/**
		<P>Create a new {@code AbstractAnalyzer}.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer super}{@code ()}</P>

		@see  #AbstractAnalyzer(Analyzer) AbstractAnalyzer(z)
	 **/
	public AbstractAnalyzer()  {
		zc = new AnalyzerComposer();
	}
	/**
		<P>Create a new {@code AbstractAnalyzer} from an {@code Analyzer}.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer(Analyzer) super}{@code (to_copy)}</P>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
		@see  #AbstractAnalyzer() this()
	 **/
	public AbstractAnalyzer(Analyzer to_copy)  {
		zc = new AnalyzerComposer(to_copy);
	}
//constructors...END
	//Composition implementation: AnalyzerComposer...START
		/**
			<P>Reset non-count state.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</I>.{@link com.github.xbn.analyze.AnalyzerComposer#resetState() resetState}()</CODE></P>
		 **/
		public void resetState()  {
			zc.resetState();
		}
		/**
			<P>Reset counts to zero.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</I>.{@link com.github.xbn.analyze.AnalyzerComposer#resetCounts() resetCounts}()</CODE></P>
		 **/
		public void resetCounts()  {
			zc.resetCounts();
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</I>.{@link com.github.xbn.analyze.AnalyzerComposer#getAnalyzedCount() getAnalyzedCount}()</CODE>
		 **/
		public int getAnalyzedCount()  {
			return  zc.getAnalyzedCount();
		}
		/**
			<P>Declare an analysis occured.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</I>.{@link com.github.xbn.analyze.AnalyzerComposer#declareAnalyzed_4prot() declareAnalyzed_4prot}()</CODE></P>
		 **/
		protected void declareAnalyzed()  {
			zc.declareAnalyzed_4prot();
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</I>.{@link com.github.xbn.analyze.AnalyzerComposer#wasAnalyzed() wasAnalyzed}()</CODE>
		 **/
		public boolean wasAnalyzed()  {
			return  zc.wasAnalyzed();
		}
		public boolean doesExpire()  {
			return  zc.doesExpire();
		}
		protected void declareExpirable()  {
			zc.declareExpirable_4prot();
		}
		protected void declareExpired()  {
			zc.declareExpired_4prot();
		}
		public boolean isExpired()  {
			return  zc.isExpired();
		}
		public boolean doAutoResetState()  {
			return  zc.doAutoResetState();
		}
		protected void setAutoResetState(boolean is_auto)  {
			zc.setAutoResetState_4prot(is_auto);
		}
	//Composition implementation: AnalyzerComposer...END
	public void onIfNonNull(Appendable destination)  {
		zc.onIfNonNull(destination);
	}
	public void setDebug(Appendable destination, boolean is_on)  {
		zc.setDebug(destination, is_on);
	}
	public void setDebugOn(boolean is_on)  {
		zc.setDebugOn(is_on);
	}
	public boolean isDebugOn()  {
		return  zc.isDebugOn();
	}
	public Appendable getDebugApbl()  {
		return  getDebugAptr().getAppendable();
	}
	public TextAppenter getDebugAptr()  {
		return  zc.getDebugAptr();
	}
	public Object getExtraErrInfo()  {
		return  zc.getExtraErrInfo();
	}
	public void setExtraErrInfo(Object info)  {
		zc.setExtraErrInfo(info);
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		return  zc.appendToString(to_appendTo);
	}
}