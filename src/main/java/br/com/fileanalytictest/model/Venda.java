package br.com.fileanalytictest.model;

import java.math.BigDecimal;
import java.util.Set;

public class Venda {

	private long id;
	private Set<VendaItem> vendaItens;
	private Vendedor vendedor;
	
	private BigDecimal total;
	
	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(long id, Set<VendaItem> vendaItens, Vendedor vendedor) {
		super();
		this.id = id;
		this.vendaItens = vendaItens;
		this.vendedor = vendedor;
	}

	public Venda(long id, Set<VendaItem> vendaItens, Vendedor vendedor, BigDecimal total) {
		super();
		this.id = id;
		this.vendaItens = vendaItens;
		this.vendedor = vendedor;
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<VendaItem> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(Set<VendaItem> vendaItens) {
		this.vendaItens = vendaItens;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((vendaItens == null) ? 0 : vendaItens.hashCode());
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
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
		Venda other = (Venda) obj;
		if (id != other.id)
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (vendaItens == null) {
			if (other.vendaItens != null)
				return false;
		} else if (!vendaItens.equals(other.vendaItens))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", vendaItens=" + vendaItens + ", vendedor=" + vendedor + ", total=" + total + "]";
	}	
	
}
