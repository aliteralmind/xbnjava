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
	<p>Abstract implementation of {@code Analyzer}. For classes needing to implement {@code Analyzer}, that cannot extend {@code AbstractAnalyzer}, see {@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public abstract class AbstractAnalyzer implements Analyzer  {
	private final AnalyzerComposer zc;
//constructors...START
	/**
		<p>Create a new {@code AbstractAnalyzer}.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; {@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer super}{@code ()}</p>

		@see  #AbstractAnalyzer(Analyzer) AbstractAnalyzer(z)
	 **/
	public AbstractAnalyzer()  {
		zc = new AnalyzerComposer();
	}
	/**
		<p>Create a new {@code AbstractAnalyzer} from an {@code Analyzer}.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; {@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer(Analyzer) super}{@code (to_copy)}</p>

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
			<p>Reset non-count state.</p>

			<p>Equal to
			<br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</i>.{@link com.github.xbn.analyze.AnalyzerComposer#resetState() resetState}()</code></p>
		 **/
		public void resetState()  {
			zc.resetState();
		}
		/**
			<p>Reset counts to zero.</p>

			<p>Equal to
			<br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</i>.{@link com.github.xbn.analyze.AnalyzerComposer#resetCounts() resetCounts}()</code></p>
		 **/
		public void resetCounts()  {
			zc.resetCounts();
		}
		/**
			@return   <code><i>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</i>.{@link com.github.xbn.analyze.AnalyzerComposer#getAnalyzedCount() getAnalyzedCount}()</code>
		 **/
		public int getAnalyzedCount()  {
			return  zc.getAnalyzedCount();
		}
		/**
			<p>Declare an analysis occured.</p>

			<p>Equal to
			<br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</i>.{@link com.github.xbn.analyze.AnalyzerComposer#declareAnalyzed_4prot() declareAnalyzed_4prot}()</code></p>
		 **/
		protected void declareAnalyzed()  {
			zc.declareAnalyzed_4prot();
		}
		/**
			@return   <code><i>[{@link com.github.xbn.analyze.AnalyzerComposer AnalyzerComposer}]</i>.{@link com.github.xbn.analyze.AnalyzerComposer#wasAnalyzed() wasAnalyzed}()</code>
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