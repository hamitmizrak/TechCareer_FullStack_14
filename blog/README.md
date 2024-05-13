# Script Start
npm run start

## Npm Komutları
```sh
node -v
npm  -v

# package.json oluşturmak dikkat proje ismi: 
# 1-) küçük harflerle
# 2-) boşluklar olmamalıdır bunun yerine (-) 
# 3-) üğşçö kullanma
npm init 
npm init -y

# package.json içindeki kütüphaneleri proje dahil etmek için kullanıyoruz.
npm install 
npm i

# local npm'e neler yüklemişim 
npm list   => LOCAL

# Global npm'e neler yüklemişim 
npm list -g  => GLOCAL

# Global npm'e neler yüklemişim 
# --depth=0 sadece ana yüklediğim dosyaları göster 
npm list -g --depth=0

# npm Localde nereye yüklenmiş
npm root 

# npm Globalde nereye yüklenmiş.
# C:\Users\90553\AppData\Roaming\npm\node_modules
npm root -g

# SEARCH
# npm üzerinde arama yapmak için kullanıyoruz.
npm search express 
npm search mocha 

# INSTALL 
# --save (Production ortamında kurulması gerekiyor)
npm install -g bower --save
npm install  express --save
npm install  express@4.18.1 --save # Semantic Version: 4.18.1 

# -dev (Test ortamında kurulması)
npm install mocha --save-dev
npm install tailwindcss -D

# DELETE
npm unistall express 

# UPDATE
npm update # Bütün bağımlılıkları güncellemek
npm update express 
```

## Nodemon
```sh
normalde: node index 
nodemonla birlikte: nodemon index otomatikleştiriyoruz.
npm install 
npm search nodemon
npm install nodemon --save

-g: global
-q: terminalde az açıklamalar görünsün

npm install -g nodemon --save 
npm install -g nodemon --save-dev
nodemon index.js 
nodemon -q index.js 

"scripts": {
    "nodemon": "nodemon index.js",
    "nodemon_q": "nodemon -q index.js",
}

npm run nodemon
npm run nodemon_q
```


---
### `npm start`
### `npm test`
### `npm run build`
### `npm run eject`
### `npm run build` fails to minify

## REACT JS INSTALL
``sh
npm install -g create-react-app
npx create-react-app blog


npm install axios --save
npm install react-router-dom --save
npm install i18next --save
npm install react-i18next --save
npm install nodemon --save-dev
npm install -g nodemon

npm install
cd blog
npm start

#### backend with frontend connectivity
npm install axios --save

#### for Router
npm install react-router-dom --save

#### for language
npm install i18next --save              
npm install react-i18next --save

#### LocalStorage Bilgileri gizle
npm install secure-ls --save

#### Redux
npm install redux react-redux --save

#### middleWare
npm install redux-thunk
```
----------------------------------------------------------------
## TAILWIND INSTALL
#### Package.json yoksa ekle, yoksa ekleme
npm init -y

#### D: Developer
npm install -D tailwindcss 

####  tailwind.config.js
npx tailwindcss init 
```sh 
/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
      "./src/**/*.{js,jsx,ts,tsx}",
    ],
    theme: {

        container: {
            center: true
        },

        extend: {
            colors: {
                "hamitmizrak-red": "red",
                "hamitmizrak-blue": "blue",
                "hamitmizrak-yellow": "yellow",
                "hamitmizrak-gray": "#f2f2f2",
            },
            fontFamily: {
                font: ['Montserrat', 'sans-serif'],
                open: ['Open Sans', 'sans-serif'],
            }
        },
    },
    plugins: [],
}

