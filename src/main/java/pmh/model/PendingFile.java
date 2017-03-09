package pmh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fm_pending_file")
public class PendingFile {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private int id;
  @ManyToOne
  @JoinColumn(name="id_pendig")
  private Pending pending;
  
  @ManyToOne
  @JoinColumn(name="id_file")
  private File file;
  
  public PendingFile() {
    super();
  }
  public PendingFile(Pending pending, File file) {
    super();
    this.pending = pending;
    this.file = file;
  }
  public Pending getPending() {
    return pending;
  }
  public void setPending(Pending pending) {
    this.pending = pending;
  }
  public File getFile() {
    return file;
  }
  public void setFile(File file) {
    this.file = file;
  }
}
