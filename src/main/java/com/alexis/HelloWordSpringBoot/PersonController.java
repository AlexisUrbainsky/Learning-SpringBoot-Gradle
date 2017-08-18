package com.alexis.HelloWordSpringBoot;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/persons/")
public class PersonController {

	@RequestMapping(value ="/", method = RequestMethod.GET)
	public HashMap<Long,Person> getAllPersons() {
		
		return HelloWordSpringBootApplication.hashPersons;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public Person addPerson(@RequestParam(value="name", required = true) String name, @RequestParam(value="lastName") String lastName, @RequestParam(value="sex") String sex) {
		
		Person p = new Person(name,lastName, sex);
		
		HelloWordSpringBootApplication.hashPersons.put(p.getId(), p);
		
		return p;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public Person update(@RequestBody Person person) throws Exception{
		
		if(HelloWordSpringBootApplication.hashPersons.containsKey(person.getId())){
			HelloWordSpringBootApplication.hashPersons.put(person.getId(), person);
		}else{
			throw new Exception("Person " + person.getId() + " does not exist");
		}
		
		return person;
	}
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public Person delete(@PathVariable long id) throws Exception{
		Person p;
		
		if(HelloWordSpringBootApplication.hashPersons.containsKey(id)){
			p = HelloWordSpringBootApplication.hashPersons.get(id);
			HelloWordSpringBootApplication.hashPersons.remove(id);
		}else{
			throw new Exception("Person " + id + " does not exist");
		}
		
		return p;
	}
	
	
}
