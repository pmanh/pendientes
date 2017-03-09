package pmh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pmh.model.PendingFile;

public interface PendingFileRepository extends JpaRepository<PendingFile, Integer>{

}
