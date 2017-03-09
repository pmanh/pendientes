package pmh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmh.model.File;
import pmh.model.PendingFile;
import pmh.repository.FileRepository;
import pmh.repository.PendingFileRepository;
import pmh.service.FileService;
import pmh.service.PendingFileService;

@Service("pendingFileService")
public class PendingFileServiceImpl implements PendingFileService{
  @Autowired
  private PendingFileRepository pendingFileRepository;
  
  public List<PendingFile> get(PendingFile obj){
      return pendingFileRepository.findAll();
  }
  
  public void save(PendingFile obj){
    pendingFileRepository.save(obj);
  }
  
  public boolean delete(int id){
      PendingFile obj = pendingFileRepository.findOne(id);
      if(obj != null){
        pendingFileRepository.delete(obj);
          return true;
      }
      return false;
  }
}