```


#### dizin oluştur (src) ancak react zaten var tekrardan kurma
css eklemek => tailwind_input.css
npx tailwindcss -i ./src/tailwind_input.css -o ./src/index.css --watch
npm run watch

## NOT: package.json olduğu dizine bunları ekliyoruz.
#### for React JS , Tailwind
npm install -D tailwindcss
npx tailwindcss init

---
tailwind.config.js
/** @type {import('tailwindcss').Config} */
module.exports = {
content: [
"./src/**/*.{js,jsx,ts,tsx}",
],
theme: {

        container: {
            center: true
        },

        extend: {
            colors: {
                "hamitmizrak-red": "red",
                "hamitmizrak-blue": "blue",
                "hamitmizrak-yellow": "yellow",
                "hamitmizrak-gray": "#f2f2f2",
            },
            fontFamily: {
                font: ['Montserrat', 'sans-serif'],
                open: ['Open Sans', 'sans-serif'],
            }
        },
    },
    plugins: [],
}


---
index.css
@tailwind base;
@tailwind components;
@tailwind utilities;

--- 
App.js
export default function App() {
return (
<h1 className="text-3xl font-bold underline">
Hello world!
</h1>
)
}

------------------------------------------------------------------------------
# Spring Boot & React JS
![](https://komarev.com/ghpvc/?username=hamitmizrak)
## _N-Tier Architecture_

[![N|GitHub](https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/GitHub_Invertocat_Logo.svg/200px-GitHub_Invertocat_Logo.svg.png)](https://github.com/hamitmizrak/FullStackDeveloper12.git)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/hamitmizrak/FullStackDeveloper12.git)
![README PNG](./image/readme.png)

---
## Blog Project:
Spring Boot And React JS

- Backend: Java Core, Spring Framework
- Frontend:  React JS, JS, +ES5
- 🎁 BLOG
--- 

## TECHNOLOGY && Features
- HTML5
- CSS3
- RESPONSIVE DESIGN
- JS
- BOOTSTRAP5
- JQUERY
- JAVASCRIPT
- SQL
- H2DB
- MYSQL
- POSTGRESQL
- JAVA CORE
- SPRING FRAMEWORK
- SPRING BOOT
---

## Libraries && Programming
- Thymeleaf
- Lombok
- Validation
- Mysql
- Postgresql
- Model Mapper
- Password Encoder
- Open Api Configuration
- H2DB
- MYSQL
- POSTGRESQL
- JAVA CORE
- SPRING FRAMEWORK
- SPRING BOOT

---



---
Support
As [Hamit Mızrak] writes on the [Markdown site][hm]

> Who am I:
> Computer Engineering  
> Senior Full Stack Developer & DEVOPS & MOBIL APP

[Mail Addres ](hamitmizrak@gmail.com)
[Tel](hamitmizrak@gmail.com)

---
## Road Map
My Project Road Map
- [Install](#Installation)
- [Plugin](#plugins-data)
- [VS Code](#vs-code-extensions)
- [Google Chrome](#google-chrome-plugins)
- [Port](#port)
- [Docker](#docker)

And of course Dillinger itself is open source with a [public repository][dill]
on GitHub.
---

## Installation
Dillinger requires [Node.js](https://nodejs.org/) v10+ to run.
REACT JS

```sh
npm -v
node -v
npx create-react-app blog
npm i
cd blog
npm start
```
---

## Plugins Data
Dillinger is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| GitHub | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |
---

## VS CODE EXTENSIONS
```sh
- Browser preview
- Auto Close tag
- tabnine
- Auto import
- Auto rename tag
- Bootstrap 5 Quick Snipperts
- Bracket Pair Colorizer 2
- Css Snippet
- Es7+ React/REdux/React-Native snippets
- Html Snippets
- JsQuery Snippets
- Live Server
- Material Icon Theme
- Open-in-Browser
- Path Intellisense
- Prettier Code formatter
- Project Manager
- Reactjs code Snippets
```
---

## Google Chrome Plugins
for project , plugins

| Google | CHROME |
| ------ | ------ |
| React Developer Tools | [React Developer Tools][RTool] |
| React DevTools | [React Devtool][RDevtool] |
| Google Drive | [Frontend][FRONTEND] |
| OneDrive | [Backend][BACKEND] |
---

## PORT
for project , Port

| NAME | PORT |
| ------ | ------ |
| React JS| [React][http://localhost:3000] |
| SPRING| [Spring][http://localhost:4444] |
| H2-CONSOLE| [H2][http://localhost:4444/h2-console] |
| SWAGGER| [API DOCUMENT][http://localhost:4444/swagger-ui.html] |
---

## Docker
Project Deployment
```sh
*STEP-1*
npx create-react-app frontend
cd frontend
npm start
code .

*STEP-2*
NOT: node_modules siliyoruz bunu sonrasında
npm i

*STEP-3*
terminal: package.json seviyesinde olacak şekilde
npm install axios
npm install bootstrap --save
npm install node-sass --save
```

port 8080 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker-compose up -d
docker-compose down
Dockerfile build -t .

docker container run -d -p 4444:4444 --name backend blog
docker run -d -p 8000:8080 --restart=always --cap-add=SYS_ADMIN --name=dillinger <youruser>/dillinger:${package.json.version}
```

```sh
127.0.0.1:4444
```

## License

**BLOG PROJECT !**

[//]: # (Variable)
[RTool]: <https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi>
[RDevtool]: <https://chrome.google.com/webstore/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd>
[FRONTEND]: <https://github.com/denemed>
[BACKEND]: <https://github.com/denemed>

[hm]: <https://github.com/hamitmizrak>
[markdown-it]: <https://github.com/markdown-it/markdown-it>
[Ace Editor]: <http://ace.ajax.org>
[node.js]: <http://nodejs.org>
[Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
[jQuery]: <http://jquery.com>
[@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
[express]: <http://expressjs.com>
[AngularJS]: <http://angularjs.org>