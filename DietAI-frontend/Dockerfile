FROM node:16.16.0 as build-step
RUN mkdir -p /usr/local/app
WORKDIR /usr/local/app
COPY ./ /usr/local/app
RUN npm install
RUN npm run build --prod

FROM nginx:1.23.1
RUN rm -rf /usr/share/nginx/html/*
COPY --from=build-step /usr/local/app/dist/diet-ai-frontend /usr/share/nginx/html

# Configuración de Nginx para manejar las rutas de Angular
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80


#docker build -t frontend:1.0 .
#docker image list
#docker login
#hub.docker.com
#docker tag frontend:1.0 jimmysm1995/frontend:1.0
#docker push jimmysm1995/frontend:1.0