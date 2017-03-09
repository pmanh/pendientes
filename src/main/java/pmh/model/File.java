package pmh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fm_files")
public class File {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private int id;
  
  @Column(name="name")
  private String name;
  
  @Column(name="url")
  private String url;

  public File() {
    super();
    // TODO Auto-generated constructor stub
  }

  public File(int id, String name, String url) {
    super();
    this.id = id;
    this.name = name;
    this.url = url;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
