FROM node:18-alpine

WORKDIR /app

# Copia os arquivos de dependências
COPY package*.json ./

# Instala as dependências do projeto
RUN npm install

# Copia todo o código-fonte
COPY . .

# Expõe a porta padrão usada pelo Render
EXPOSE 10000

# Comando para iniciar a aplicação
CMD ["npm", "start"]