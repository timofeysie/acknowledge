package example
// sample entity
class User
{
 	def username, password, version, salt = 'RANDOM';

	// your API, provide a Map of changes to update a entity. 
	// the map value may be static value, or a closure that takes 
	// up to 2 params
	def update( entity, Map changes )
	{
	 	changes?.each {k, v ->
	  	def newValue;
	  	if (v instanceof Closure)
	  	{
	   		switch (v.parameterTypes.length) 
	   		{
	    		case 0: newValue = v(); break;
    			case 1: newValue = v(entity[k]); break; // if one params, the closure is called with the field value
    			case 2: newValue = v(entity[k],entity); break; // if two params, the closure is called with teh field value and the entity
   			}
  		}else
  		{
   			newValue = v
  		}
  		entity[k] = newValue
 		}
	}
}