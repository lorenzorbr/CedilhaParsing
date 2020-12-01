# DesafioAgibank
Desafio para implementar um sistema de tratamento de entradas com caracter especial(cedilha)
# Introdução : 
Esse é um codigo de validação de dados em um arquivo texto, dentro de uma pasta, onde possui como saída os dados do arquivo de entrada formatados, encontrados na pasta 'FileOut'. A cada 5 segundo é verificado alguma mudança no conteúdo do arquivo, caso sim, uma nova escrita será feita no arquivo de saída. O conteúdo do arquivo é convertido para o formato MD5 para fins de facilitar a verificação de mudanças internas.
# Como Rodar : 
Possuir o java instalado na máquina, a partir da versão 8. Simplesmente executar o código através da classe main. Caso seja alterado o conteúdo de um dos arquivos texto, após no máximo 5 segundos, existirá uma nova saída para o mesmo.
# Mudando a Entrada : 
Para isso, insira um novo arquivo do tipo txt na pasta 'FileInput', se o arquivo não possuir o mesmo formato dos arquivos presentes no exemplo, será invalidado.
# Observações : 
Só serão considerados válidos CPFs e CNPJs corretos e, não quaisquer números arbitrários, pode-se gerar um CPF ou CNPJ válido em um gerador de CPF/CNPJ. Versao do SDK: 14.0.2
