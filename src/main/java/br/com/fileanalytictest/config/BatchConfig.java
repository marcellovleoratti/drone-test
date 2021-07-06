package br.com.fileanalytictest.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.fileanalytictest.service.ProcessadorService;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Value("data/in/*")
	private Resource[] inputResources;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
  
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ProcessadorService processadorService;
  
  private Step imprimeStep() {
    return stepBuilderFactory.get("imprimeStep").tasklet(new Tasklet() {
      @Override
      public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Inicio");
        
        for (Resource resource : inputResources) {
        	String retorno = processadorService.processar(resource.getFile());
        	processadorService.escreverSaida( resource.getFile().getName(), retorno);
		}
        
        System.out.println("Fim");
        
        return RepeatStatus.FINISHED;
      }
    }).build();
  }
  
  @Bean
  public Job imprimeJob() {
    return jobBuilderFactory.get("imprimeJob").start(imprimeStep()).build();
  }
  
  
}
