// App.vue

<template>
  <div id="app" class="container">
    <nav class="navbar navbar-expand-sm   navbar-light bg-light">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link :to="{ name: 'IndexEcole' }" class="nav-link">Ecoles</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{ name: 'IndexClasse' }" class="nav-link">Classes</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{ name: 'IndexEtudiant' }" class="nav-link">Etudiant</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{ name: 'IndexMatiere' }" class="nav-link">Matiere</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{ name: 'CalculMoyenne' }" class="nav-link">Notes</router-link>
        </li>
      </ul>
    </nav>
    <transition name="fade">
      <div class="gap">
        <router-view></router-view>        
      </div>
    </transition>
  </div>
</template>

<script>

export default {
}
</script>

<style>
    .fade-enter-active, .fade-leave-active {
      transition: opacity .5s
    }
    .fade-enter, .fade-leave-active {
      opacity: 0
    }
    .gap {
      margin-top: 50px;
    }
</style>