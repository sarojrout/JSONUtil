import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonUtility {
	public static void main(String[] args) throws JSONException {
		JSONObject dataSet = new JSONObject();
		dataSet.put("first", "saroj") ;
		dataSet.put("middle", "kumar") ;
		dataSet.put("last", "rout") ;

		JSONObject someProperty = new JSONObject();
		someProperty.put("fn", "sk") ;
		someProperty.put("mn", "kr") ;
		someProperty.put("ln", "rt") ;
		someProperty.put("stupidname", "stupidvalue") ;

		JSONArray properties = new JSONArray();
		properties.put(dataSet);
		properties.put(someProperty);
		System.out.println("First JSON Object value::"+properties.toString());
		JSONObject anotherDataSet = new JSONObject();
		anotherDataSet.put("first", "saroj") ;
		anotherDataSet.put("middle", "kumar") ;
		anotherDataSet.put("last", "rout") ;

		JSONObject anotherProperty = new JSONObject();
		anotherProperty.put("fn", "sk") ;
		anotherProperty.put("mn", "kr") ;
		anotherProperty.put("ln", "rt") ;
		anotherProperty.put("stupidname", "stupidvalue") ;

		JSONArray anotherProperties = new JSONArray();
		anotherProperties.put(anotherDataSet);
		anotherProperties.put(anotherProperty);
		System.out.printf("Second JSON Object value::"+anotherProperties.toString()+"\n");	
		System.out.println("Result::"+compareJson(properties,anotherProperties));

	}
	@Test
	public void testJson() throws JSONException{
		JSONObject dataSet = new JSONObject();
		dataSet.put("keyA", "dataSetA") ;
		dataSet.put("keyB", "dataSetB") ;
		dataSet.put("keyC", "dataSetC") ;

		JSONObject someProperty = new JSONObject();
		someProperty.put("someA", "SomeValueA") ;
		someProperty.put("someB", "SomeValueB") ;
		someProperty.put("someC", "SomeValueC") ;
		someProperty.put("somename", "somevalue") ;

		JSONArray properties = new JSONArray();
		properties.put(dataSet);
		properties.put(someProperty);
		System.out.println(properties.toString());
		JSONObject anotherDataSet = new JSONObject();
		anotherDataSet.put("keyA", "dataSetA") ;
		anotherDataSet.put("keyB", "dataSetB") ;
		anotherDataSet.put("keyC", "dataSetC") ;

		JSONObject anotherProperty = new JSONObject();
		anotherProperty.put("someA", "SomeValueA") ;
		anotherProperty.put("someB", "SomeValueB") ;
		anotherProperty.put("someC", "SomeValueC") ;
		anotherProperty.put("somename", "somevalue") ;

		JSONArray anotherProperties = new JSONArray();
		anotherProperties.put(anotherDataSet);
		anotherProperties.put(anotherProperty);
		JsonParser parser = new JsonParser();
		JsonElement o1 = parser.parse(properties.toString());
		JsonElement o2 = parser.parse(anotherProperties.toString());
		System.out.println(o1.equals(o2));
		assertEquals(o1,o2);
	}
	private static boolean compareJson(JSONArray properties, JSONArray someProperties) {
		JsonParser parser = new JsonParser();
		JsonElement o1 = parser.parse(properties.toString());
		JsonElement o2 = parser.parse(someProperties.toString());
		return o1.equals(o2);
	}
}
