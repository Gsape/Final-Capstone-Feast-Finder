<template>
  <div>
  <header>
    <h1>Feast Finder</h1>
    <img src="GitForkedLogo (1).png" alt="logo" class="logo">
    </header>
  <div class="home">
    <nav-bar />
    <single-card class="navigation" />
  </div>
  </div>
</template>

<script>
import NavBar from '../components/NavBar.vue';
import SingleCard from "../components/SingleCard.vue"

export default {
  name: "home",
  components: { SingleCard, NavBar }
};
</script>

<style scoped>

.home {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: flex-start;
}

/* .logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
} */

.navigation {
 display: flex;
 flex-grow: 1;
 

}

header {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-content: flex-start;
  border-bottom: solid, 10px, black;
}

header > img {
  max-width: 10%;
  margin-top: -20px;
  margin-right: 10px;
  flex-grow: 1;
}

header > h1 {
  margin-left: 20px;
  margin-top: 5px;
  flex-grow: 2;
  justify-content: flex-start;
}
</style>
