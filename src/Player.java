
public class Player {
	
	//Parametri del giocatore
	
	private String name;
	private int position;
	private int id;
	//metodi		
	@Override
	public String toString() {
		return (name + " is in the cell number " + position + ". Player number " + (id+1)+".");
	}

	//costruttore
	public Player(String name, int id) {
	this.name = name;
	this.id = id;
	this.position=0;
	}
	//gettes and setters

	public String getName() {
		return name;
	}


	public int getPosition() {
		return position;
	}


	public int getId() {
		return id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
