package pmh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pmh.model.Type;
import pmh.service.TypeService;
import pmh.utils.GenericResult;
import pmh.utils.GenericStatus;

@Controller
@RequestMapping(value="/service/type")
public class TypeController {
	@Autowired
	TypeService typeService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody GenericResult<Type> getAll(Type data){
		List<Type> listConfgs = typeService.get(data);
		return new GenericResult<Type>(listConfgs, new Integer(listConfgs.size()), HttpStatus.OK.toString(), "", true);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody GenericStatus<Type> save(@RequestBody Type data, HttpServletRequest request){
		typeService.save(data);
		return new GenericStatus<Type>(data.getId(), HttpStatus.OK.toString(), data, data.getId()!=0);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody GenericStatus<Type> update(@RequestBody Type data,@PathVariable("id") int id){
		typeService.save(data);
		return new GenericStatus<Type>(data.getId(), HttpStatus.OK.toString(), data, true);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody GenericStatus<Type> delete(@PathVariable("id") int id){
		boolean result = typeService.delete(id);
		return new GenericStatus<Type>(id, result?HttpStatus.OK.toString():HttpStatus.BAD_REQUEST.toString(), null, result);
	}
}
