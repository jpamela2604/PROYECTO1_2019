
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package color_gxml;

import java.io.*;
import java_cup.runtime.*;
import java.util.LinkedList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class g_sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return g_simb.class;
}

  /** Default constructor. */
  @Deprecated
  public g_sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public g_sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public g_sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\006\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\004\000\002\003\003\000\002\003\003" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\010\000\006\004\006\005\007\001\002\000\010\002" +
    "\000\004\011\005\012\001\002\000\004\002\010\001\002" +
    "\000\010\002\ufffd\004\ufffd\005\ufffd\001\002\000\010\002" +
    "\ufffc\004\ufffc\005\ufffc\001\002\000\004\002\001\001\002" +
    "\000\010\002\uffff\004\uffff\005\uffff\001\002\000\010\002" +
    "\ufffe\004\ufffe\005\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\010\000\006\002\004\003\003\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$g_sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$g_sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$g_sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}





/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$g_sintactico$actions {


      

  private final g_sintactico parser;

  /** Constructor */
  CUP$g_sintactico$actions(g_sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$g_sintactico$do_action_part00000000(
    int                        CUP$g_sintactico$act_num,
    java_cup.runtime.lr_parser CUP$g_sintactico$parser,
    java.util.Stack            CUP$g_sintactico$stack,
    int                        CUP$g_sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$g_sintactico$result;

      /* select the action based on the action number */
      switch (CUP$g_sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.elementAt(CUP$g_sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.elementAt(CUP$g_sintactico$top-1)).right;
		String start_val = (String)((java_cup.runtime.Symbol) CUP$g_sintactico$stack.elementAt(CUP$g_sintactico$top-1)).value;
		RESULT = start_val;
              CUP$g_sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.elementAt(CUP$g_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$g_sintactico$parser.done_parsing();
          return CUP$g_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= L 
            {
              String RESULT =null;

              CUP$g_sintactico$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.peek()), RESULT);
            }
          return CUP$g_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // L ::= L menor 
            {
              String RESULT =null;

              CUP$g_sintactico$result = parser.getSymbolFactory().newSymbol("L",1, ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.elementAt(CUP$g_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.peek()), RESULT);
            }
          return CUP$g_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // L ::= L reservada 
            {
              String RESULT =null;

              CUP$g_sintactico$result = parser.getSymbolFactory().newSymbol("L",1, ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.elementAt(CUP$g_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.peek()), RESULT);
            }
          return CUP$g_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // L ::= menor 
            {
              String RESULT =null;

              CUP$g_sintactico$result = parser.getSymbolFactory().newSymbol("L",1, ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.peek()), RESULT);
            }
          return CUP$g_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // L ::= reservada 
            {
              String RESULT =null;

              CUP$g_sintactico$result = parser.getSymbolFactory().newSymbol("L",1, ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$g_sintactico$stack.peek()), RESULT);
            }
          return CUP$g_sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$g_sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$g_sintactico$do_action(
    int                        CUP$g_sintactico$act_num,
    java_cup.runtime.lr_parser CUP$g_sintactico$parser,
    java.util.Stack            CUP$g_sintactico$stack,
    int                        CUP$g_sintactico$top)
    throws java.lang.Exception
    {
              return CUP$g_sintactico$do_action_part00000000(
                               CUP$g_sintactico$act_num,
                               CUP$g_sintactico$parser,
                               CUP$g_sintactico$stack,
                               CUP$g_sintactico$top);
    }
}

}
