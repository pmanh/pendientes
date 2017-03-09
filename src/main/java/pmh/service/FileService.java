package pmh.service;

import java.util.List;

import pmh.model.File;

public interface FileService {
	public List<File> get(File obj);
	
	public void save(File obj);
	
	public boolean delete(int id);
}
