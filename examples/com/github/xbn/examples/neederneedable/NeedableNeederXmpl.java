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
package  com.github.xbn.examples.neederneedable;
   import  com.github.xbn.neederneedable.DummyForNoNeeder;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.neederneedable.AbstractNeedable;
   import  com.github.xbn.neederneedable.AbstractNeeder;
/**
   <p>Demonstration of {@code com.github.xbn.neederneedable.}{@link com.github.xbn.neederneedable.Needer} and {@link com.github.xbn.neederneedable.Needable}.</p>

   <p>{@code java com.github.xbn.examples.neederneedable.NeedableNeederXmpl}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NeedableNeederXmpl  {
   public static final void main(String[] ignored)  {
      System.out.println("Sharing FavNumConfigurator's chain, via Needer:");
         UserSettings us = (new UserSettings()).
            cfgFavInt().twentySeven().timesTwo().increment().endCfg().  //shared-chain
            name("President Obama");												//local-chain
         System.out.println("name=" + us.sName);
         System.out.println("favorite number=" + us.iFav);

      System.out.println();

      System.out.println("Using FavNumConfigurator directly:");
         int iFav = (new FavNumConfigurator()).twentySeven().increment().timesTwo().get();
         System.out.println("favorite number=" + iFav);
   }
}


/**
   <p>The main needer-class.</p>
 **/
class UserSettings extends AbstractNeeder  {
   public static final int iDEFAULT_FAV = 8;
   public int iFav = -1;
   public String sName = null;
   //Needer implementation by Composition [1/2]

   public UserSettings name(String type_name)  {
      sName = type_name;
      return  this;
   }

   //Start a needable-configuration, control is given to needable
   //until [FavNumConfigurator4Ndr].endCfg() is called.
   public FavNumConfigurator4Ndr<UserSettings> cfgFavInt()  {
      return  new FavNumConfigurator4Ndr<UserSettings>(this);
   }

   //Needer implementation by Composition [2/2]...START
      //Used by needable, in endCfg(), to set the needed value
      //into this needer.
      public void neeadableSetsNeeded(Object needed_fullyConfigured)  {
         iFav = (Integer)setGetNeededEndConfig(needed_fullyConfigured);
      }
      public void startConfig()  {
         startConfig(Integer.class);
      }
   //Needer implementation by Composition [2/2]...END
}


/**
   <p>Empty needable class-wrapper, for using the needable's chain directly.</p>
 **/
class FavNumConfigurator extends FavNumConfigurator4Ndr<DummyForNoNeeder>  {
   public FavNumConfigurator()  {
      super(null);
   }
}
/**
   <p>The needable</p>
 **/
class FavNumConfigurator4Ndr<R extends Needer> extends AbstractNeedable<Integer,R>  {
   private int iFav = -1;
   public FavNumConfigurator4Ndr(R needer)  {
      super(true, true, needer);
   }
   public FavNumConfigurator4Ndr<R> set(int fav_num)  {
      try  {
         iFav = fav_num;
      }  catch(RuntimeException rx)  {
         //Overkill in this example, but this is the recommended way of
         //rethrowing errors in all Needable functions that "return this".
         throw  new RuntimeException(getChainIDForXMsg(null).toString(), rx);
      }
      return  this;
   }
   public int get()  {
      return  iFav;
   }

   //Self-returning...START
      public FavNumConfigurator4Ndr<R> twentySeven()  {
         return  set(27);
      }
      public FavNumConfigurator4Ndr<R> timesTwo()  {
         return  set(get() * 2);
      }
      public FavNumConfigurator4Ndr<R> increment()  {
         return  set(get() + 1);
      }
   //Self-returning...END
   public FavNumConfigurator4Ndr<R> chainID(boolean do_setStatic, Object id)  {
      chainID(do_setStatic, id);
      return  this;
   }

   //Control: Needer --> Needable
   public FavNumConfigurator4Ndr<R> startConfigReturnNeedable(R needer)  {
      startConfig(needer, Integer.class);
      return  this;
   }

   //Control: Needable --> Needer
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(get());
   }
}
