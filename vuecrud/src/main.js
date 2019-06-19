// main.js

import Vue from 'vue'
import VueRouter from 'vue-router';
import VueAxios from 'vue-axios';
import axios from 'axios';
import NProgress from 'nprogress';

import App from './App.vue';
import CreateEcole from './components/ecole/CreateEcole.vue';
import EditEcole from './components/ecole/EditEcole.vue';
import IndexEcole from './components/ecole/IndexEcole.vue';

import CreateClasse from './components/classes/CreateClasse.vue';
import EditClasse from './components/classes/EditClasse.vue';
import IndexClasse from './components/classes/IndexClasse.vue';

import CreateEtudiant from './components/etudiant/CreateEtudiant.vue';
import EditEtudiant from './components/etudiant/EditEtudiant.vue';
import IndexEtudiant from './components/etudiant/IndexEtudiant.vue';

import CreateMatiere from './components/matiere/CreateMatiere.vue';
import EditMatiere from './components/matiere/EditMatiere.vue';
import IndexMatiere from './components/matiere/IndexMatiere.vue';

import AddNote from './components/notes/AddNote.vue';
import EditNote from './components/notes/EditNote.vue';
import CalculMoyenne from './components/notes/CalculMoyenne.vue';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/nprogress/nprogress.css';

Vue.use(VueRouter);
Vue.use(VueAxios, axios);

Vue.config.productionTip = false;

const routes = [
  {
    name: 'CreateEcole',
    path: '/createEcole',
    component: CreateEcole
  },
  {
    name: 'EditEcole',
    path: '/editEcole',
    component: EditEcole
  },
  {
    name: 'IndexEcole',
    path: '/indexEcole',
    component: IndexEcole
  },
  {
    name: 'IndexClasse',
    path: '/indexClasse',
    component: IndexClasse
  },
  {
    name: 'CreateClasse',
    path: '/createClasse',
    component: CreateClasse
  },
  {
    name: 'EditClasse',
    path: '/editClasse',
    component: EditClasse
  },
  {
    name: 'IndexEtudiant',
    path: '/indexEtudiant',
    component: IndexEtudiant
  },
  {
    name: 'CreateEtudiant',
    path: '/createEtudiant',
    component: CreateEtudiant
  },
  {
    name: 'EditEtudiant',
    path: '/editEtudiant',
    component: EditEtudiant
  },
  {
    name: 'IndexMatiere',
    path: '/indexMatiere',
    component: IndexMatiere
  },
  {
    name: 'CreateMatiere',
    path: '/createMatiere',
    component: CreateMatiere
  },
  {
    name: 'EditMatiere',
    path: '/editMatiere',
    component: EditMatiere
  },
  {
    name: 'CalculMoyenne',
    path: '/calculMoyenne',
    component: CalculMoyenne
  },
  {
    name: 'AddNote',
    path: '/addNote',
    component: AddNote
  },
  {
    name: 'EditNote',
    path: '/editNote',
    component: EditNote
  }
];

const router = new VueRouter({ mode: 'history', routes: routes });

router.beforeResolve((to, from, next) => {
  if (to.name) {
      NProgress.start()
  }
  next()
});

router.afterEach(() => {
  NProgress.done()
});

new Vue({
  render: h => h(App),
  router
}).$mount('#app')