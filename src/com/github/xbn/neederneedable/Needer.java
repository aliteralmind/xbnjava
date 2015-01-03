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
package  com.github.xbn.neederneedable;
/**
   <p>{@code Needer}s need another object, as created by a {@code Needable}.</p>

   <p><i>This interface results in a number of unchecked-cast warnings, due to the possibility of multiple types of objects being needed by the same class. Type-safety is ensured by the {@code needed_class} parameter in {@link #startConfig(Class) startConfig(cls)}.</i></p>

 * @see  Needable
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface Needer  {
   /**
      <p>Start the configuration of a new object of a specific type.</p>

      <p>This<ol>
         <li>Calls <code><i>[{@link com.github.xbn.neederneedable.Needable Needable}]</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="Needable.html#startConfigReturnNeedable(R)">startConfigReturnNeedable</a>(this)</code></li>
         <li>Sets {@link #isConfigActive() isConfigActive}{@code ()} to {@code true}.</li>
      </ol>

    * @param  needed_class  The type of object needed. Get with {@link #getNeededType() getNeededType}{@code ()}. For example: {@code Integer.class} or
      <br> &nbsp; &nbsp; {@code (Class<ListLister<E>>)((Class)ListLister.class))}
      <br>Why the crazy casting is necessary with generics:

      <TABLE ALIGN="center" WIDTH="100%" BORDER="1" CELLSPACING="0" CELLPADDING="4" BGCOLOR="#EEEEEE"><TR ALIGN="left" VALIGN="middle">
         <TD>From (viewed 1/4/2014)
         <br> &nbsp; &nbsp; <code><a href="http://stackoverflow.com/questions/7502243/java-casting-class-operator-used-on-a-generic-type-e-g-list-to-classlist">http://stackoverflow.com/questions/7502243/java-casting-class-operator-used-on-a-generic-type-e-g-list-to-classlist</a></code><P/>

         <pre>{@literal Class<List<Integer>> tListInt3 =
   (Class<List<Integer>>)((Class<Integer>)List.class);}</pre>

         <p>doesn't work. you probably meant</p>

         <pre>{@literal Class<List<Integer>> tListInt3 =
   (Class<List<Integer>>)((Class)List.class);}</pre>

         <p>we can always cast from one type to another by up-cast then down-cast
         <br> &nbsp; &nbsp; {@code Integer x = (Integer)(Object)"string";}</p>

         <p>The type of {@code List.class} is {@code Class<List>} it is not a subtype/supertype of {@code Class<List<Whatever>>} therefore direct cast between the two types is illegal.</p>

         <p>It can be argued that {@code Class<List<Integer>>} doesn't exist - there is only a class for {@code List} there is no such class for {@code List<Integer>} (which really is just {@code List} at runtime)</p>

         </p>However, this is a flaw of Java type system; in practice we do need things like {@code Class<List<Integer>>}. Our solution - casting and pretending {@code Class<List<Int>>} exists - is likewise flawed - but it's not our fault.</TD>
      </TR></TABLE>

    * @exception  IllegalStateException  If {@link #isConfigActive() isConfigActive}{@code ()} is {@code true}.
    */
   void startConfig(Class<?> needed_class);
   /**
      <p>Is an object being configured?.</p>

    * @return  {@code true}  If {@link #startConfig(Class) startConfig(cls)} was more-recently called than {@link #neeadableSetsNeeded(Object) neeadableSetsNeeded(o)}.
    */
   boolean isConfigActive();
   /**
      <p>The type of object currently being configured.</p>

    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="Needable.html#startConfigReturnNeedable(R)">startConfigReturnNeedable</a>(R)</code>
    * @see  #isConfigActive()
    */
   Class getNeededType();
   /**
      <p>Called by the {@code Needable} to set the fully configured object. This {@link com.github.xbn.neederneedable.Needable Needable} is the same one as called in the first step of {@link #startConfig(Class) startConfig(cls)}. This function is never called directly.</p>

      <p>This sets<ol>
         <li>{@code fully_configured} to an internal object.</li>
         <li>{@link #isConfigActive() isConfigActive}{@code ()} to {@code false}.</li>
      </ol>

    * @exception  IllegalStateException  If {@code isConfigActive()} is {@code null}.
    * @exception  ClassCastException  If <code>({@link #getNeededType() getNeededType}().isInstance(fully_configured))</code> is {@code false}. <i>{@code Needer}-s may need multiple types of objects, so {@code Needer&lt;ASingleClassType&gt;} is not possible. {@code <i>[Class]</i>.isInstance(o)} ensures that the needable-configuration completes as expected, and avoids an {@code instanceof} &quot;switch&quot; (if-then-else) block.</i>
    */
   void neeadableSetsNeeded(Object fully_configured);
}

