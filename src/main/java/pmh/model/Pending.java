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
@Table(name="fm_pending")
public class Pending {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="id_type")
	private Type idType;

	public Pending() {
		super();
	}

	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param idType
	 */
	public Pending(int id, String title, String description, Type idType) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.idType = idType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getIdType() {
		return idType;
	}

	public void setIdType(Type idType) {
		this.idType = idType;
	}
}
