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
	import  com.github.xbn.lang.IllegalArgumentStateException;
/**
 * <p>A set of contiguous coordinates in a bounded grid, going in one of the {@code GridDirection}s.</p>
 * @see GridDirection
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public class GridLine  {
	private final DistanceDirection dd;
	private final GridCoordinate[] coords;
	private final BoundedGrid grid;
	public GridLine(BoundedGrid grid, int start_horizIdx, int start_vertIdx, GridDirection direction, int length)  {
		try  {
			coords = new GridCoordinate[length];
		}  catch(ArrayIndexOutOfBoundsException abx)  {
			throw  new ArrayIndexOutOfBoundsException("length=" + length);
		}
		try  {
			coords[0] = grid.getCoordinate(start_horizIdx, start_vertIdx,
				"start_horizIdx", "start_vertIdx");
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("grid");
		}
		GridCoordinate start = coords[0];
		GridCoordinate current = coords[0];
		for(int i = 1; i < length; i++)  {
			GridCoordinate next = null;
			try  {
				next = grid.moveNextDoor(current, direction, EdgeExceeded.CRASH);
			}  catch(IllegalArgumentException iax)  {
				throw  new IllegalArgumentStateException("grid=" + grid +
					", start_horizIdx=" + start_horizIdx + ", start_vertIdx=" +
					start_vertIdx + ", direction=" + direction + ", length=" + length, iax);
			}
			coords[i] = next;
			current = next;
		}
		this.grid = grid;
		dd = DistanceDirection.newForStartEnd(start, current);

		assert  (direction == dd.getDirection()) : "direction (" + direction +
			") does not equal DistanceDirection.newForStartEnd(" + start + ", " + current +
			").getDirection() (" + dd.getDirection() + ")";
	}
	public int getLength()  {
		return  coords.length;
	}
	public GridCoordinate getCoordinate(int index)  {
		try  {
			return  coords[index];
		}  catch(ArrayIndexOutOfBoundsException ibx)  {
			throw  new ArrayIndexOutOfBoundsException("index=" + index + ", getLength()=" + getLength());
		}
	}
	public GridCoordinate getFirstOverlappingCoord(GridLine line)  {
		for(int i = 0; i < line.getLength(); i++)  {
			for(int j = 0; j < getLength(); j++)  {
				GridCoordinate gcFromParam = line.getCoordinate(i);
				if(gcFromParam.equals(getCoordinate(j)))  {
					return  gcFromParam;
				}
			}
		}
		return  null;
	}
}
