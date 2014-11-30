package  com.github.xbn.examples.lang.composition;
/**
   <p>Analyzes something.</p>
   **/
interface Analyzer  {
   boolean wasAnalyzed();
   int getAnalyzedCount();
   /**
      <p>Sets {@code wasAnalyzed()} to {@code false}</p>
      **/
   void resetState();
   /**
      <p>Sets {@code getAnalyzedCount()} to {@code 0}</p>
      **/
   void resetCounts();
}
/**
   <p>Determines if <i>something</i> is valid or invalid.</p>
   **/
interface Validator extends Analyzer  {
   boolean isValid();
   int getValidCount();
   /**
      <p>Calls {@code super.resetState()}, and sets {@code isValid()} to {@code false}</p>
      **/
   void resetState();
   /**
      <p>Calls {@code super.resetCounts()}, and sets {@code getValidCount()} to {@code 0}</p>
      **/
   void resetCounts();
}
/**
   <p>A {@code Validator} for a single object.</p>
   **/
interface ValueValidator<O> extends Validator  {
   boolean isValid(O to_validate);
   boolean isNullOk();
}
abstract class AbstractAnalyzer implements Analyzer  {
   private boolean wasNlzd;
   private int nlzdCount;
   public AbstractAnalyzer()  {
      resetState();
      resetCounts();
   }
   public void resetState()  {
      wasNlzd = false;
   }
   public void resetCounts()  {
      nlzdCount = 0;
   }
   public boolean wasAnalyzed()  {
      return  wasNlzd;
   }
   public int getAnalyzedCount()  {
      return  nlzdCount;
   }
   protected void declareAnalyzed()  {
      if(wasAnalyzed())  {
         throw  new IllegalStateException("wasAnalyzed() is true. Must resetState()");
      }
      wasNlzd = true;
      nlzdCount++;
   }
   public String toString()  {
      return  this.getClass().getName() + ": wasAnalyzed()=" + wasAnalyzed() + " (" + getAnalyzedCount() + " times)";
   }
}
/**
  <p>Boolean enum</p>
 **/
enum Null {  OK, BAD;  };

abstract class AbstractValidator extends AbstractAnalyzer implements Validator  {
   private boolean wasVld;
   private int vldCount;
   private final boolean isNullOk;
   public AbstractValidator(Null nnull)  {
      if(nnull == null)  {
         throw  new NullPointerException("nnull");
      }
      isNullOk = (nnull == Null.OK);
   }
   public boolean isNullOk()  {
      return  isNullOk;
   }
   public void resetState()  {
      super.resetState();
      wasVld = false;
   }
   public void resetCounts()  {
      super.resetCounts();
      vldCount = 0;
   }
   public boolean isValid()  {
      return  wasVld;
   }
   public int getValidCount()  {
      return  vldCount;
   }
   protected void declareValid(boolean wasValid)  {
      declareAnalyzed();
      wasVld = wasValid;
      if(wasValid)  {
         vldCount++;
      }
   }
   public String toString()  {
      return  super.toString() + ", isValid()=" + isValid() + " (" + getValidCount() + " times), isNullOk()=" + isNullOk();
   }
}

/**
   <p>A {@code ValueValidator} that only checks for {@code null}-ness.</p>
   **/
class NullnessValidator<O> extends AbstractValidator implements ValueValidator<O>  {
   public NullnessValidator(Null nnull)  {
   	super(nnull);
   }
   public boolean isValid(O to_validate)  {
      boolean isValid = (isNullOk() ? true : (to_validate != null));
      declareValid(isValid);
      return  isValid;
   }
}
public class DemonstrateVVNullInheritOnly  {
   public static final void main(String[] ignored)  {
      NullnessValidator<String> strNotNullVldtr = new NullnessValidator<String>(Null.BAD);
      System.out.println("null is valid? " + strNotNullVldtr.isValid(null));

      strNotNullVldtr.resetState();

      System.out.println("\"hello\" is valid? " + strNotNullVldtr.isValid("hello"));

      System.out.println("strNotNullVldtr.toString(): " + strNotNullVldtr.toString());
   }
}
