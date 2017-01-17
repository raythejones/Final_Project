import javax.script.*;

public class CreateHelperFunction {
    
    public static Object evaluate(String stringInput) throws Exception{
       // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String

	return engine.eval(stringInput);
    
	}
    
    
    
    public static void main(String[] args) {
  


    }
    
 
    
}
