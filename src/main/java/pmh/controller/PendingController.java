package pmh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pmh.model.Pending;
import pmh.model.PendingFile;
import pmh.service.FileService;
import pmh.service.PendingFileService;
import pmh.service.PendingService;
import pmh.utils.GenericResult;
import pmh.utils.GenericStatus;

@RestController
@RequestMapping(value="/service/pending")
public class PendingController {
	@Autowired
	PendingService pendingService;

    @Autowired
    PendingFileService pendingFileService;
    
    @Autowired
    FileService fileService;
    
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public GenericResult<Pending> getAll(Pending data){
		List<Pending> listConfgs = pendingService.get(data);
		return new GenericResult<Pending>(listConfgs, new Integer(listConfgs.size()), HttpStatus.OK.toString(), "", true);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public GenericStatus<Pending> save(@RequestBody PendingFile data,  HttpServletRequest request){
	  pendingService.save(data.getPending());
      if(data.getFile() != null){
      	StringBuilder url = new StringBuilder("/alfresco/service/api/node/");
      	int index  = data.getFile().getUrl().indexOf(":/");
      	url.append(data.getFile().getUrl().substring(0, index))
      	   .append(data.getFile().getUrl().substring(index)+2)
      	   .append("/content/")
      	   .append(data.getFile()
      	   .getName())
      	   .append("?a=true");
        	data.getFile().setUrl(url.toString());
        fileService.save(data.getFile());
        pendingFileService.save(data);
      }
	 return new GenericStatus<Pending>(data.getPending().getId(), HttpStatus.OK.toString(), data.getPending(), data.getPending().getId()!=0);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public GenericStatus<Pending> update(@RequestBody Pending data,@PathVariable("id") int id){
		pendingService.save(data);
		return new GenericStatus<Pending>(data.getId(), HttpStatus.OK.toString(), data, true);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public GenericStatus<Pending> delete(@PathVariable("id") int id){
		boolean result = pendingService.delete(id);
		return new GenericStatus<Pending>(id, result?HttpStatus.OK.toString():HttpStatus.BAD_REQUEST.toString(), null, result);
	}
}
