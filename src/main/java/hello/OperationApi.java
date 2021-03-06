package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class OperationApi {
    
	//@Autowired
	HugeInteger operation = new HugeInteger();
	
	@RequestMapping(value = "add")
	public String add(@RequestParam(value = "first") String first, @RequestParam(value = "second") String second) {
		
		HugeInteger numberA = new HugeInteger(operation.parse(first));
		operation = new HugeInteger(operation.parse(second));
		System.out.println(" -- "+numberA.toString()+" >> "+operation.toString());
		return operation.reverseString(new HugeInteger(operation.add(numberA)).toString());
	}
	
	@RequestMapping(value = "subtract")
	public String sub(@RequestParam(value = "first") String first,
			@RequestParam(value = "subtractFrom") String second) {
		HugeInteger numberA = new HugeInteger(operation.parse(first));
		operation = new HugeInteger(operation.parse(second));
		System.out.println(" -- "+numberA.toString()+" >> "+operation.toString());
		return operation.reverseString(new HugeInteger(numberA.subtract(operation)).toString());
	}
    
	@RequestMapping("/operation")
	public String operations(@RequestParam(value = "first") String first,
			@RequestParam(value = "operator") String operator,
			@RequestParam(value = "second", defaultValue = "") String second) {
		
		HugeInteger numberA = new HugeInteger(operation.parse(first));
		operation = new HugeInteger(operation.parse(second));
		System.out.println(" -- "+numberA.toString()+" >> "+operation.toString());
		 if(numberA.operation(operation, operator))
		 {
			 return "true";
		 }
		 else
		 {
			 	return "false";
		 }
	}
}
