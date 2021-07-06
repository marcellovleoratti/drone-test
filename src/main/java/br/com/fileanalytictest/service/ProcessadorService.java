package br.com.fileanalytictest.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.fileanalytictest.model.Cliente;
import br.com.fileanalytictest.model.IdentificadorEnum;
import br.com.fileanalytictest.model.Venda;
import br.com.fileanalytictest.model.VendaItem;
import br.com.fileanalytictest.model.Vendedor;

@Configuration
public class ProcessadorService {

	@Value("data/out/")
	private Resource outputResources;
	
	public String processar(File file) {
		
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			Pattern pattern;
			Matcher matcher;
			String regexSale = "(\\d*-\\d*-\\d*\\.?\\d*)";
			
			Set<Cliente> clientes = new HashSet<Cliente>();
			Set<Vendedor> vendedores = new HashSet<Vendedor>();
			Set<Venda> vendas = new HashSet<Venda>();
			
			Iterator<String> iterator = bf.lines().iterator();
			while (iterator.hasNext()) {
				String line = iterator.next();
				List<String> colunas = encontrarValores(line);

				IdentificadorEnum identificador = IdentificadorEnum.getByValue(colunas.get(0));
				switch (identificador) {
				case VENDEDOR:
					vendedores.add(new Vendedor(colunas.get(1), colunas.get(2), new BigDecimal(colunas.get(3))));
					break;
				case CLIENTE:
					clientes.add(new Cliente(colunas.get(1), colunas.get(2), colunas.get(3)));
					break;
				case VENDA:
					
					Set<VendaItem> vendaItens = new HashSet<VendaItem>();
					pattern = Pattern.compile(regexSale);
					matcher = pattern.matcher(colunas.get(2));
					
					BigDecimal total = new BigDecimal(0);
					
					while (matcher.find()) {
						String[] vendaItemArray = matcher.group().split("-");
						
						VendaItem vendaItem = new VendaItem(Long.parseLong(vendaItemArray[0]), Integer.parseInt(vendaItemArray[1]), new BigDecimal(vendaItemArray[2]));
						
						vendaItens.add(vendaItem);
						
						total = total.add(vendaItem.getPreco().multiply(new BigDecimal(vendaItem.getQuantidade())));
					}
					
					vendas.add( new Venda(Long.valueOf(colunas.get(1)), vendaItens, vendedores.stream().filter(v -> v.getNome().equals(colunas.get(3))).findFirst().get(), total));
					
					break;
				default:
					break;
				}
				
			}
			
			List<Venda> sortedVendas = vendas.stream().sorted(Comparator.comparing(Venda::getTotal)).collect(Collectors.toList());
			Long idVendaMaisCara = sortedVendas.get(sortedVendas.size()-1).getId();
			Vendedor vendedorPior = sortedVendas.get(0).getVendedor();
			
			return saida(clientes.size(), vendedores.size(), idVendaMaisCara, vendedorPior);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public List<String> encontrarValores(String line) {
		return Arrays.asList(line.split("ç"));
	}
	
	private String saida(int qtdCliente, int qtdvendedor, Long idVendaMaisCara, Vendedor vendedorPior) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("• Quantidade de clientes no arquivo de entrada: ").append(qtdCliente);
		sb.append("\n• Quantidade de vendedores no arquivo de entrada: ").append(qtdvendedor);
		sb.append("\n• ID da venda mais cara: ").append(idVendaMaisCara);
		sb.append("\n• O pior vendedor: ").append(vendedorPior.getNome());
		
		return sb.toString();
	}
	
	public void escreverSaida(String nome, String retorno) {
		try (FileWriter myWriter = new FileWriter(outputResources.getURI().getPath() + nome + "-" + System.currentTimeMillis())) {
			myWriter.write(retorno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
