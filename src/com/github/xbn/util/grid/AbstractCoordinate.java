/*license*\
   XBN-Java: http://xbnjava.aliteralmind.com

   Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.util.grid;
/**
 * <p>Foundation for coordinate-based information.</p>
 *
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public abstract class AbstractCoordinate  {
	private final int horiz;
	private final int vert;
	/**
	 * <p>Create a new item from its coordinates.</p>
	 * @param  horiz Horizontal. Get with {@link #getHorizontal()}.
	 * @param  vert  Vertical. Get with {@link #getVertical()}.
	 */
	public AbstractCoordinate(int horiz, int vert)  {
		this.horiz = horiz;
		this.vert = vert;
	}
	/**
	 * <p>The horizontal number.</p>
	 *
	 * @return  <code>horiz</code>, as provided to the
	 * {@link #AbstractCoordinate(int, int) constructor}.
	*/
	public int getHorizontal()  {
		return  horiz;
	}
	/**
	 * <p>The vertical number.</p>
	 *
	 * @return  <code>vert</code>, as provided to the
	 * {@link #AbstractCoordinate(int, int) constructor}.
	*/
	public int getVertical()  {
		return  vert;
	}
	public String toString()  {
		return  "[" + getHorizontal() + ", " + getVertical() + "]";
	}
	/**
	 * @return  <CODE>true</CODE> If {@code to_compareTo} is non-{@code null},
	 * {2:n} {@code AbstractCoordinate}, and all its fields {@linkplain #areFieldsEqual(AbstractCoordinate)
	 * are equal}. This is implemented as suggested by Joshua Bloch in
	 * &quot;Effective Java&quot; (2nd ed, item 8, page 46).
	 **/
	@Override
	public boolean equals(Object to_compareTo)  {
		//Check for object equality first, since it's faster than instanceof.
		if(this == to_compareTo)  {
			return  true;
		}
		if(!(to_compareTo instanceof AbstractCoordinate))  {
			//to_compareTo is either null or not an AbstractCoordinate.
			//java.lang.Object.object(o): "For any non-null reference value x,
			//x.equals(null) should return false."
			return  false;
		}

		//Safe to cast
		AbstractCoordinate o = (AbstractCoordinate)to_compareTo;

		//Finish with field-by-field comparison.
		return  areFieldsEqual(o);
	}
	/**
	 * <P>Are all relevant fields equal?.</P>
	 * param  to_compareTo  May not be {@code null}.
	 **/
	public boolean areFieldsEqual(AbstractCoordinate to_compareTo)  {
		try  {
			return  (getHorizontal() == to_compareTo.getHorizontal()  &&
				getVertical() == to_compareTo.getVertical());
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("to_compareTo");
		}
	}
}