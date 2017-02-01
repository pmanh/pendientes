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

import pmh.model.Pending;
import pmh.service.PendingService;
import pmh.utils.GenericResult;
import pmh.utils.GenericStatus;

@Controller
@RequestMapping(value="/service/pending")
public class PendingController {
	@Autowired
	PendingService pendingService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody GenericResult<Pending> getAll(Pending data){
		List<Pending> listConfgs = pendingService.get(data);
		return new GenericResult<Pending>(listConfgs, new Integer(listConfgs.size()), HttpStatus.OK.toString(), "", true);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public @ResponseBody GenericStatus<Pending> save(@RequestBody Pending data, HttpServletRequest request){
		pendingService.save(data);
		return new GenericStatus<Pending>(data.getId(), HttpStatus.OK.toString(), data, data.getId()!=0);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody GenericStatus<Pending> update(@RequestBody Pending data,@PathVariable("id") int id){
		pendingService.save(data);
		return new GenericStatus<Pending>(data.getId(), HttpStatus.OK.toString(), data, true);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody GenericStatus<Pending> delete(@PathVariable("id") int id){
		boolean result = pendingService.delete(id);
		return new GenericStatus<Pending>(id, result?HttpStatus.OK.toString():HttpStatus.BAD_REQUEST.toString(), null, result);
	}
}
