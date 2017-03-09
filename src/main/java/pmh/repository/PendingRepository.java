package pmh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pmh.model.Pending;

public interface PendingRepository extends JpaRepository<Pending, Integer> {

}