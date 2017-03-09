package pmh.service;

import java.util.List;

import pmh.model.File;
import pmh.model.PendingFile;

public interface PendingFileService {
	public List<PendingFile> get(PendingFile obj);
	
	public void save(PendingFile obj);
	
	public boolean delete(int id);
}
