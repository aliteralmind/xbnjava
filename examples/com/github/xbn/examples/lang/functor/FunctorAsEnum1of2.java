/*license*\
	XBN-Java Library

	Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

	This software is dual-licensed under the:
	- Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
	- Apache Software License (ASL) version 2.0.

	Either license may be applied at your discretion. More information may be found at
	- http://en.wikipedia.org/wiki/Multi-licensing.

	The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
	- LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
	- ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/

package  com.github.xbn.examples.lang.functor;
/**
	<p>Implementing a <a href="http://stackoverflow.com/questions/7369460/help-with-understanding-a-function-object-or-functor-in-java/22163940#22163940">functor</a> with an Enum.</p>

	<p>{@code java com.github.xbn.examples.lang.functor.FunctorAsEnum1of2}</p>

	@see  com.github.xbn.examples.lang.functor.FunctorAsEnum2of2
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class FunctorAsEnum1of2  {
   public static final void main(String[] ignored)  {
       CardinalDirection.WEST.move(3);
       CardinalDirection.NORTH.move(2);
       CardinalDirection.EAST.move(15);
   }
}
enum CardinalDirection  {
   NORTH(new MoveNorth()),
   SOUTH(new MoveSouth()),
   EAST(new MoveEast()),
   WEST(new MoveWest());
   private final MoveInDirection dirFunc;
   CardinalDirection(MoveInDirection dirFunc)  {
      if(dirFunc == null)  {
         throw  new NullPointerException("dirFunc");
      }
      this.dirFunc = dirFunc;
   }
   public void move(int steps)  {
      dirFunc.move(steps);
   }
}
interface MoveInDirection  {
   void move(int steps);
}
class MoveNorth implements MoveInDirection  {
   public void move(int steps)  {
      System.out.println("Moved " + steps + " steps north.");
   }
}
class MoveSouth implements MoveInDirection  {
   public void move(int steps)  {
      System.out.println("Moved " + steps + " steps south.");
   }
}
class MoveEast implements MoveInDirection  {
   public void move(int steps)  {
      System.out.println("Moved " + steps + " steps east.");
   }
}
class MoveWest implements MoveInDirection  {
   public void move(int steps)  {
      System.out.println("Moved " + steps + " steps west.");
   }
}