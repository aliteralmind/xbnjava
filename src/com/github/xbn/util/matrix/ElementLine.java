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
package  com.github.xbn.util.matrix;
	import  com.github.xbn.lang.IllegalArgumentStateException;
/**
 * <p>A set of contiguous elements in a bounded matrix, going directly
 * horizontal, vertical, or forty-five degrees diagonal.</p>
 *
 * <p><i>TODO: Add function <code>doDiagonalsIntersectNotOverlap(ElementLine)</code></i></p>
 * @see MatrixDirection
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public class ElementLine  {
	private final DistanceDirection distDir;
	private final MatrixElement[] coords;
	private final BoundedMatrix matrix;
	/**
	 * Create a new instance.
	 * @param   matrix  May not be <code>null</code>. Get with
	 * {@link #getMatrix()}{@code ()}.
	 * @param   start_horizIdx  The horizontal index of the start-element.
	 * Must be valid for <code>matrix.{@link BoundedMatrix#getWidth() getWidth}()</code>
	 * @param   start_vertIdx  The vertical index of the start-element.
	 * Must be valid for <code>matrix.{@link BoundedMatrix#getHeight() getHeight}()</code>
	 * @param   direction  The direction from the start-element the line
	 * goes in. May not be <code>null</code>.
	 * @param   length  The number of elements in the line.
	 */
	public ElementLine(BoundedMatrix matrix, int start_horizIdx, int start_vertIdx,
				MatrixDirection direction, int length)  {
		try  {
			coords = new MatrixElement[length];
		}  catch(ArrayIndexOutOfBoundsException abx)  {
			throw  new ArrayIndexOutOfBoundsException("length=" + length);
		}
		MatrixElement start = null;
		try  {
			start = matrix.get(start_horizIdx, start_vertIdx,
				"start_horizIdx", "start_vertIdx");
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("matrix");
		}
		coords[0] = start;
		MatrixElement current = start;
		for(int i = 1; i < length; i++)  {
			MatrixElement next = null;
			try  {
				next = matrix.moveNextDoor(current, direction, EdgeExceeded.CRASH);
			}  catch(IllegalArgumentException iax)  {
				throw  new IllegalArgumentStateException("matrix=" + matrix +
					", start_horizIdx=" + start_horizIdx + ", start_vertIdx=" +
					start_vertIdx + ", direction=" + direction + ", length=" + length, iax);
			}
			coords[i] = next;
			current = next;
		}
		this.matrix = matrix;
		distDir = DistanceDirection.newForStartEnd(start, current);

		assert  (direction == distDir.getDirection()) : "direction (" + direction +
			") does not equal DistanceDirection.newForStartEnd(" + start + ", " +
			current + ").getDirection() (" + distDir.getDirection() + ")";
	}
	/**
	 * The number of elements in the line.
	 * @return  {@code length} As provided to the {@linkplain #ElementLine(com.github.xbn.util.matrix.BoundedMatrix, int, int, com.github.xbn.util.matrix.MatrixDirection, int) constructor}.
	 */
	public int getLength()  {
		return  coords.length;
	}
	/**
	 * The matrix in which this line exists.
	 * @return  {@code matrix} As provided to the {@linkplain #ElementLine(com.github.xbn.util.matrix.BoundedMatrix, int, int, com.github.xbn.util.matrix.MatrixDirection, int) constructor}.
	 */
	protected BoundedMatrix getMatrix()  {
		return  matrix;
	}
	/**
	 * The direction in which the line goes, starting from the initial
	 * element.
	 * @return  As created in the constructor {@linkplain #ElementLine(com.github.xbn.util.matrix.BoundedMatrix, int, int, com.github.xbn.util.matrix.MatrixDirection, int) constructor}.
	 */
	public DistanceDirection getDistDir()  {
		return  distDir;
	}
	/**
	 * Get the n-th element in this line.
	 * @param   index  Must be valid given {@link #getLength()}{@code ()}.
	 * @return  The {@code index}-th element in this line, starting with the
	 * initial element, and going in
	 * <code>{@link #getDistDir()}.{@link DistanceDirection#getDirection() getDirection}()</code>
	 */
	public MatrixElement get(int index)  {
		try  {
			return  coords[index];
		}  catch(ArrayIndexOutOfBoundsException ibx)  {
			throw  new ArrayIndexOutOfBoundsException("index=" + index +
				", getLength()=" + getLength());
		}
	}
	/**
	 * <p>Get the first index in <i>{@code this}</i> line whose element has the
	 * same coordinates as an element in another line.</p>
	 *
	 * <p>Note this does not detect two diagonal lines that <i>intersect but do not overlap</i>. See the TODO at the top of this class.</p>
	 * @param   line  May not be <code>null</code>
	 * @return  {@code -1} if no elements overlap. Otherwise the first index
	 * that overlaps one element in {@code line}.
	 */
	public int getFirstOverlappingIndex(ElementLine line)  {
		for(int i = 0; i < line.getLength(); i++)  {
			for(int j = 0; j < getLength(); j++)  {
				MatrixElement gcFromParam = line.get(i);
				if(gcFromParam.equals(get(j)))  {
					return  j;
				}
			}
		}
		return  -1;
	}
}
