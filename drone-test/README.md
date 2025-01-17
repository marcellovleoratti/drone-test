Instruções:

•   	Utilizar qualquer IDE de preferência (Eclipse, Intellij, etc)   
•	    Para envio da avaliação criar branch no seguinte formato test/seunomecompleto  
•   	Usar classe test para validação dos resultados  
•   	Será avaliado limpeza de código e identação, tais como lógica para resolução dos problemas e utilização de recursos java               
•	    Comentar o código explicando o que for relevante para a solução do problema.

Problema:


•	Implementar um algoritmo para o controle de posição de um drone em um plano cartesiano (X, Y).

•	O ponto inicial do drone é "(0, 0)" para cada execução do método changePosition ao ser executado cada teste unitário.

•	A string de entrada pode conter os seguintes caracteres N, S, L, e O representando Norte, Sul, Leste e Oeste, respectivamente.

•	Estes caracteres podem estar presentes aleatoriamente na string de entrada.

•	Uma string de entrada "NNNLLL" irá resultar em uma posição final "(3, 3)", assim como uma string "NLNLNL" irá resultar em "(3, 3)".

•	Caso o caractere X esteja presente, o mesmo irá cancelar a operação anterior.

•	Caso houver mais de um caractere X consecutivo, o mesmo cancelará mais de uma ação na quantidade em que o X estiver presente.

•	Uma string de entrada "NNNXLLLXX" irá resultar em uma posição final "(1, 2)" pois a string poderia ser simplificada para "NNL".

•	Além disso, um número pode estar presente após o caractere da operação, representando o "passo" que a operação deve acumular.

•	Este número deve estar compreendido entre 1 e 2147483647.

•	Deve-se observar que a operação 'X' não suporta opção de "passo" e deve ser considerado inválido.

•	Uma string de entrada "NNX2" deve ser considerada inválida.

•	Uma string de entrada "N123LSX" irá resultar em uma posição final "(1, 123)", pois a string pode ser simplificada para "N123L".

•	Uma string de entrada "NLS3X" irá resultar em uma posição final "(1, 1)" pois a string pode ser simplificada para "NL".

•	Caso a string de entrada seja inválida ou tenha algum outro problema, o resultado deve ser "(999, 999)". 
