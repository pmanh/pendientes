package pmh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmh.model.File;
import pmh.repository.FileRepository;
import pmh.service.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService{
  @Autowired
  private FileRepository fileRepository;
  
  public List<File> get(File obj){
      return fileRepository.findAll();
  }
  
  public void save(File obj){
      fileRepository.save(obj);
  }
  
  public boolean delete(int id){
      File obj = fileRepository.findOne(id);
      if(obj != null){
          fileRepository.delete(obj);
          return true;
      }
      return false;
  }
}
