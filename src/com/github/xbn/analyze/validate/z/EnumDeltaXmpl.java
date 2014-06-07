package  com.github.xbn.examples.lang.non_xbn;

/**
   <P>{@code java com.github.xbn.examples.lang.non_xbn.EnumDeltaXmpl}</P>
 **/
public class EnumDeltaXmpl  {
  public static final void main(String[] ingo_red)  {
     test(MachineAction.ONE);
     test(MachineAction.TWO);
     test(MachineAction.THREE);
     test(MachineAction.FOUR);
  }
  private static final void test(MachineAction action)  {
     System.out.println("MachineAction." + action + ": name=" + action.sName + ", ip=" + action.sIP + "");
  }
}

enum MachineAction  {
  ONE("Name1", "192.1.1.1"),
  TWO("Name2", "292.2.2.2"),
  THREE("Name3", "392.3.3.3"),
  FOUR("Name4", "492.4.4.4"),
  FIVE("Name5", "592.5.5.5");

  public final String sName;
  public final String sIP;

  private MachineAction(String type_name, String ip)  {
     sName = type_name;
     sIP = ip;
  }
}
