package pmh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pmh.model.File;

public interface FileRepository extends JpaRepository<File, Integer>{

}
