FROM node:10-alpine as node
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
FROM nginx:alpine
COPY --from=node /usr/src/app/dist/CalculatorFrontS /usr/share/nginx/html
