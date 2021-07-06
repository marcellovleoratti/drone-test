package br.com.fileanalytictest.model;

import java.math.BigDecimal;

public class VendaItem {

	private long id;
	private int quantidade;
	private BigDecimal preco;
	
	public VendaItem() {
		// TODO Auto-generated constructor stub
	}

	public VendaItem(long id, int quantidade, BigDecimal preco) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + quantidade;
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
		VendaItem other = (VendaItem) obj;
		if (id != other.id)
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VendaItem [id=" + id + ", quantidade=" + quantidade + ", preco=" + preco + "]";
	}
	
	
}
