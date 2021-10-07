FROM node:15
RUN apt-get update \
&& apt-get upgrade -y \
&& apt-get install build-essential -y
WORKDIR /app
COPY ./client/ /app
RUN npm install
CMD ["npm", "run", "start"]