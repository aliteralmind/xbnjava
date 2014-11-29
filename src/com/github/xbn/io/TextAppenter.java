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
package  com.github.xbn.io;
	import  java.io.InputStream;
	import  java.util.Scanner;
	import  java.io.IOException;
/**
	<p><a href="http://en.wikipedia.org/wiki/Decorator_pattern">Decorator</a> for {@link java.lang.Appendable}-s, including conditional printing, with runtime-only exceptions. This is a companion to {@code TextAppender}.</p>

	<p><i>(Scroll down for examples.)</i></p>

	<h3>From a <a href="http://aliteralmind.wordpress.com/2014/06/30/appenter/">blog-post</a> written on 6/30/2014:</h3>

	<p>I've never used a debugger in my life. I exclusively develop in <a href="http://textpad.com">TextPad</a>, and use <a href="http://phraseexpress.com">PhraseExpress</a> for auto-completes. I will likely start using an IDE, such as Eclipse or the free version of IntelliJ, only for the purpose of using a debugger. Not using a debugger is not something I'm necessarily proud of (well...maybe a little), it's just something I've not gotten around to doing. Despite this, I've built some reasonably large projects. My primary form of debugging has always been <code>System.out.println()</code>-s and this utility: {@code TextAppenter}.</p>

	<p><code>TextAppenter</code> is a <a href="http://en.wikipedia.org/wiki/Decorator_pattern#Java">decorator</a> for <code>java.lang.<a href="http://docs.oracle.com/javase/7/docs/api/java/lang/Appendable.html">Appendables</a></code>. <code>Appendables</code>s only have the following three functions:<ul>
	 	<li><code>append(char)</code></li>
		<li><code>append(CharSequence)</code></li>
		<li><code>append(CharSequence, int, int)</code></li>
	</ul></p>

	<p><code>TextAppenter</code> provides (&quot;decorates&quot; it with) additional functionality but, most importantly, it crash with only runtime errors. Hence the &quot;<code>appent</code>&quot;, with a <code>'t'</code>, prefix to all function names (such as {@link #appentln(Object) appentln}).</p>

	<p>In addition, <code>TextAppenter</code>s may be &quot;{@linkplain #isUseable() unusable}&quot;, which is a convenience when an object <i>optionally</i> outputs debugging information--when the debugging statements should remain in production code, but be off by default.</p>

	<h3>Example 1 of 2: Optionally debugging an object</h3>

	<p>Demonstrates an object that has optional-but-permanent debugging. It is off by default. This example shows an &quot;off&quot; example, followed by an &quot;on&quot;</p>

{@.codelet.and.out com.github.xbn.examples.io.TextAppenterObjectDebugging%eliminateCommentBlocksAndPackageDecl()}

	<h3>Example 2 of 2: Optionally debuging an application with potential levels</h3>

	<p>This trivial Java application uses a TextAppenter to provide three possible levels of debugging: Off, minimal, and verbose:</p>

{@.codelet com.github.xbn.examples.io.TextAppenterWithLevelsAppExample%eliminateCommentBlocksAndPackageDecl()}

	<p><b>Output for:</b> <code>java TextAppenterWithLevelsAppExample debugoff</code></p>

	<p><i>Not applicable: No output</i></p>

	<p><b>Output for:</b> <code>java TextAppenterWithLevelsAppExample debugminimal</code></p>

<blockquote><PRE style="background-color:#EEEEEE;">debugminimal --> DebugLevel.ONE
Minimally-important debugging information goes here...</pre></blockquote>

<!--
	{&#64;.codelet.out com.github.xbn.examples.io.TextAppenterWithLevelsAppExample("debugminimal")}
 -->

	<p><b>Output for:</b> <code>java TextAppenterWithLevelsAppExample debugverbose</code></p>

<blockquote><PRE style="background-color:#EEEEEE;">debugverbose --> DebugLevel.TWO
Minimally-important debugging information goes here...
Very very verbose and highly-important debugging information...</pre></blockquote>

<!--
	{&#64;.codelet.out com.github.xbn.examples.io.TextAppenterWithLevelsAppExample("debugverbose")}
 -->

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class TextAppenter  {
	private final TextAppender tapndr;
	/**
		<p>An unusable appenter.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>new {@link #TextAppenter() TextAppenter}()</code></p>

		@see  #isUseable()
	 **/
	public static final TextAppenter UNUSABLE = new TextAppenter();
	/**
		<p>An appenter that is useable, but discards all output.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>new {@link #TextAppenter(TextAppender) TextAppenter}({@link TAAppendable}.{@link TAAppendable#SUPPRESS SUPPRESS})</code></p>

		@see  #UNUSABLE
		@see  #isUseable()
	 **/
	public static final TextAppenter SUPPRESS = new TextAppenter(TAAppendable.SUPPRESS);
	/**
		<p>An appenter that outputs to {@code System.out}.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>new {@link #TextAppenter(TextAppender) TextAppenter}({@link TAAppendable}.{@link TAAppendable#CONSOLE CONSOLE})</code></p>

		@see  #isUseable()
	 **/
	public static final TextAppenter CONSOLE = new TextAppenter(TAAppendable.CONSOLE);
	/**
		<p>Create a new <i>and unusable</i> appenter.</p>

		<p>This sets {@link #getTextAppender() getTextAppender}{@code ()} to {@code null}.</p>

		@see  #TextAppenter(TextAppender)
		@see  #UNUSABLE
		@see  #isUseable()
	 **/
	private TextAppenter()  {
		tapndr = null;
	}
	/**
		<p>Create a new instance with a text appender.</p>

		@param  to_adapt  May not be {@code null}. Get with {@link #getTextAppender() getTextAppender}{@code ()}.
		@see  #TextAppenter()
	 **/
	public TextAppenter(TextAppender to_adapt)  {
		if(to_adapt == null)  {
			throw  new NullPointerException("to_adapt");
		}
		tapndr = to_adapt;
	}
	/**
		<p>The text appender.</p>

		@see  #TextAppenter(TextAppender)
		@see  #TextAppenter()
		@see  #isUseable()
	 **/
	public TextAppender getTextAppender()  {
		return  tapndr;
	}
	/**
		<p>Is this appenter useable?.</p>

		@return  {@code true}: If {@code appent*} can be safely called. Specifically, this returns
		<br/> &nbsp; &nbsp; <code>({@link #getTextAppender() getTextAppender}() != null)</code>
	 **/
	public boolean isUseable()  {
		return  (getTextAppender() != null);
	}
	/**
		<p>Get the appendable object at the heard of the text appender--<i>This must only be called when it is known that {@code getTextAppender()} is a {@code TAAppendable}</i>.</p>

		@return  <code>(({@link TAAppendable}&lt;Appendable&gt;){@link #getTextAppender() getTextAppender}()).{@link TAAppendable#getAppendable() getAppendable}()</code>
		@exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
		@exception  ClassCastException  If {@code getTextAppender()} is not a {@code TAAppendable}.
	 **/
	@SuppressWarnings("unchecked")
	public Appendable getAppendable()  {
		try  {
			return  ((TAAppendable<Appendable>)getTextAppender()).getAppendable();
		}  catch(NullPointerException npx)  {
			throw  crashIfUnusableOrReturnNpxCause(npx);
		}  catch(ClassCastException ccx)  {
			throw  new ClassCastException("getTextAppender() is not a TAAppendable<Appendable>. getTextAppender()=[" + getTextAppender() + "], original error: " + ccx);
		}
	}
	/**
		<p>Pause the application (that one using this appenter), with a message, until enter is pressed.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link #pauseIfUseable(InputStream, Object) pauseIfUseable}({@link java.lang.System}.{@link java.lang.System#in in}, message)</code></p>
	 **/
	public void pauseIfUseable(Object message)  {
		pauseIfUseable(System.in, message);
	}
	/**
		<p>Pause the application (that one using this appenter), with a message, until enter is pressed. If this appenter is {@linkplain #isUseable() unusable}, this does nothing.</p>

		<p>This calls<ol>
			<li><code>appent(Object)((message == null) ? &quot;Paused. Press enter to proceed.&quot; : message)</code></li>
			<li><code>new {@link java.util.Scanner#Scanner(InputStream) Scanner}(source).{@link java.util.Scanner#nextLine() nextLine}()</code></li>
		</ol></p>
	 **/
	public void pauseIfUseable(InputStream source, Object message)  {
		if(!isUseable())  {
			return;
		}
		appent((message == null) ? "Paused. Press enter to proceed." : message);
		new Scanner(source).nextLine();
	}
	/**
		<p>Output a new line only.</p>

		@exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
	 **/
	public void appentln()  {
		try  {
			getTextAppender().appendln();
		}  catch(NullPointerException npx)  {
			throw  crashIfUnusableOrReturnNpxCause(npx);
		}  catch(IOException iox)  {
			throw  new RTIOException("Attempting getTextAppender().appendln()", iox);
		}
	}
	/**
		<p>Output a message followed by a new line.</p>

		@exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
	 **/
	public void appentln(Object message)  {
		try  {
			getTextAppender().appendln(message);
		}  catch(NullPointerException npx)  {
			throw  crashIfUnusableOrReturnNpxCause(npx);
		}  catch(IOException iox)  {
			throw  new RTIOException("Attempting getTextAppender().appendln(Object), message=\"" + message + "\"", iox);
		}
	}
	/**
		<p>Output a message.</p>

		@exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
	 **/
	public TextAppenter appent(Object message)  {
		try  {
			getTextAppender().append(message);
		}  catch(NullPointerException npx)  {
			throw  crashIfUnusableOrReturnNpxCause(npx);
		}  catch(IOException iox)  {
			throw  new RTIOException("Attempting getTextAppender().append(Object), message=\"" + message + "\"", iox);
		}
		return  this;
	}
	/**
		<p>Output a message followed by a new line, only if a condition is met.</p>

		@exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
	 **/
	public void appentlnIfTrue(boolean condition, Object message)  {
		try  {
			getTextAppender().appendlnIfTrue(condition, message);
		}  catch(NullPointerException npx)  {
			throw  crashIfUnusableOrReturnNpxCause(npx);
		}  catch(IOException iox)  {
			throw  new RTIOException("Attempting getTextAppender().appendlnIfTrue(condition, message), condition=" + condition + ", message=\"" + message + "\"", iox);
		}
	}
	/**
		<p>Output a message, only if a condition is met.</p>

		@exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
	 **/
	public TextAppenter appentIfTrue(boolean condition, Object message)  {
		try  {
			getTextAppender().appendIfTrue(condition, message);
		}  catch(NullPointerException npx)  {
			throw  crashIfUnusableOrReturnNpxCause(npx);
		}  catch(IOException iox)  {
			throw  new RTIOException("Attempting getTextAppender().appendIfTrue(condition, message), condition=" + condition + ", message=\"" + message + "\"", iox);
		}
		return  this;
	}
	/**
		<p>Output multiple new lines only, with no text.</p>

		@exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
		@exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
	 **/
	public void appentlns(int newLine_count)  {
		try  {
			getTextAppender().appendlns(newLine_count);
		}  catch(NullPointerException npx)  {
			throw  crashIfUnusableOrReturnNpxCause(npx);
		}  catch(IOException iox)  {
			throw  new RTIOException("Attempting getTextAppender().appentlns(newLine_count), newLine_count=" + newLine_count, iox);
		}
	}
	public String toString()  {
		return  this.getClass().getName() + ": getTextAppender()=[" + getTextAppender() + "]";
	}
	/**
		<p>Flush the appendable, if it's flushable.</p>
	 **/
	public void flushRtx()  {
      tapndr.flushRtx();
   }
	/**
		<p>(Flush and then) close the appendable, if it's (flushable and) closeable.</p>

		<p>First calls {@link #flushRtx() flushRtx}{@code ()}</p>
	 **/
	public void closeRtx()  {
      flushRtx();
      tapndr.closeRtx();
   }
		private final RuntimeException crashIfUnusableOrReturnNpxCause(NullPointerException cause)  {
			if(isUseable())  {
				return  cause;
			}
			return  new UnusableAppenterException();
		}
}